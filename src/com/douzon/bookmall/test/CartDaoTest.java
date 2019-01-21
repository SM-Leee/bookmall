package com.douzon.bookmall.test;

import java.util.List;

import com.douzon.bookmall.dao.CartDao;
import com.douzon.bookmall.vo.CartVo;

public class CartDaoTest {

	public static void main(String[] args) {
		//insertTest(10,1,1);
		//insertTest(8,1,2);
		
	//	Long member_no = MemberDaoTest.LoginGetListTest("tjdalsl111@naver.com", "1111");
	//	Long book_no = BookDaoTest.BookGetListTest("흔들리지 않는 돈의 법칙");
	//	System.out.println(member_no+" : "+book_no);		
	//	if(book_no==null) {
	//		System.out.println("책 정보가 잘못 되었습니다.");
	//	}
		//insertTest(8, book_no, member_no);
	//	getListTest(member_no);
		
	}
	
	public static void getListTest(long customer_no) {
		CartVo cartVo = new CartVo();
		cartVo.setCustomer_no(customer_no);
		List<CartVo> list = new CartDao().getList(cartVo);
		
		for(CartVo vo : list) {
			System.out.println(vo.getCart_no()+", "+vo.getBook_name()+", "+vo.getQuantity()+", "+vo.getAll_price());
		}
	}
	
	public static void insertTest(long quantity, long book_no, long customer_no) {
		CartVo vo = new CartVo();
		vo.setQuantity(quantity);
		vo.setBook_no(book_no);
		vo.setCustomer_no(customer_no);
		
		new CartDao().insert(vo);
	}

}
