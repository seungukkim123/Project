package model;

import java.io.IOException;
import java.util.Iterator;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class Crawling {

	// --------------------------정치파트-----------------------------------------------------
	public void politics(NewsDAO ndao) { // <=wado : App에서 사용하는 model
		final String url = "https://news.naver.com/main/main.naver?mode=LSD&mid=shm&sid1=100";
		Document doc = null;
		try {
			doc = Jsoup.connect(url).get();
		} catch (IOException e) {
			e.printStackTrace();
		}

		// 기사제목 크롤링
		Elements eles2 = doc.select("ul > li > div.cluster_text > a"); // <=요소를 가져오기 위해 셀렉사용, 포함을 사용해 범위 설정
		Iterator<Element> itr2 = eles2.iterator();
		// 기사내용 크롤링
		Elements eles3 = doc.select("ul > li > div.cluster_text > div.cluster_text_lede"); // <=요소를 가져오기 위해 셀렉사용, 포함을
																							// 사용해 범위 설정
		Iterator<Element> itr3 = eles3.iterator();
		// 매체, 일자 크롤링
		Elements eles4 = doc.select("ul > li > div.cluster_text > div.cluster_text_info"); // <=요소를 가져오기 위해 셀렉사용, 포함을
																							// 사용해 범위 설정
		Iterator<Element> itr4 = eles4.iterator();

		while (itr3.hasNext()) { // <=돌면서 값이 있는지 확인
			NewsVO nvo = new NewsVO();
			String category = "정치";
			nvo.setCategory(category);
			String title = itr2.next().text();
			nvo.setTitle(title);
			String content = itr3.next().text();
			nvo.setContents(content);
			String info = itr4.next().text();
			nvo.setWriter(info);
			ndao.insert(nvo);
			// insert()App에서 사용하는 model의 DB에 넣으려고
		}
	}

	// --------------------------경제파트-----------------------------------------------------
	public void economy(NewsDAO ndao) { // <=wado : App에서 사용하는 model
		final String url = "https://news.naver.com/main/main.naver?mode=LSD&mid=shm&sid1=101";
		Document doc = null;
		try {
			doc = Jsoup.connect(url).get();
		} catch (IOException e) {
			e.printStackTrace();
		}

		// 기사제목 크롤링
		Elements eles2 = doc.select("ul > li > div.cluster_text > a"); // <=요소를 가져오기 위해 셀렉사용, 포함을 사용해 범위 설정
		Iterator<Element> itr2 = eles2.iterator();
		// 기사내용 크롤링
		Elements eles3 = doc.select("ul > li > div.cluster_text > div.cluster_text_lede"); // <=요소를 가져오기 위해 셀렉사용, 포함을
																							// 사용해 범위 설정
		Iterator<Element> itr3 = eles3.iterator();
		// 매체, 일자 크롤링
		Elements eles4 = doc.select("ul > li > div.cluster_text > div.cluster_text_info"); // <=요소를 가져오기 위해 셀렉사용, 포함을
																							// 사용해 범위 설정
		Iterator<Element> itr4 = eles4.iterator();

		while (itr3.hasNext()) { // <=돌면서 값이 있는지 확인
			NewsVO nvo = new NewsVO();
			String category = "경제";
			nvo.setCategory(category);
			String title = itr2.next().text();
			nvo.setTitle(title);
			String content = itr3.next().text();
			nvo.setContents(content);
			String info = itr4.next().text();
			nvo.setWriter(info);
			ndao.insert(nvo);
			// insert()App에서 사용하는 model의 DB에 넣으려고
		}
	}

	// --------------------------사회파트-----------------------------------------------------
	public void society(NewsDAO ndao) { // <=wado : App에서 사용하는 model
		final String url = "https://news.naver.com/main/main.naver?mode=LSD&mid=shm&sid1=102";
		Document doc = null;
		try {
			doc = Jsoup.connect(url).get();
		} catch (IOException e) {
			e.printStackTrace();
		}

		// 기사제목 크롤링
		Elements eles2 = doc.select("ul > li > div.cluster_text > a"); // <=요소를 가져오기 위해 셀렉사용, 포함을 사용해 범위 설정
		Iterator<Element> itr2 = eles2.iterator();
		// 기사내용 크롤링
		Elements eles3 = doc.select("ul > li > div.cluster_text > div.cluster_text_lede"); // <=요소를 가져오기 위해 셀렉사용, 포함을
																							// 사용해 범위 설정
		Iterator<Element> itr3 = eles3.iterator();
		// 매체, 일자 크롤링
		Elements eles4 = doc.select("ul > li > div.cluster_text > div.cluster_text_info"); // <=요소를 가져오기 위해 셀렉사용, 포함을
																							// 사용해 범위 설정
		Iterator<Element> itr4 = eles4.iterator();

		while (itr3.hasNext()) { // <=돌면서 값이 있는지 확인
			NewsVO nvo = new NewsVO();
			String category = "사회";
			nvo.setCategory(category);
			String title = itr2.next().text();
			nvo.setTitle(title);
			String content = itr3.next().text();
			nvo.setContents(content);
			String info = itr4.next().text();
			nvo.setWriter(info);
			ndao.insert(nvo);
			// insert()App에서 사용하는 model의 DB에 넣으려고
		}
	}
}
