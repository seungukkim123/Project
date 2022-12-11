package model;

public class ProductVO {
	private int num;		// PK
	private String name;
	private int price;
	private int stock;
	

	public int getNum() {
		return num;
	}


	public void setNum(int num) {
		this.num = num;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public int getPrice() {
		return price;
	}


	public void setPrice(int price) {
		this.price = price;
	}


	public int getStock() {
		return stock;
	}


	public void setStock(int stock) {
		this.stock = stock;
	}


	@Override
	public String toString() {
		return "상품번호[" + num + "] 상품명) " + name + ", " + price + "원, 재고: " + stock + "개";
	}

	public ProductVO() {
		
	}
	public ProductVO(int num, String name, int price, int stock) {
		this.num=num;
		this.name=name;
		this.price=price;
		this.stock=stock;
	}
	
}
