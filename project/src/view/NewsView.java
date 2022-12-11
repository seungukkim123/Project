package view;

import java.util.ArrayList;
import java.util.Scanner;

import model.adminVO;
import model.UserVO;

public class NewsView {
	private Scanner sc;

	public NewsView() {
		sc = new Scanner(System.in);
	}

	public int printMain() {
		int act;
		while (true) {
			try {
				System.out.println("=== 메인화면 ===");
				System.out.println("1. 로그인");
				System.out.println("2. 회원가입");
				System.out.println("3. 프로그램 종료");
				System.out.print(">>> ");
				act = sc.nextInt();
			} catch (Exception e) {
				sc.nextLine();
				System.err.println("정수로 다시 입력해주세요!");
				continue;
			}
			if (1 <= act && act <= 3) {
				break;
			}
			System.err.println("범위를 확인하고 다시 입력해주세요!");
		}
		return act;
	}

	// 관리자권한 페이지
	public int admin() {
		int act;
		while (true) {
			try {
				System.out.println("===============");
				System.out.println("1. 기사 목록 출력");
				System.out.println("2. 지정 기사 출력");
				System.out.println("3. 기사 작성");
				System.out.println("4. 기사 삭제");
				System.out.println("5. 기사 수정");
				System.out.println("6. 로그아웃");
				System.out.println(">>> ");
				act = sc.nextInt();
				System.out.println("===============\n");
			} catch (Exception e) {
				System.err.println("정수로 다시 입력해주세요!");
				continue;
			}
			return act;
		}
	}

	// 로그인 로직
	public UserVO login() {
		System.out.println();
		System.out.println("======== 로그인 ========");
		System.out.print("ID: ");
		String id = sc.next();
		System.out.print("PW: ");
		String pw = sc.next();
		System.out.println("======================");
		UserVO vo = new UserVO();
		vo.setId(id);
		vo.setPw(pw);
		return vo;
	}

	public String getId() {
		System.out.println("ID 입력: ");
		String id = sc.next();
		return id;
	}

	public String getPw() {
		System.out.print("PW 입력: ");
		String pw = sc.next();
		return pw;
	}

	public String getName() {
		System.out.print("이름 입력: ");
		String name = sc.next();
		return name;
	}

	public String getCategory() {
		System.out.print("카테고리 입력: ");
		String category = sc.next();
		return category;
	}

	public String getTitle() {
		System.out.print("제목 입력: ");
		String title = sc.next();
		return title;
	}

	public String updateId() {
		System.out.println("ID 입력: ");
		String id = sc.next();
		return id;
	}

	public String updatePw() {
		System.out.print("PW 입력: ");
		String pw = sc.next();
		return pw;
	}

	public int getNum() {
		System.out.print("기사 번호 입력: ");
		int pk = sc.nextInt();
		return pk;
	}

	public int User() {
		int act;
		while (true) {
			try {
				System.out.println("1. 기사 검색");
				System.out.println("2. 회원 정보 변경");
				System.out.println("3. 회원 탈퇴");
				System.out.println("4. 로그아웃");
				System.out.print(">>> ");
				act = sc.nextInt();
				System.out.println("");
			} catch (Exception e) {
				sc.nextLine();
				System.err.println("정수로 다시 입력해주세요!");
				continue;
			}
			return act;
		}
	}

	// 기사 목록 출력
	public void printNews(ArrayList<adminVO> datas) {
		System.out.println("기사 목록");
		for (adminVO v : datas) {
			System.out.println("[" + v.getNum() + "] 카테고리: " + v.getCategory() + ", 제목: " + v.getTitle() + "\n내용: "
					+ v.getContents() + "\n");
		}
	}

	public void selectNews(ArrayList<adminVO> datas, adminVO nvo) {
	}

	public void loginTrue(UserVO uvo) {
		System.out.println(uvo.getName() + "님, 안녕하세요! :D\n");
	}

	public void loginFalse() {
		System.err.println("아이디 혹은 비밀번호를 확인해주세요!");
	}

	public void updateTrue() {
		System.out.println("변경 성공!!");
	}

	public void updateFalse() {
		System.out.println("변경 실패..");
	}

	public void logout() {
		System.out.println("로그아웃 되었습니다.\n");
	}

	// 프로그램 종료
	public void programOff() {
		for (int i = 0; i < 5; i++) {
			System.out.print(".");
			try {
				Thread.sleep(300);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		System.out.println("프로그램을 종료합니다.");
	}

}
