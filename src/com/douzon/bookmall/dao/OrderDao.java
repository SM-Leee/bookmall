package com.douzon.bookmall.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.douzon.bookmall.vo.OrderBookVo;
import com.douzon.bookmall.vo.OrderVo;

public class OrderDao {
	
	public List<OrderVo> getList(OrderVo orderVo){
		List<OrderVo> list = new ArrayList<OrderVo>();

		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		try {
			conn = getConnection();

			// 3. Statement 객체를 생성
			stmt = conn.createStatement();

			// 4. SQL문 실행
			String sql = "select b.order_no, concat(a.name,'/',a.email), (c.quantity*d.price), b.shipping from customer a, orderr b, cart c, book d where a.customer_no=b.customer_no and a.customer_no=c.customer_no and c.book_no=d.book_no and a.customer_no="+orderVo.getCustomer_no();
			rs = stmt.executeQuery(sql);

			// 5. 결과 가져오기
			while(rs.next()) {
				Long order_no = rs.getLong(1);
				String name_email = rs.getString(2);
				Long all_price = rs.getLong(3);
				String shipping = rs.getString(4);
				
				OrderVo vo = new OrderVo();
				vo.setOrder_no(order_no);
				vo.setName_email(name_email);
				vo.setAll_price(all_price);
				vo.setShipping(shipping);
				
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
	
	public boolean insert(OrderBookVo orderBookVo) {

		Connection conn = null;
		PreparedStatement pstmt = null;
		boolean result = false;
		try {
			conn = getConnection();

			String sql = "insert into order_book(null, ?, ?,?)";
			pstmt = conn.prepareStatement(sql);

			pstmt.setLong(1, orderBookVo.getQuantity());
			pstmt.setLong(2, orderBookVo.getOrder_no());
			pstmt.setLong(3, orderBookVo.getBook_no());

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
	
	public List<OrderBookVo> getList(OrderBookVo orderBookVo){
		List<OrderBookVo> list = new ArrayList<OrderBookVo>();

		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		try {
			conn = getConnection();

			// 3. Statement 객체를 생성
			stmt = conn.createStatement();

			// 4. SQL문 실행
			String sql = "select b.order_book_no, b.quantity, c.name from orderr a, order_book b, book c where a.order_no=b.order_no and b.book_no=c.book_no";
			rs = stmt.executeQuery(sql);

			// 5. 결과 가져오기
			while(rs.next()) {
				Long order_no = rs.getLong(1);
				String name_email = rs.getString(2);
				Long all_price = rs.getLong(3);
				String shipping = rs.getString(4);
				
				OrderVo vo = new OrderVo();
				vo.setOrder_no(order_no);
				vo.setName_email(name_email);
				vo.setAll_price(all_price);
				vo.setShipping(shipping);
				
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
	
	public boolean insert(OrderVo orderVo) {

		Connection conn = null;
		PreparedStatement pstmt = null;
		boolean result = false;
		Statement stmt = null;
		ResultSet rs = null;
		try {
			conn = getConnection();

			// 3. Statement 객체를 생성
			stmt = conn.createStatement();

			// 4. SQL문 실행
			String sql = "select a.price, b.quantity from book a, order_book b where a.book_no=b.book_no and b.book_no = 1";
			rs = stmt.executeQuery(sql);
			
			// 5. 결과 가져오기
			while(rs.next()) {
				Long price = rs.getLong(1);
				Long quantity = rs.getLong(2);
			
				orderVo.setPrice(price);
				orderVo.setQuantity(quantity);
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
		try {
			conn = getConnection();
			String sql = "insert into orderr values(null, ?, ?, ?)";
			pstmt = conn.prepareStatement(sql);
			Long all_price = orderVo.getPrice()*orderVo.getQuantity();
			pstmt.setString(1, orderVo.getShipping());
			pstmt.setLong(2, all_price);
			pstmt.setLong(3, orderVo.getCustomer_no());

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
