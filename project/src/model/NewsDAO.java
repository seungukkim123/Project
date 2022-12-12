package model;

import java.util.ArrayList;

public class NewsDAO {
	int PK = 101;
	ArrayList<NewsVO> ndatas = new ArrayList<NewsVO>();
	Crawling crawling;

	public boolean insert(NewsVO nvo) {
		try {
			ndatas.add(new NewsVO(PK++, nvo.getTitle(), nvo.getCategory(), nvo.getContents(), nvo.getWriter(),
					nvo.getCnt()));
//			System.out.println("  로그: 뉴스 추가 성공!!");
			return true;
		} catch (Exception e) {
			e.printStackTrace();
//			System.out.println("  로그: 뉴스 추가 실패..");
			return false;
		}
	}

//////////////////////////////기사 제목,검색 출력////////////////////////////////
//   public ArrayList<newsVO> searchTitle(newsVO nvo) {
//      if (nvo == null) {
//         return ndatas;
//      }
//      ArrayList<newsVO> resDatas = new ArrayList<newsVO>();
//      for (int i = 0; i < ndatas.size(); i++) {
//         if (ndatas.get(i).getTitle().contains(nvo.getTitle())) {
//            ndatas.get(i).setCnt(ndatas.get(i).getCnt() + 1);
//            resDatas.add(ndatas.get(i));
//         }
//      }
//      return resDatas;
//   }
//////////////////////////////기사,타이틀 검색 출력////////////////////////////////

	public ArrayList<NewsVO> selectAll(NewsVO nvo) {
		return ndatas;
	}

	public ArrayList<NewsVO> searchTitle(NewsVO nvo) {
		if (nvo == null) {
			return ndatas;
		}
		ArrayList<NewsVO> resDatas = new ArrayList<NewsVO>();
		if (nvo.getTitle() != null) {
			for (int i = 0; i < ndatas.size(); i++) {
				if (ndatas.get(i).getTitle().contains(nvo.getTitle())) {
					ndatas.get(i).setCnt(ndatas.get(i).getCnt() + 1);
					resDatas.add(ndatas.get(i));
				}
			}
		}
		return resDatas;
	}

	public ArrayList<NewsVO> searchCategory(NewsVO nvo) {
		ArrayList<NewsVO> resDatas = new ArrayList<NewsVO>();
		if (nvo.getCategory() != null) {
			for (int i = 0; i < ndatas.size(); i++) {
				if (ndatas.get(i).getCategory().contains(nvo.getCategory())) {// 검색한게 맞다면 조회수 +1
					ndatas.get(i).setCnt(ndatas.get(i).getCnt() + 1);
					resDatas.add(ndatas.get(i));
				}
			}
		}
		return resDatas;
	}

///////////////////////////카테고리 검색,출력/////////////////////////////
//   public ArrayList<newsVO> searchCategory(newsVO nvo) {
//      if (nvo == null) {
//         return ndatas;
//      }
//      ArrayList<newsVO> resDatas = new ArrayList<newsVO>();
//      for (int i = 0; i < ndatas.size(); i++) {
//         if (ndatas.get(i).getCategory().contains(nvo.getCategory())) {// 검색한게 맞다면 조회수 +1
//            ndatas.get(i).setCnt(ndatas.get(i).getCnt() + 1);
//            resDatas.add(ndatas.get(i));
//         }
//      }
//      return resDatas;
//   }
}