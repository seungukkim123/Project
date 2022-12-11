package model;

import java.io.IOException;
import java.util.Iterator;

import javax.lang.model.util.Elements;

import org.jsoup.Jsoup;

public class Crawling {
	public void sample(WebtoonDAO wdao) { // wdao: App에서 사용하는 model
		final String url = "https://movie.naver.com/movie/bi/mi/basic.naver?code=222301";
		Document doc = null; 
		try {
			doc = Jsoup.connect(url).get();
		} catch (IOException e) {
			e.printStackTrace();
		}
		// 제목 데이터 출력
		Elements eles = doc.select("div.score_reple"); 
		// 화면에 출력하기 위한 이터레이터
		Iterator<Element> itr = eles.iterator();
		Elements eles2 = doc.select("div > ul > li > div > dl > dt > em > a > span");
		Iterator<Element> itr2 = eles2.iterator();
		while (itr2.hasNext()) {
			// 출력할 itr을 문자열로 변환하기.
			WebtoonVO wvo = new WebtoonVO(); 
			String title = itr.next().text();
			wvo.setTitle(title);
			String writer = itr2.next().text();
			wvo.setWriter(writer);
			wdao.insert(wvo);
			// insert() == App에서 사용하는 model의 DB에 넣으려고!
		}
	}
}