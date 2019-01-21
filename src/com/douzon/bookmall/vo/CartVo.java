package com.douzon.bookmall.vo;

public class CartVo {

	private Long cart_no;
	private Long quantity;
	private Long book_no;
	private Long customer_no;
	private String book_name;
	private String customer_name;
	private Long all_price;
	
	public Long getCart_no() {
		return cart_no;
	}
	public void setCart_no(Long cart_no) {
		this.cart_no = cart_no;
	}
	public Long getQuantity() {
		return quantity;
	}
	public void setQuantity(Long quantity) {
		this.quantity = quantity;
	}
	public Long getBook_no() {
		return book_no;
	}
	public void setBook_no(Long book_no) {
		this.book_no = book_no;
	}
	public Long getCustomer_no() {
		return customer_no;
	}
	public void setCustomer_no(Long customer_no) {
		this.customer_no = customer_no;
	}
	public String getBook_name() {
		return book_name;
	}
	public void setBook_name(String book_name) {
		this.book_name = book_name;
	}
	public String getCustomer_name() {
		return customer_name;
	}
	public void setCustomer_name(String customer_name) {
		this.customer_name = customer_name;
	}
	public Long getAll_price() {
		return all_price;
	}
	public void setAll_price(Long all_price) {
		this.all_price = all_price;
	}
	@Override
	public String toString() {
		return "CartVo [cart_no=" + cart_no + ", quantity=" + quantity + ", book_no=" + book_no + ", customer_no="
				+ customer_no + ", book_name=" + book_name + ", customer_name=" + customer_name + ", all_price="
				+ all_price + "]";
	}
	
	
	
}
