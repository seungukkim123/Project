package model;

import java.util.ArrayList;
import java.util.Scanner;

public class ProductDAO {
	int PK;
	ArrayList<ProductVO> pdatas;

	public ProductDAO() {
		PK = 101;
		pdatas = new ArrayList<ProductVO>();
		pdatas.add(new ProductVO(PK++, "커피", 2500, 1));
		pdatas.add(new ProductVO(PK++, "케이크", 5000, 0));
		pdatas.add(new ProductVO(PK++, "홍차", 3200, 2));
	}

	public ArrayList<ProductVO> selectAll(ProductVO pvo) {
		return pdatas;
	}
	
	public ProductVO selectOne(ProductVO pvo) {
		for (int i = 0; i < pdatas.size(); i++) {
			if (pdatas.get(i).getNum() == pvo.getNum()) {
				return pdatas.get(i);
			}
		}
		return null;
	}

	public int pk() {
		System.out.print("품번 입력: ");
		int pk = new Scanner(System.in).nextInt();
		return pk;
	}

	public int choice() {
		System.out.println("1.상품명 변경 2.가격 변경 3.재고 변경");
		System.out.print("입력: ");
		int num = new Scanner(System.in).nextInt();
		return num;
	}

	public boolean update(ProductVO pvo) {
		try {
			for (int i = 0; i < pdatas.size(); i++) {
				if (pdatas.get(i).getNum() == pvo.getNum()) {
					if(pdatas.get(i).getStock() <= 0) {
						continue;
					}
					pdatas.get(i).setStock(pdatas.get(i).getStock() - 1);
					System.out.println("  로그: 구매 성공!!");
					return true;
				}
			}
		} catch(Exception e) {
			System.out.println("  로그: 구매 실패..");
		}
		return false;
	}

	public boolean insert(ProductVO pvo) {
		try {
			pdatas.add(new ProductVO(PK++, pvo.getName(), pvo.getPrice(), pvo.getStock()));
//			System.out.println("  로그: 상품추가 성공!!");
		} catch (Exception e) {
//			System.err.println("  로그: 상품추가 실패..");
			return false;
		}
		return true;
	}

	public boolean delete(ProductVO pvo) {
		for (int i = 0; i < pdatas.size(); i++) {
			if (pdatas.get(i).getNum() == pvo.getNum()) {
				pdatas.remove(i);
				System.out.println("  로그: 삭제 성공!!");
				return true;
			}
		}
//		System.err.println("  로그: 삭제 실패..");
		return false;
	}

	public boolean updateInfo(ProductVO pvo) {
		for (int i = 0; i < pdatas.size(); i++) {
			if (pdatas.get(i).getNum() == pvo.getNum()) {
				if (pvo.getName() != null) {
					pdatas.get(i).setName(pvo.getName());
//				System.out.println("  로그: 상품명 변경 성공!!");
				} else if (pvo.getPrice() != 0) {
					pdatas.get(i).setPrice(pvo.getPrice());
//				System.out.println("  로그: 가격 변경 성공!!");
				} else {
					pdatas.get(i).setStock(pvo.getStock());
//				System.out.println("  로그: 재고 변경 성공!!");
				}
				return true;
			}
		}
//		System.err.println("  로그: 재고 변경 실패..");
		return false;
	}

}
