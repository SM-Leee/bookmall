package com.douzon.bookmall.vo;

public class BookVo {
	private Long book_no;
	private String name;
	private Long price;
	private String category_name;
	private Long category_no;
	public Long getBook_no() {
		return book_no;
	}
	public void setBook_no(Long book_no) {
		this.book_no = book_no;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Long getPrice() {
		return price;
	}
	public void setPrice(Long price) {
		this.price = price;
	}
	public String getCategory_name() {
		return category_name;
	}
	public void setCategory_name(String category_name) {
		this.category_name = category_name;
	}
	public Long getCategory_no() {
		return category_no;
	}
	public void setCategory_no(Long category_no) {
		this.category_no = category_no;
	}
	@Override
	public String toString() {
		return "BookVo [book_no=" + book_no + ", name=" + name + ", price=" + price + ", category_name=" + category_name
				+ ", category_no=" + category_no + "]";
	}
	
	
	
}
