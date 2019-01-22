package com.douzon.bookmall.test;

import java.util.List;

import com.douzon.bookmall.dao.BookDao;
import com.douzon.bookmall.vo.BookVo;

public class BookDaoTest {

	public static void main(String[] args) {
		//insertTest("곰돌이 푸, 행복한 일은 매일 있어", 10800, 3);
		//insertTest("흔들리지 않는 돈의 법칙", 14400, 4);
		
		//getListTest();
		
		//Long book_no = BookGetListTest("흔들리지 않는 돈의 법칙");
		//System.out.println(book_no);
		
		getListTest();

	}
	
	public static Long BookGetListTest(String name) {
		
		BookVo bookVo = new BookVo();
		bookVo.setName(name);
		
		List<BookVo> list = new BookDao().BookGetList(bookVo);
		Long book_no = null;
		for(BookVo vo : list) {
			book_no = vo.getBook_no();
		}
		return book_no;
		
	}
	
	public static void getListTest() {
		List<BookVo> list = new BookDao().getList();
		for(BookVo vo : list) {
			System.out.println(vo.getBook_no()+", "+vo.getName()+", "+vo.getCategory_name()+", "+vo.getPrice());
			//System.out.println(vo);
		}
	}
	
	public static void insertTest(String name, long price, long category_no) {
		BookVo vo = new BookVo();
		vo.setName(name);
		vo.setPrice(price);
		vo.setCategory_no(category_no);
		
		new BookDao().insert(vo);
		
		
	}
	
	
}
