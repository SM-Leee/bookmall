package com.douzon.bookmall.vo;

public class OrderBookVo {
	
	private Long order_book_no;
	private Long quantity;
	private Long order_no;
	private String order_name;
	private Long book_no;
	private String book_name;
	public Long getOrder_book_no() {
		return order_book_no;
	}
	public void setOrder_book_no(Long order_book_no) {
		this.order_book_no = order_book_no;
	}
	public Long getQuantity() {
		return quantity;
	}
	public void setQuantity(Long quantity) {
		this.quantity = quantity;
	}
	public Long getOrder_no() {
		return order_no;
	}
	public void setOrder_no(Long order_no) {
		this.order_no = order_no;
	}
	public String getOrder_name() {
		return order_name;
	}
	public void setOrder_name(String order_name) {
		this.order_name = order_name;
	}
	public Long getBook_no() {
		return book_no;
	}
	public void setBook_no(Long book_no) {
		this.book_no = book_no;
	}
	public String getBook_name() {
		return book_name;
	}
	public void setBook_name(String book_name) {
		this.book_name = book_name;
	}
	@Override
	public String toString() {
		return "OrderBookVo [order_book_no=" + order_book_no + ", quantity=" + quantity + ", order_no=" + order_no
				+ ", order_name=" + order_name + ", book_no=" + book_no + ", book_name=" + book_name + "]";
	}
	
	
	
}
