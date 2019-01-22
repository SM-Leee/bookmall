package com.douzon.bookmall.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.douzon.bookmall.vo.MemberVo;


public class MemberDao {
	
	public List<MemberVo> LoginGetList(MemberVo memberVo){
		List<MemberVo> list = new ArrayList<MemberVo>();

		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		try {
			conn = getConnection();

			// 3. Statement 객체를 생성
			stmt = conn.createStatement();

			// 4. SQL문 실행
			String sql = "select customer_no from customer where email='"+memberVo.getEmail()+"' and password='"+memberVo.getPassword()+"'";
			rs = stmt.executeQuery(sql);

			// 5. 결과 가져오기
			while(rs.next()) {
				Long customer_no = rs.getLong(1);
				
				MemberVo vo = new MemberVo();
				vo.setNo(customer_no);
				
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
	
	public List<MemberVo> getList(){
		List<MemberVo> list = new ArrayList<MemberVo>();

		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		try {
			conn = getConnection();

			// 3. Statement 객체를 생성
			stmt = conn.createStatement();

			// 4. SQL문 실행
			String sql = "select customer_no, name, tel, email, password(password) from customer";
			rs = stmt.executeQuery(sql);

			// 5. 결과 가져오기
			while(rs.next()) {
				Long customer_no = rs.getLong(1);
				String name = rs.getString(2);
				String tel = rs.getString(3);
				String email = rs.getString(4);
				String password = rs.getString(5);
				
				MemberVo vo = new MemberVo();
				vo.setNo(customer_no);
				vo.setName(name);
				vo.setTel(tel);
				vo.setEmail(email);
				vo.setPassword(password);
				
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
	
	public boolean insert(MemberVo memberVo) {

		Connection conn = null;
		PreparedStatement pstmt = null;
		boolean result = false;
		try {
			conn = getConnection();

			String sql = "insert into customer values(null, ?, ?, ?, ?)";
			pstmt = conn.prepareStatement(sql);

			pstmt.setString(1, memberVo.getName());
			pstmt.setString(2, memberVo.getTel());
			pstmt.setString(3, memberVo.getEmail());
			pstmt.setString(4, memberVo.getPassword());

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
