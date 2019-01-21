package com.douzon.bookmall.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.douzon.bookmall.vo.CartVo;

public class CartDao {
	
	public List<CartVo> getList(CartVo cartVo){
		List<CartVo> list = new ArrayList<CartVo>();

		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		try {
			conn = getConnection();

			// 3. Statement 객체를 생성
			stmt = conn.createStatement();
			// 4. SQL문 실행
			String sql = "select b.cart_no, a.name, b.quantity, (b.quantity*a.price) from book a, cart b, customer c where a.book_no=b.book_no and b.customer_no=c.customer_no and b.customer_no ="+cartVo.getCustomer_no();
			rs = stmt.executeQuery(sql);

			// 5. 결과 가져오기
			while(rs.next()) {
				Long cart_no = rs.getLong(1);
				String book_name = rs.getString(2);
				Long quantity = rs.getLong(3);
				Long all_price = rs.getLong(4);
								
				CartVo vo = new CartVo();
				vo.setCart_no(cart_no);
				vo.setBook_name(book_name);
				vo.setQuantity(quantity);
				vo.setAll_price(all_price);
				
				list.add(vo);
			}

			
		} catch (SQLException e) {
			System.out.println("error:"+e);
		} finally {
			try {
				if(rs != null) {
					rs.close();
				}
				if(stmt != null) {
					stmt.close();
				}
				if(conn != null) {
					conn.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		return list;
	}
	
	public boolean insert(CartVo cartVo) {

		Connection conn = null;
		PreparedStatement pstmt = null;
		boolean result = false;
		try {
			conn = getConnection();

			String sql = "insert into cart values(null, ?, ?, ?)";
			pstmt = conn.prepareStatement(sql);

			pstmt.setLong(1, cartVo.getQuantity());
			pstmt.setLong(2, cartVo.getBook_no());
			pstmt.setLong(3, cartVo.getCustomer_no());

			int count = pstmt.executeUpdate();

			result = count >= 1;

		} catch (SQLException e) {
			System.out.println("error:"+e);
		} finally {
			try {
				if(pstmt != null) {
					pstmt.close();
				}
				if(conn != null) {
					conn.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return result;
	}
	
	private Connection getConnection() throws SQLException{
		Connection conn = null;
		try {
			// 1. JDBC Driver(MYSQL) 로딩
			Class.forName("com.mysql.jdbc.Driver");
			//pripertiy -> build path를 등록해줘야된다.

			// 2. 연결하기 ( jdbc:연결할database://ip:port/database이름 ) port번호는 생략가능하다.
			// url과 id와 password를 같이 입력해준다. (Connection 객체 얻어오기)
			String url = "jdbc:mysql://localhost:3306/bookmall";
			conn = DriverManager.getConnection(url,"bookmall","bookmall");
		} catch (ClassNotFoundException e) {
			System.out.println("드라이버 로딩 실패 : "+e);
		}
		return conn;
	}

}
