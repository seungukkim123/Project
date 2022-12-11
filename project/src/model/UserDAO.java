package model;

import java.util.ArrayList;
import java.util.Scanner;

public class UserDAO {
	ArrayList<UserVO> udatas;

	public UserDAO() {
		udatas = new ArrayList<UserVO>();

		udatas.add(new UserVO("admin", "admin", "관리자"));
		udatas.add(new UserVO("hello", "1234", "사용자"));
	}

	// 로그인
	public UserVO selectOne(UserVO uvo) {
		for (int i = 0; i < udatas.size(); i++) {
			if (udatas.get(i).getId().equals(uvo.getId())) {
				System.out.println("  로그: 아이디 일치");
				if (udatas.get(i).getPw().equals(uvo.getPw())) {
					System.out.println("  로그: 비밀번호 일치");
					System.out.println("  로그: 로그인 성공!!");
					return udatas.get(i);
				}
			}
		}
		System.err.println("  로그: 로그인 실패..");
		return null;
	}

	// 회원가입(사용자 측면)
	public boolean signuUp(UserVO uvo) {
		try {
			udatas.add(new UserVO(uvo.getId(), uvo.getPw(), uvo.getName()));
			System.out.println("  로그: 회원가입 성공!!");
		} catch (Exception e) {
			System.err.println("  로그: 회원가입 실패..");
			return false;
		}
		return true;
	}

	// 회원탈퇴(사용자측면)
	public boolean delete(UserVO uvo) {
		for (int i = 0; i < udatas.size(); i++) {
			if (udatas.get(i).getId().equals(uvo.getId())) {
				if (udatas.get(i).getPw().equals(uvo.getPw())) {
					udatas.remove(i);
					System.out.println("  로그: 삭제 성공!!");
				}
				return true;
			}
		}
		System.err.println("  로그: 삭제 실패..");
		return false;
	}

	// 변경 항목 선택
	public int choice() {
		System.out.println("1. 아이디 변경 2. 비밀번호 변경");
		System.out.print("입력: ");
		int num = new Scanner(System.in).nextInt();
		return num;
	}

	// 회원 정보 변경
	public boolean update(UserVO uvo) {
		for (int i = 0; i < udatas.size(); i++) {
			if (uvo.getId() != null) {
				udatas.get(i).setId(uvo.getId());
				System.out.println("  로그: 아이디 변경 성공!!");
			} else {
				udatas.get(i).setPw(uvo.getPw());
				System.out.println("  로그: 비밀번호 변경 성공!!");
			}
			return true;
		}
		System.err.println("  로그: 정보 변경 실패..");
		return false;
	}

}
