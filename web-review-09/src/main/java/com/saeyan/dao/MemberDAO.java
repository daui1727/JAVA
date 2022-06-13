package com.saeyan.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import com.saeyan.dto.MemberVO;

public class MemberDAO {
	
	// !!!! 새롭게 추가되고 조회, 수정하는 모든 작업을 이 곳에서 진행한다.
	
	// DAO는 데이터 접근이 목적인 객체. 즉, DB의 데이터를 어떻게 이용할지에 초점을 맞춰 설계하는 클래스다.
	// 테이블에 저장된 데이터를 VO 객체 단위로 저장해서 사용한다.
	public MemberDAO() {}
	
	// 싱글톤 패턴 --> 메모리의 낭비를 막기 위해.
	// 싱글톤 패턴 --> 싱글톤 패턴이 되기 위한 첫번째 조건은 생성자가 private이어야한다.
	// 다른 클래스에서는 절대 인스턴스를 생성하지 못하고 자기 자신만 생성할 수 있게. 외부에서 접근할 수 없게.
	private static MemberDAO instance = new MemberDAO();
	
	
	// read only로 만들기 위해 setter는 정의하지 않고 getter만 값만 얻을 수 있게
	public static MemberDAO getInstance() {
		return instance;
	}
	
	// 커넥션을 얻어오는 메서드. 
	public Connection getConnection() throws Exception {
		Context initContext = new InitialContext();
		Context envContext = (Context)initContext.lookup("java:/comp/env");
		DataSource ds = (DataSource)envContext.lookup("jdbc/myoracle");
		Connection conn = ds.getConnection();
		return conn;
	}
	
	// 회원 인증을 위한 메서드 추가. 사용자 인증 시 사용하는 메서드
	public int userCheck(String userid, String pwd) {
		int result = -1;  // 회원이 존재하면 1 반환, 존재하지 않으면 -1 반환. 초기값은 없을거라는 가정하에 -1로 설정
		String sql = "select pwd from member where userid=?";
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, userid);  // ?에 매개변수로 받아온 아이디를 바인딩시킨다.
			rs = pstmt.executeQuery();
			
			if(rs.next()) { // 아이디가 일치하는 행이 존재하면 ()안이 true이므로 
				
				if(rs.getString("pwd")!=null && rs.getString("pwd").equals(pwd)) {  
					result = 1;  // 아이디 암호 둘다 일치하면 1
				}else {
					result = 0;  // 아이디는 맞지만 암호가 불일치하면 0
				}
				
			}else {
				result = -1;  // 해당 아디이가 존재하지 않으면 -1
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				
				if(rs != null) rs.close();
				if(pstmt != null) pstmt.close();
				if(conn != null) conn.close();
				
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
		
		
		return result;
	}
	
	// 회원 인증을 위한 메서드 추가. 아이디로 회원 정보 가져오는 메서드
	public MemberVO getMember(String userid) {
		MemberVO mVo = null;
		String sql = "select * from member where userid=?";
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, userid);  // ?에 매개변수로 받아온 아이디를 바인딩시킨다.
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				
				// mVo VO객체에 데이터베이스에 저장된 회원 정보를 채웁니다.
				mVo = new MemberVO();
				mVo.setName(rs.getString("name"));
				mVo.setUserid(rs.getString("userid"));
				mVo.setPwd(rs.getString("pwd"));
				mVo.setEmail(rs.getString("email"));
				mVo.setPhone(rs.getString("phone"));
				mVo.setAdmin(rs.getInt("admin"));
				
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				
				if(rs != null) rs.close();
				if(pstmt != null) pstmt.close();
				if(conn != null) conn.close();
				
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
		
		return mVo;
	}
	
	
	
	
	
	
	

}
