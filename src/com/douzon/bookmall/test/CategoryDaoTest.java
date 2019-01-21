package com.douzon.bookmall.test;

import java.util.List;

import com.douzon.bookmall.dao.CategoryDao;
import com.douzon.bookmall.vo.CategoryVo;

public class CategoryDaoTest {

	public static void main(String[] args) {
//		insertTest("코믹");
//		insertTest("공포");
//		insertTest("시");
//		insertTest("경제");
//		
//		getListTest();

	}
	
	public static void getListTest() {
		List<CategoryVo> list = new CategoryDao().getList();
		for(CategoryVo vo : list) {
			System.out.println(vo.getCategory_no()+" "+vo.getBook_kind());
		}
	}
	
	public static void insertTest(String book_kind) {
		CategoryVo vo = new CategoryVo();
		vo.setBook_kind(book_kind);
		
		new CategoryDao().insert(vo);
	}

}
