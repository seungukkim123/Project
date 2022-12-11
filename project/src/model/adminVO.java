package model;

public class adminVO {
	private int num;
	private String title;
	private String category;
	private String contents;

	public String getContents() {
		return contents;
	}

	public void setContents(String contents) {
		contents = contents;
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
		return "NewsVO [num=" + num + ", title=" + title + ", category=" + category + ", Contents=" + contents + "]";
	}

	public adminVO() {

	}

	public adminVO(int num, String category, String title, String contents) {
		this.num = num;
		this.category = category;
		this.title = title;
		this.contents=contents;
	}

}
