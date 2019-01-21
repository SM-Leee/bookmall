package com.douzon.bookmall;

import java.util.Scanner;

import com.douzon.bookmall.test.BookDaoTest;
import com.douzon.bookmall.test.CartDaoTest;
import com.douzon.bookmall.test.CategoryDaoTest;
import com.douzon.bookmall.test.MemberDaoTest;
import com.douzon.bookmall.test.OrderDaoTest;

public class MainApp {

	public static void main(String[] args) {
		System.out.println("회원정보");
		System.out.println();
		MemberDaoTest.insertTest("이성민","010-2222-2222","tjdals111@naver.com","1111");
		MemberDaoTest.insertTest("이가영","010-1111-1111","tngusl111@naver.com","3333");
		
		MemberDaoTest.getListTest();
		System.out.println("==================================================================================");
		System.out.println("카테고리 리스트");
		System.out.println();
		CategoryDaoTest.insertTest("추리");
		CategoryDaoTest.insertTest("코믹");
		CategoryDaoTest.insertTest("시");
		
		CategoryDaoTest.getListTest();
		System.out.println("==================================================================================");
		System.out.println("상품리스트");
		System.out.println();
		
		BookDaoTest.insertTest("유리망치", 15000, 1);
		BookDaoTest.insertTest("원피스", 4500, 2);
		BookDaoTest.insertTest("가면산장 살인사건", 13320, 1);
		
		BookDaoTest.getListTest();
		System.out.println("==================================================================================");
		System.out.println("카트 리스트");
		System.out.println();
		CartDaoTest.insertTest(10, 1, 1);
		CartDaoTest.insertTest(10, 3, 1);
		
		CartDaoTest.getListTest(1);
		System.out.println("==================================================================================");
		System.out.println("주문리스트");
		System.out.println();
		
		OrderDaoTest.insertTest(10, 1, 1);
		OrderDaoTest.insertTest("부산광역시 수영구",	1);
		
		OrderDaoTest.getListTest(1);
		System.out.println("==================================================================================");
		System.out.println("주문리스트");
		System.out.println();
		
		
		
//		Scanner sc = new Scanner(System.in);
//		
//		System.out.println("-----1.회원가입 / 2.로그인-----");
//		int a = sc.nextInt();
//		Long member_no = null;
//		if(a == 1) {
//			System.out.print("NAME : ");
//			String name = sc.next();
//			System.out.print("TEL : ");
//			String tel = sc.next();
//			System.out.print("E-MAIL : ");
//			String email = sc.next();
//			System.out.print("PW : ");
//			String password = sc.next();
//			MemberDaoTest.insertTest(name, tel, email, password);
//			System.out.println("회원가입이 성공하였습니다.");
//		
//		}
//		if(a == 2) {
//			while(true) {
//				System.out.println("-----아이디와 패스워드를 입력해주세요-----");
//				System.out.print("ID : ");
//				String id = sc.next();
//				System.out.print("PW : ");
//				String pw = sc.next();
//				
//				member_no = MemberDaoTest.LoginGetListTest(id, pw);
//				if(member_no==null) {
//					System.out.println("회원정보가 틀렸습니다.다시 입력해주세요.");
//				} else {
//					System.out.println("로그인에 성공하셨습니다.");
//					break;
//				}
//			}		
//		}
//		
//
//		System.out.println("------------도서목록-------------");
//		BookDaoTest.getListTest();
//		Long book_no = null;
//		
//			System.out.print("구매를 원하는 도서를 입력해주세요 : ");
//			String book_name = sc.next();
//			book_no = BookDaoTest.BookGetListTest(book_name);
//			
//			if(book_no==null) {
//				System.out.println("도서정보가 잘못되었습니다.");
//			}else {
//				System.exit(0);
//			}
//		
//		System.out.print("구매를 원하는 도서의 수량을 입력해주세요 : ");
//		Long quantity = sc.nextLong();
//
//		CartDaoTest.insertTest(quantity, book_no, member_no);
//		CartDaoTest.getListTest(member_no);
//
//		System.out.print("배송할 주소지를 입력하여 주세요 : ");
//		String shipping = sc.next();
//		OrderDaoTest.insertTest(shipping, member_no);
//
//		System.out.println("주문 완료된 목록입니다.");
//		OrderDaoTest.getListTest(member_no);





	}

}
