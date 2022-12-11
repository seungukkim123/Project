package view;

import java.util.ArrayList;
import java.util.Scanner;

import model.MemberVO;
import model.ProductVO;

public class View {
	private Scanner sc;

	public View() {
		sc = new Scanner(System.in);
	}

	public int printMain() {
		// 1. 사용자의 입력 값을 검사 == 유효성 검사
		// 2. 사용자에게 상황을 안내 == 사용자 편의성 고려
		int act;
		while (true) {
			try {
				System.out.println("=== 메인화면 ===");
				System.out.println("1. 로그인");
				System.out.println("2. 회원가입");
				System.out.println("4. 프로그램 종료");
				System.out.print(">>> ");
				act = sc.nextInt();
			} catch (Exception e) {
				sc.nextLine();
				System.out.println("정수로 다시 입력해주세요!");
				continue;
			}
			if (1 <= act && act <= 3) {
				break; 
			}
			System.out.println("범위를 확인하고 다시 입력해주세요!");
		}
		return act; 
	}

	public int admin() {
		int act;
		while (true) {
			try {
				System.out.println("==============");
				System.out.println("관리자 페이지");
				System.out.println("1. 상품 목록 출력");
				System.out.println("2. 상품 추가");
				System.out.println("3. 상품 삭제");
				System.out.println("4. 상품 정보 변경");
				System.out.println("5. 로그아웃");
				System.out.print(">>> ");
				act = sc.nextInt();
				System.out.println("==============\n");
			} catch (Exception e) {
				System.out.println("정수로 다시 입력해주세요");
				continue;
			}
			return act;
		}
	}

	public void powerOff() {
		for (int i = 0; i < 5; i++) {
			System.out.println(".");
			try {
				Thread.sleep(300);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		System.out.println("프로그램 종료");
	}

	public MemberVO login() {
		System.out.println();
		System.out.println("======== 로그인 ========");
		System.out.print("ID: ");
		String id = sc.next();
		System.out.print("PW: ");
		String pw = sc.next();
		System.out.println("======================");
		MemberVO vo = new MemberVO();
		vo.setId(id);
		vo.setPw(pw);
		return vo;
	}

	public String updateName() {
		System.out.println();
		System.out.print("변경할 이름 입력: ");
		String name = sc.next();
		return name;
	}

	public String updatePw() {
		System.out.println();
		System.out.print("변경할 PW 입력: ");
		String pw = sc.next();
		return pw;
	}

	public String getproductName() {
		System.out.print("상품이름 입력: ");
		String name = sc.next();
		return name;
	}

	public int getprice() {
		System.out.print("가격 입력: ");
		int price = sc.nextInt();
		return price;
	}

	public int getPk() {
		System.out.print("품번 입력: ");
		int pk = sc.nextInt();
		return pk;
	}

	public int getstock() {
		System.out.print("재고 입력: ");
		int stock = sc.nextInt();
		System.out.println();
		return stock;
	}

	public String getId() {
		System.out.print("ID 입력: ");
		String id = sc.next();
		return id;
	}

	public String getPW() {
		System.out.print("PW 입력: ");
		String pw = sc.next();
		return pw;
	}

	public String getName() {
		System.out.print("이름 입력: ");
		String name = sc.next();
		return name;
	}

	public void loginTrue(MemberVO vo) {
		System.out.println(vo.getName() + "님, 안녕하세요! :D\n");
	}

	public void loginFalse() {
		System.err.println("아이디 혹은 비밀번호를 확인해주세요!");
	}

	public void logout() {
		System.out.println("로그아웃 되었습니다.\n");
	}

	public int printMenu() {
		int act;
		while (true) {
			try {
				System.out.println("==============");
				System.out.println("회원 페이지");
				System.out.println("1. 상품 목록 출력");
				System.out.println("2. 상품 구매");
				System.out.println("3. 회원 정보 변경");
				System.out.println("4. 로그아웃");
				System.out.print(">>> ");
				act = sc.nextInt();
				System.out.println("==============");
			} catch (Exception e) {
				sc.nextLine();
				System.out.println("정수로 다시 입력해주세요!");
				continue;
			}
			return act;
		}
	}

	public void printProductMenu(ArrayList<ProductVO> datas) {
		System.out.println("================== 상품 목록 ==================");
		for (ProductVO v : datas) {
			System.out.println(
					"품번 [" + v.getNum() + "] " + v.getName() + " " + v.getPrice() + "원 [" + v.getStock() + "]");
		}
		System.out.println("=============================================\n");
	}

	public int buyProduct(ArrayList<ProductVO> datas) {
		System.out.println();
		System.out.println("================== 상품 목록 ==================");
		for (ProductVO v : datas) {
			System.out.println(
					"품번 [" + v.getNum() + "] " + v.getName() + " " + v.getPrice() + "원, " + v.getStock() + "개");
		}
		System.out.print("구매할 상품번호 >> ");
		int num = sc.nextInt();
		System.out.println("============================================");
		return num;
	}

	public void buyTrue(MemberVO mvo, ProductVO pvo) {
		System.out.println("");
		System.out.println("================== 영수증 ==================");
		System.out.println(pvo.getName() + " " + pvo.getPrice() + "원");
		System.out.println(mvo.getName() + "님, " + pvo.getName() + "를(을) 구매 완료 했습니다.");
		System.out.println("==========================================\n");
	}
	public void buyFalse() {
		System.out.println("구매 실패...");
	}
	public void updateTrue() {
		System.out.println("변경 성공!!");
	}
	public void updateFalse() {
		System.out.println("변경 실패..");
	}
}
