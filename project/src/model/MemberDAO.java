package model;

import java.util.ArrayList;
import java.util.Scanner;
 
public class MemberDAO {
	ArrayList<MemberVO> mdatas;

	public MemberDAO() {
		mdatas = new ArrayList<MemberVO>();
		mdatas.add(new MemberVO("timo", "1234", "티모"));
		mdatas.add(new MemberVO("admin", "admin", "관리자"));
	}

	public MemberVO selectOne(MemberVO mvo) {
		for (int i = 0; i < mdatas.size(); i++) {
			if (mdatas.get(i).getId().equals(mvo.getId())) {
//				System.out.println("  로그: 아이디 존재함");
				if (mdatas.get(i).getPw().equals(mvo.getPw())) {
//					System.out.println("  로그: 비밀번호 일치함");
//					System.out.println("  로그: 로그인 성공");
					return mdatas.get(i);
				}
			}
		}
//		System.err.println("  로그: 비밀번호 불일치");
		return null;
	}

	public boolean singUp(MemberVO mvo) {
		try {
			mdatas.add(new MemberVO(mvo.getId(), mvo.getPw(), mvo.getName()));
//			System.out.println("  로그: 회원가입 성공!!");
		} catch (Exception e) {
//			System.err.println("  로그: 회원가입 실패..");
			return false;
		}
		return true;
	}

	public boolean delete(MemberVO mvo) {
		for (int i = 0; i < mdatas.size(); i++) {
			if (mdatas.get(i).getId().equals(mvo.getId())) {
				mdatas.remove(i);
//				System.out.println("  로그: 삭제 성공!!");
			}
			return true;
		}
//		System.err.println("  로그: 삭제 실패..");
		return false;
	}

	public int choice() {
		System.out.println("1. 이름 변경 2. 비밀번호 변경");
		System.out.print("입력: ");
		int num = new Scanner(System.in).nextInt();
		return num;
	}

	public boolean update(MemberVO mvo) {
		for (int i = 0; i < mdatas.size(); i++) {
			if (mdatas.get(i).getId().equals(mvo.getId())) {
				if (mvo.getName() != null) {
					mdatas.get(i).setName(mvo.getName());
//				System.out.println("  로그: 이름변경 성공");
				} else {
					mdatas.get(i).setPw(mvo.getPw());
//				System.out.println("  로그: PW변경 성공");
				}
				return true;
			}

		}
//		System.err.println("  로그: 정보변경 실패");
		return false;
	}

}
