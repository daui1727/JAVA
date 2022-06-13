package com.it.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import com.it.dto.MemberVO;

public class MemberDAO {
	
	public MemberDAO() {}
	
	// 싱글톤 패턴 객체 생성
	private static MemberDAO instance = new MemberDAO();
	
	public static MemberDAO getInstance() {
		return instance;
	}
	
	public Connection getConnection() throws Exception {
		Context initContext = new InitialContext();
		Context envContext  = (Context)initContext.lookup("java:/comp/env");
		DataSource ds = (DataSource)envContext.lookup("jdbc/myoracle");
		Connection conn = ds.getConnection();
		return conn;
	}
	
	///////////////////////
	// 1. 자동 증가 부분
	public MemberVO getSeq(int custno) {
		MemberVO mVo = null;
		
		String sql = "select max(custno) from member_tbl_02";
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			conn = getConnection();
			pstmt = conn.prepareCall(sql);
			rs = pstmt.executeQuery();
			
			if(rs.next()){
				custno = rs.getInt(1)+1;
				mVo = new MemberVO();
				mVo.setCustno(custno);
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

	
	//////////////////
	// 2. insert 부분
	public int insertMember(MemberVO mVo) {
		int result = -1;
		
		String sql = "insert into member_tbl_02 values(?,?,?,?,?,?,?)";
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try {
			
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, mVo.getCustno());
			pstmt.setString(2, mVo.getCustname());
			pstmt.setString(3, mVo.getPhone());
			pstmt.setString(4, mVo.getAddress());
			pstmt.setString(5, mVo.getJoindate());
			pstmt.setString(6, mVo.getGrade());
			pstmt.setString(7, mVo.getCity());
			
			result = pstmt.executeUpdate();
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				
				if(pstmt != null) pstmt.close();
				if(conn != null) conn.close();
				
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
		
		return result;
	}

	
	/////////////////////////
	// 3. 목록 보여주는 부분
	
	public ArrayList<MemberVO> boardListData() {
		ArrayList<MemberVO> list = new ArrayList<MemberVO>();
		
		String sql = "select * from member_tbl_02";
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				
				String grade = "직원";
				if(rs.getString(6).equals("A")) grade = "VIP";
				else if(rs.getString(6).equals("B")) grade = "일반";
				
	            MemberVO vo=new MemberVO();
	            vo.setCustno(rs.getInt(1));
	            vo.setCustname(rs.getString(2));
	            vo.setPhone(rs.getString(3));
	            vo.setAddress(rs.getString(4));
	            vo.setJoindate(rs.getString(5));
	            vo.setGrade(grade);
	            vo.setCity(rs.getString(7));
	            list.add(vo);
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
		
		return list;
	}


	
	///////////////////////////////////////
	// 4. update
	
	public MemberVO getMember(int custno) {
		MemberVO mVo = null;
		String sql = "select * from member_tbl_02 where custno=?";
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			
			conn = getConnection();
			pstmt = conn.prepareCall(sql);
			pstmt.setInt(1, custno);
			
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				mVo = new MemberVO();
				mVo.setCustno(rs.getInt("custno"));
				mVo.setCustname(rs.getString("custname"));
				mVo.setPhone(rs.getString("phone"));
				mVo.setAddress(rs.getString("address"));
				mVo.setJoindate(rs.getString("joindate"));  //
				mVo.setGrade(rs.getString("grade"));
				mVo.setCity(rs.getString("city"));
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
	
	///////

	public void updateMember(MemberVO mVo) {
		
		String sql = "update member_tbl_02 set custname=?, phone=?, address=?, "
				+ "joindate=?, grade=?, city=? where custno = ?";
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try {
			
			
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, mVo.getCustno());	
			pstmt.setString(2, mVo.getCustname());		
			pstmt.setString(3, mVo.getPhone());		
			pstmt.setString(4, mVo.getAddress());		
			pstmt.setString(5, mVo.getJoindate());		
			pstmt.setString(6, mVo.getGrade());		
			pstmt.setString(7, mVo.getCity());		
			int result = pstmt.executeUpdate();
			
			pstmt.executeUpdate();

		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				
				if(pstmt != null) pstmt.close();
				if(conn != null) conn.close();
				
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
		
	}
		
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
