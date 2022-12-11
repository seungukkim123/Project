package ctrl;

import java.util.ArrayList;

import model.adminDAO;
import model.adminVO;
import model.UserDAO;
import model.UserVO;
import view.NewsView;

public class NewsCtrl {
	private NewsView view;
	private adminDAO ndao;
	private UserDAO udao;

	public NewsCtrl() {
		view = new NewsView();
		ndao = new adminDAO();
		udao = new UserDAO();
	}

	public void startApp() {
		while (true) {
			int act = view.printMain();
			if (act == 1) {
				UserVO uvo = view.login();
				uvo = udao.selectOne(uvo);
				if (uvo == null) {
					view.loginFalse();
					continue;
				}
				view.loginTrue(uvo);
				while (true) {
					if (uvo.getId().equals("admin")) {
						act = view.admin();
						// 기사 목록 출력
						if (act == 1) {
							view.printNews(ndao.selectAll(null));
						}
						// 지정 기사 출력
						else if (act == 2) {
							ArrayList<adminVO> ndatas;
							adminVO nvo = new adminVO();
							nvo.setTitle(view.getTitle());
						}
					}
				}
			}

		}
	}
}
