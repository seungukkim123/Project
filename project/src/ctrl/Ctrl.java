package ctrl;

import model.MemberDAO;
import model.MemberVO;
import model.ProductDAO;
import model.ProductVO;
import view.View;
import view.View;

public class Ctrl {
	private View view;
	private MemberDAO mdao;
	private ProductDAO pdao;

	public Ctrl() {
		view = new View();
		mdao = new MemberDAO();
		pdao = new ProductDAO();

	}

	public void startApp() {
		while (true) {
			int act = view.printMain();
			if (act == 1) {
				// mvo에는 사용자가 로그인하기 위해 입력한 id, pw 정보가 담겨있음
				MemberVO mvo = view.login();
				mvo = mdao.selectOne(mvo);
				// view.login 메서드의 반환
				if (mvo == null) {
					view.loginFalse();
					continue;
				}
				view.loginTrue(mvo);
				while(true) {
					if (mvo.getId().equals("admin")) {
						act = view.admin();
						if (act == 1) {
							view.printProductMenu(pdao.selectAll(null));
						} else if (act == 2) {
							ProductVO vo = new ProductVO();
							vo.setName(view.getproductName());
							vo.setPrice(view.getprice());
							vo.setStock(view.getstock());
							pdao.insert(vo);
						} else if (act == 3) {
							ProductVO vo = new ProductVO();
							vo.setNum(view.getPk());
							pdao.delete(vo);
						} else if (act == 4) {
							ProductVO vo = new ProductVO();
							vo.setNum(view.getPk());
							int num = pdao.choice();
							if (num == 1) {
								vo.setName(view.getproductName());
								pdao.updateInfo(vo);
								view.updateTrue();
							} else if (num == 2) {
								vo.setPrice(view.getprice());
								pdao.updateInfo(vo);
								view.updateTrue();
							} else if (num == 3) {
								vo.setStock(view.getstock());
								pdao.updateInfo(vo);
								view.updateTrue();
							}
						} else if (act == 5) {
							view.logout();
							break;
						}
					} else {
						act = view.printMenu();
						if (act == 1) {
							view.printProductMenu(pdao.selectAll(null));
							continue;
						} else if (act == 2) {
							// 목록 출력메서드를 인자로 가진 buyProduct의 입력 값을 num에 담음.
							int num = view.buyProduct(pdao.selectAll(null));
							ProductVO pvo = new ProductVO();
							// num을 pvo의 num으로 set.
							pvo.setNum(num);
							// ProductDAO의 pdatas 중 입력한 num과 일치하는 pdatas만 pvo에 다시 담음.
							pvo = pdao.selectOne(pvo);
							// update메서드의 인자로 pvo를 주어 해당 pdatas의 재고를 -1하여 set.
							if (pdao.update(pvo)) {
								// 구매 상품, 가격 및 구매자와 구매 상품 출력.(영수증 출력)
								view.buyTrue(mvo, pvo);
							} else {
								// 구매 실패 출력.
								view.buyFalse();
							}
						} else if (act == 3) {
							// 회원 정보변경
							MemberVO vo = new MemberVO();
							vo.setId(view.getId());
							int num = mdao.choice();
							if (num == 1) {
								vo.setName(view.updateName());
								mdao.update(vo);
								view.updateTrue();
							} else if (num == 2) {
								vo.setPw(view.updatePw());
								mdao.update(vo);
								view.updateTrue();
							}
							break;
						} else {
							view.logout();
							break;
						}
					}
				}
			} else if (act == 2) {
				MemberVO vo = new MemberVO();
				vo.setId(view.getId());
				vo.setPw(view.getPW());
				vo.setName(view.getName());
				mdao.singUp(vo);
			} else if (act == 3) {
				MemberVO vo = new MemberVO();
				vo.setId(view.getId());
				mdao.delete(vo);
			} else if (act == 4) {
				view.powerOff();
				break;
			}
		}
	}
}
