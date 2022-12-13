package view;

import java.util.ArrayList;
import java.util.Scanner;

import model.NewsVO;
import model.UserVO;

public class View {

	// 멤버변수
	Scanner sc; // 스캐너
	int mact; // 메인화면 act 숫자
	int sact; // 서비스화면 act 숫자

	public View() {
		sc = new Scanner(System.in);
		mact = 3;
		sact = 5;
	}

	// [메인 화면 출력]
	public int printMain() {
		int act;
		while (true) {
			try {
				System.out.println("===메인 화면===");
				System.out.println("1. 로그인");
				System.out.println("2. 회원가입");
				System.out.println("3. 프로그램 종료");
				System.out.print("입력>> ");
				act = sc.nextInt();
			} catch (Exception e) {
				System.out.println("잘못 입력하셨습니다, 정수 입력하세요!");
				continue;
			}
			if (0 < act && act <= mact) {
				break;
			}
			System.out.println("범위를 잘못 입력하셨습니다, 다시 입력하세요!");
			continue;
		}
		return act;
	}

	// [서비스 화면 출력]
	public int printService() {
		int act;
		while (true) {
			try {
				System.out.println("===서비스 화면===");
				System.out.println("1. 전체 기사 목록");
				System.out.println("2. 제목(키워드) 검색");
				System.out.println("3. 카테고리 검색");
				System.out.println("4. 회원탈퇴");
				System.out.println("5. 로그아웃");
				System.out.print("입력>> ");
				act = sc.nextInt();
			} catch (Exception e) {
				System.out.println("잘못 입력하셨습니다, 정수 입력하세요!");
				continue;
			}
			if (0 < act && act <= sact) {
				break;
			}
			System.err.println("범위를 잘못 입력하셨습니다, 다시 입력하세요!");
			continue;
		}
		return act;
	}

	// [id 입력]
	public String getId() {
		System.out.print("ID 입력>> ");
		String id = sc.next();
		return id;
	}

	// [pw 입력]
	public String getPw() {
		System.out.print("PW 입력>> ");
		String pw = sc.next();
		return pw;
	}

	// [이름 입력]
	public String getName() {
		System.out.print("이름 입력>> ");
		String name = sc.next();
		return name;
	}

	// [회원가입 완료시 멘트]
	public void insertTrue(UserVO uvo) {
		System.out.println("회원가입 성공!");
		System.out.println(uvo.getId() + "님, 반갑습니다:D");
	}

	// [회원가입시, pw 더블체크]
	public boolean douPw(UserVO uvo) {
		System.out.print("한번 더 PW 입력>> ");
		String prepw = sc.next();
		if (uvo.getPw().equals(prepw)) {
			return true;
		}
		return false;
	}

	// [회원가입 실패시 멘트]
	public void insertFalse() {
		System.out.println("회원가입 실패..다시 회원가입 해주세요!");
	}

	// [로그인 입력]
	public UserVO login() {
		System.out.println();
		System.out.println("=== 로그인 ===");
		System.out.print("ID 입력 >> ");
		String id = sc.next();
		System.out.print("PW 입력 >> ");
		String pw = sc.next();
		System.out.println("=============");
		UserVO vo = new UserVO();
		vo.setId(id);
		vo.setPw(pw);
		return vo;
	}

	// [로그인 성공시 멘트]
	public void loginTrue(UserVO uvo) {
		System.out.println(uvo.getId() + "님, 안녕하세요 :D");
	}

	// [로그인 실패시 멘트]
	public void loginFalse() {
		System.out.println("로그인 실패하셨습니다..다시 시도해주세요.");
	}

	// [프로그램 종료]
	public void programOff() {
		System.out.println("프로그램 종료합니다~");
	}

	// [제목(키워드) 검색 입력]+유효성검사
	public String getTitle() {
		String searchContent = null;
		while (true) {
			try {
				System.out.println("[제목(키워드) 검색]");
				System.out.print("제목(키워드) 입력>> ");
				searchContent = sc.next();
				return searchContent;
			} catch (Exception e) {
				System.out.println("예기치 못한 오류입니다, 다시 시도해주세요.");
				continue;
			}
		}
	}

	// [카테고리 검색 입력]+유효성검사
	public String getCate() {
		String searchContent;
		while (true) {
			try {
				System.out.println("[카테고리 검색]");
				System.out.print("카테고리 입력>> ");
				searchContent = sc.next();
				return searchContent;
			} catch (Exception e) {
				System.out.println("잘못 입력하셨습니다, 문자로 입력해주세요.");
				continue;
			}
		}
	}

	// [카테고리 검색 성공 멘트]
	public void cateTrue() {
		System.out.println("검색 시작합니다!");
	}

	// [카테고리 검색 실패 멘트]
	public void cateFalse() {
		System.out.println("없는 카테고리 입니다, 다시 입력해주세요");
	}

	// [검색 찾는중...]
	public void ing() {
		for (int i = 0; i < 5; i++) {
			System.out.print(".");
			try {
				Thread.sleep(250);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		System.out.println("==>> 검색 완료");
	}

	// [검색 목록 출력]
	public void printDatas(ArrayList<NewsVO> datas) {
			for (NewsVO v : datas) {
				System.out.println(v);
		}
	}

	// [검색 성공시 멘트]
	public void searchTrue() {
		System.out.println("검색 결과 입니다!");
	}

	// [검색 실패시 멘트]
	public void searchFalse() {
		System.out.println("검색 결과 없습니다.. ");
	}

	// [회원탈퇴 확인 멘트]
	public boolean deleteCheck(UserVO uvo) {
		String ans;
		while (true) {
			try {
				System.out.println(uvo.getId() + "님, 정말 회원탈퇴 하시겠습니까? [Y/N]");
				System.out.print("입력>>");
				ans = sc.next();
			} catch (Exception e) {
				System.out.println("잘못 입력하셨습니다, 문자 입력하세요!");
				continue;
			}
			if (ans.equals("Y")) {
				return true;
			} else if (ans.equals("N")) {
				return false;
			}
			System.out.println("잘못 입력하셨습니다, 다시 입력하세요!");
			continue;
		}
	}

	// [회원탈퇴 성공]
	public void deleteTrue() {
		for (int i = 0; i < 3; i++) {
			System.out.println(".");
			try {
				Thread.sleep(250);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		System.out.println("회원탈퇴 성공입니다. 다음에 또 뵈어요:D");
	}

	// [회원탈퇴 실패]
	public void deleteFalse() {
		System.out.println("회원탈퇴 실패입니다..관리자에게 문의해주세요.");
	}

	// [로그아웃]
	public void logout() {
		System.out.println("로그아웃 되셨습니다.");
	}

}