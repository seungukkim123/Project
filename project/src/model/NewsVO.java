package model;

public class NewsVO {
	private int num; // pk
	private String title; // 뉴스 제목
	private String category;// 뉴스 카테고리
	private String contents;// 뉴스 내용
	private String writer;
	private int cnt; // 조회수

	public String getWriter() {
		return writer;
	}

	public void setWriter(String writer) {
		this.writer = writer;
	}

	public String getContents() {
		return contents;
	}

	public void setContents(String contents) {
		this.contents = contents;
	}

	public int getCnt() {
		return cnt;
	}

	public void setCnt(int cnt) {
		this.cnt = cnt;
	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	@Override
	public String toString() {
		return "[" + num + "] " + category + " [" + title + "] 조회수: " + cnt + "+\n<" + writer + "> " + contents;
	}

	public NewsVO() {

	}

	public NewsVO(int num, String title, String category, String contents, String writer, int cnt) {
		this.num = num;
		this.title = title;
		this.category = category;
		this.contents = contents;
		this.writer = writer;
		this.cnt = 0;
	}

}