package com.douzon.bookmall.test;

import java.util.List;

import com.douzon.bookmall.dao.OrderDao;
import com.douzon.bookmall.vo.OrderBookVo;
import com.douzon.bookmall.vo.OrderVo;

public class OrderDaoTest {

	public static void main(String[] args) {
		
		insertTest("경상남도 김해시",1);
//		getListTest(2);
		
	}

	public static void getListTest(long customer_no) {
		OrderVo orderVo = new OrderVo();
		orderVo.setCustomer_no(customer_no);
		List<OrderVo> list = new OrderDao().getList(orderVo);
		
		for(OrderVo vo : list) {
			System.out.println(vo.getOrder_no()+", "+vo.getName_email()+", "+vo.getShipping());
		}
	}
	
	public static void insertTest(String shipping, long customer_no) {
		OrderVo vo = new OrderVo();
		vo.setShipping(shipping);
		vo.setCustomer_no(customer_no);
		
		new OrderDao().insert(vo);
	}
	
	public static void insertTest(long quantity, long order_no, long book_no) {
		OrderBookVo vo = new OrderBookVo();
		vo.setQuantity(quantity);
		vo.setOrder_no(order_no);
		vo.setBook_no(book_no);
		
		new OrderDao().insert(vo);
	}
}
