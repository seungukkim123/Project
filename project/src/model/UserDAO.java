package model;

import java.util.ArrayList;

public class UserDAO {
	ArrayList<UserVO> mdatas;

	// 샘플데이터
	public UserDAO() {
		mdatas = new ArrayList<UserVO>();
		mdatas.add(new UserVO("Lee", "1008", "이민호"));

	}

	// 회원가입
	public boolean uInsert(UserVO uvo) {
		for (int i = 0; i < mdatas.size(); i++) {
			if (mdatas.get(i).getId().equals(uvo.getId())) {
				System.out.println("  로그: 중복된 아이디입니다.");
				return false;
			}
		}
		mdatas.add(uvo);
		System.out.println("  로그: 회원가입성공");
		System.out.println("  로그:" + mdatas); // <로그확인
		return true;
	}

	// 회원탈퇴
	public boolean uDelete(UserVO uvo) {
		for (int i = 0; i < mdatas.size(); i++) {
			if (mdatas.get(i).getId().equals(uvo.getId())) {
				mdatas.remove(i);
				System.out.println("  로그: 삭제완료");
				System.out.println("  로그: 변경 후 출력" + mdatas);
				return true;
			}
		}
		System.out.println("  로그: 아이디를 다시 확인해주세요");
		return false;
	}

	// ID 중복 검사
	public boolean overlapId(UserVO uvo) {
		for (int i = 0; i < mdatas.size(); i++) {
			if (mdatas.get(i).getId().equals(uvo.getId())) {
				System.err.println("  로그: 중복된 ID");
				return true;
			}
		}
		System.out.println("  로그: 중복 확인");
		return false;
	}

	// 정보변경(이름,비밀번호)
	public boolean uUpdate(UserVO uvo) {
		for (int i = 0; i < mdatas.size(); i++) {
			if (mdatas.get(i).getId().equals(uvo.getId())) {
				if (uvo.getName() != null) {
					mdatas.get(i).setName(uvo.getName());
				} else {
					mdatas.get(i).setPw(uvo.getPw());
				}
				System.out.println("  로그: 정보변경 완료");
				System.out.println("  로그: 변경 후 출력" + mdatas);
				return true;
			}
		}
		System.out.println("  로그: 정보변경 실패");
		return false;
	}

	// 로그인
	public UserVO login(UserVO uvo) {
		for (int i = 0; i < mdatas.size(); i++) {
			// equalsIgnoreCase == 문자열의 대, 소문자를 구분하지 않고 비교해주는 함수입니다.
			if (mdatas.get(i).getId().equalsIgnoreCase(uvo.getId())) {
				System.out.println("  로그: 아이디 존재");
				if (mdatas.get(i).getPw().equals(uvo.getPw())) {
					System.out.println("  로그: 비밀번호 일치");
					System.out.println("  로그: 로그인 성공");
					return mdatas.get(i);
				}
			}
		}
		System.out.println("  로그: 로그인 실패");
		return null;
	}

}