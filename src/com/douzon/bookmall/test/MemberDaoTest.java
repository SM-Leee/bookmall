package com.douzon.bookmall.test;

import java.util.List;

import com.douzon.bookmall.dao.MemberDao;
import com.douzon.bookmall.vo.MemberVo;

public class MemberDaoTest {

	public static void main(String[] args) {
//		insertTest("이성민","010-2222-2222","tjdals111@naver.com","1111");
//		insertTest("오동희","010-1111-1111","ehdgml111@naver.com","3333");
//		
//		getListTest();
//		LoginGetListTest("tjdals1708@naver.com", "1111");
		
	}
	
	public static Long LoginGetListTest(String email, String password) {
		MemberVo memberVo = new MemberVo();
		memberVo.setEmail(email);
		memberVo.setPassword(password);
		
		List<MemberVo> list = new MemberDao().LoginGetList(memberVo);
		Long member_no = null;
		for(MemberVo vo : list) {
			member_no = vo.getNo();
		}
		return member_no;
		
	}
	
	public static void getListTest() {
		List<MemberVo> list = new MemberDao().getList();
		for(MemberVo vo : list) {

			System.out.println(vo.getNo()+", "+vo.getName()+", "+vo.getTel()+", "+vo.getEmail()+", "+vo.getPassword());
		}
	}
	
	public static void insertTest(String name, String tel, String email, String password) {
		MemberVo vo = new MemberVo();
		vo.setName(name);
		vo.setTel(tel);
		vo.setEmail(email);
		vo.setPassword(password);
		
		new MemberDao().insert(vo);
	}

}
