package model;

public class MemberVO {
	// 변수명은 소문자
	private String id;
	private String pw; // 숫자가 들어가도 String
	private String name;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPw() {
		return pw;
	}

	public void setPw(String pw) {
		this.pw = pw;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "[회원정보]이름: " + name + " ID) " + id + " PW) " + pw + " ";
	}

	public MemberVO() {

	}

	public MemberVO(String id, String pw, String name) {
		this.id = id;
		this.pw = pw;
		this.name = name;
	}

}
