package com.douzon.bookmall.test;

import java.util.List;

import com.douzon.bookmall.dao.OrderDao;
import com.douzon.bookmall.vo.OrderBookVo;
import com.douzon.bookmall.vo.OrderVo;

public class OrderDaoTest {

	public static void main(String[] args) {
		
		//insertTest("경상남도 김해시",1);
		getListTest(1);
		//insertTest(1);
		OrderBookGetListTest(1);
		
		
	}

	public static void getListTest(long customer_no) {
		OrderVo orderVo = new OrderVo();
		orderVo.setCustomer_no(customer_no);
		List<OrderVo> list = new OrderDao().getList(orderVo);
		
		for(OrderVo vo : list) {
			System.out.println(vo.getOrder_no()+", "+vo.getName_email()+", "+vo.getAll_price()+", "+vo.getShipping());
		}
	}
	public static void OrderBookGetListTest(long order_no) {
		OrderBookVo orderBookVo = new OrderBookVo();
		orderBookVo.setOrder_no(order_no);
		List<OrderBookVo> list = new OrderDao().getList(orderBookVo);
		
		for(OrderBookVo vo : list) {
			System.out.println(vo.getBook_no()+", "+vo.getBook_name()+", "+vo.getQuantity());
		}
	}
	
	public static void insertTest(String shipping, long customer_no) {
		OrderVo vo = new OrderVo();
		vo.setShipping(shipping);
		vo.setCustomer_no(customer_no);
		
		new OrderDao().insert(vo);
	}
	
	public static void insertTest(long customer_no) {
		OrderBookVo vo = new OrderBookVo();
		vo.setCustomer_no(customer_no);
		
		new OrderDao().insert(vo);
	}
}
