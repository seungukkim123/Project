package ctrl;

import model.Crawling;
import model.NewsDAO;
import model.NewsVO;
import model.UserDAO;
import model.UserVO;
import view.View;

public class Ctrl {
	NewsDAO ndao;
	UserDAO udao;
	View view;

	public Ctrl() {
		ndao = new NewsDAO();
		udao = new UserDAO();
		view = new View();
		Crawling crawling = new Crawling(); // 크롤링 샘플은 다른 존재.
		crawling.politics(ndao);
		crawling.economy(ndao);
		crawling.society(ndao); // App에서 사용하는 model
	}

	public void startApp() {
		while (true) {
			int act = view.printMain();
			// 로그인
			if (act == 1) {
				UserVO uvo = view.login();
				uvo = udao.login(uvo);
				// 없는 계정이면
				if (uvo == null) {
					view.loginFalse();
					continue;
				}
				view.loginTrue(uvo);
				// user메서드 실행 값
				act = view.printService();
				// 기사 전체 출력
				if (act == 1) {
					view.printDatas(ndao.selectAll(null));
				}
				
				// 제목 검색
				else if (act == 2) {
					NewsVO nvo = new NewsVO();
					nvo.setTitle(view.getTitle());
					ndao.selectAll(nvo);
					view.ing();
					view.printDatas(ndao.searchTitle(nvo));
				}
				// 카테고리 검색
				else if (act == 3) {
					NewsVO nvo = new NewsVO();
					nvo.setCategory(view.getCate());
					ndao.selectAll(nvo);
					view.ing();
					view.printDatas(ndao.searchCategory(nvo));
				}
				// 회원탈퇴
				else if (act == 4) {
					uvo.setId(view.getId());
					boolean flag = udao.uDelete(uvo);
					if (!flag) {
						view.deleteFalse();
						continue;
					}
					udao.uDelete(uvo);
					view.deleteTrue();
				}
				// 로그아웃
				else if (act == 5) {
					view.logout();
					continue;
				}
			}
			// 회원가입
			else if (act == 2) {
				UserVO uvo = new UserVO();
				// ID 입력
				uvo.setId(view.getId());
				// ID 중복가 중복이라면 continue
				if (udao.overlapId(uvo)) {// 어려워용... ㅜㅜ
					// 컨트롤 던져!!!!!!!!!!!!!!
					// ㅈㅁㄴㅇㅈㅁㄴㅇ
					// 이거 키보드 저 주세요
					// ㅎㅎ
					view.loginFalse();
					continue;
				}
				// 비밀번호 입력
				uvo.setPw(view.getPw());
				// 비밀번호가 중복이라면 continue
				if (!view.douPw(uvo)) {
					view.insertFalse();
					continue;
				}
				// 이름입력
				uvo.setName(view.getName());
				// 입력한 값으로 회원가입
				udao.uInsert(uvo);
			}
			// 프로그램 종료
			else {
				view.programOff();
				break;
			}
		}
	}
}
