package com.douzon.bookmall.vo;

public class CategoryVo {
	
	private Long category_no;
	private String book_kind;
	public Long getCategory_no() {
		return category_no;
	}
	public void setCategory_no(Long category_no) {
		this.category_no = category_no;
	}
	public String getBook_kind() {
		return book_kind;
	}
	public void setBook_kind(String book_kind) {
		this.book_kind = book_kind;
	}
	@Override
	public String toString() {
		return "CategoryVo [category_no=" + category_no + ", book_kind=" + book_kind + "]";
	}
	

}
