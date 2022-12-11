package model;

import java.util.ArrayList;
import java.util.Scanner;

public class adminDAO {
	ArrayList<adminVO> ndatas;
	int pk;

	public adminDAO() {
		ndatas = new ArrayList<adminVO>();
		pk = 101;
		ndatas.add(new adminVO(pk++, "IT 일반", "“삼성 배신하고 만들더니” 미국 자랑한 ‘접는폰’ 실체 엉터리?",
				"사실상 구글의 첫 ‘폴더블’(접는) 스마트폰인 ‘구글 픽셀 폴드’가 출시 이전부터 혹평을 받고 있다. "
						+ "픽셀 폴드로 추정되는 제품의 긱벤치(Geekbench) 점수가 삼성전자 갤럭시Z폴드4와 비교해 터무니없이 "
						+ "낮게 나타난 것이다. 그동안 삼성전자 갤럭시 스마트폰과 긴밀한 협력 관계를 맺었던 구글로서는 다소 ‘민망한’ 결과다. "));
	}

	// 전체 기사 출력(사용자 출력)
	public ArrayList<adminVO> selectAll(adminVO nvo) {
		return ndatas;
	}

	// 제목으로 검색한 기사 출력(사용자 측면)
	public adminVO selectOne(adminVO nvo) {
		for (int i = 0; i < ndatas.size(); i++) {
			if (ndatas.get(i).getTitle() == nvo.getTitle()) {
				System.out.println("  로그: 기사 출력 성공!!");
				return ndatas.get(i);
			}
		}
		System.err.println("  로그: 기사 출력 실패..");
		return null;
	}

	// 기사 작성(관리자 측면)
	public boolean write(adminVO nvo) {
		try {
			ndatas.add(new adminVO(nvo.getNum(), nvo.getCategory(), nvo.getTitle(), nvo.getContents()));
			System.out.println("  로그: 작성 성공!!");
		} catch (Exception e) {
			System.err.println("  로그: 작성 실패..");
			return false;
		}
		return true;
	}

	// 기사 삭제(관리자 측면)
	public boolean delete(adminVO nvo) {
		for (int i = 0; i < ndatas.size(); i++) {
			if (ndatas.get(i).getNum() == nvo.getNum()) {
				ndatas.remove(i);
				System.out.println("  로그: 삭제 성공!!");
				return true;
			}
		}
		System.err.println("  로그: 삭제 실패..");
		return false;
	}

	// 수정 항목 선택(관리자 측면)
	public int choice() {
		System.out.println("1. 카테고리 변경 2. 제목 변경 3. 내용 변경");
		System.out.println(">>> ");
		int num = new Scanner(System.in).nextInt();
		return num;
	}

	// 기사 수정(관리자 측면)
	public boolean update(adminVO nvo) {
		for (int i = 0; i < ndatas.size(); i++) {
			if (ndatas.get(i).getNum() == nvo.getNum()) {
				if (nvo.getCategory() != null) {
					ndatas.get(i).setCategory(nvo.getCategory());
					System.out.println("  로그: 카테고리 변경 성공!!");
				} else if (nvo.getTitle() != null) {
					ndatas.get(i).setTitle(nvo.getTitle());
					System.out.println("  로그: 제목 변경 성공!!");
				} else {
					ndatas.get(i).setContents(nvo.getContents());
					System.out.println("  로그: 내용 변경 성공!!");
				}
				return true;
			}
		}
		System.err.println("  로그: 변경 실패");
		return false;
	}

}
