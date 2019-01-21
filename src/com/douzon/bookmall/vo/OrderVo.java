package com.douzon.bookmall.vo;

public class OrderVo {
	
	private Long order_no;	//번호
	private String shipping;	//배송지
	private Long customer_no;
	private String customer_name;
	private String name_email;
	private Long all_price;
	private Long price;
	private Long quantity;
	public Long getOrder_no() {
		return order_no;
	}
	public void setOrder_no(Long order_no) {
		this.order_no = order_no;
	}
	public String getShipping() {
		return shipping;
	}
	public void setShipping(String shipping) {
		this.shipping = shipping;
	}
	public Long getCustomer_no() {
		return customer_no;
	}
	public void setCustomer_no(Long customer_no) {
		this.customer_no = customer_no;
	}
	public String getCustomer_name() {
		return customer_name;
	}
	public void setCustomer_name(String customer_name) {
		this.customer_name = customer_name;
	}
	public String getName_email() {
		return name_email;
	}
	public void setName_email(String name_email) {
		this.name_email = name_email;
	}
	public Long getAll_price() {
		return all_price;
	}
	public void setAll_price(Long all_price) {
		this.all_price = all_price;
	}
	public Long getPrice() {
		return price;
	}
	public void setPrice(Long price) {
		this.price = price;
	}
	public Long getQuantity() {
		return quantity;
	}
	public void setQuantity(Long quantity) {
		this.quantity = quantity;
	}
	@Override
	public String toString() {
		return "OrderVo [order_no=" + order_no + ", shipping=" + shipping + ", customer_no=" + customer_no
				+ ", customer_name=" + customer_name + ", name_email=" + name_email + ", all_price=" + all_price
				+ ", price=" + price + ", quantity=" + quantity + "]";
	}
	

}
