package com.it.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.it.dto.MemberVO;

import util.DBManager;

public class MemberDAO {
	
	public MemberDAO() {}
	
	private static MemberDAO instance = new MemberDAO();
	
	public static MemberDAO getInstance() {
		return instance;
	}

	
	/////////////////////////////////
	// 리스트 전부 보여주는 메서드
	public List<MemberVO> selectAllEmployees() {
		List<MemberVO> list = new ArrayList<MemberVO>();
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		String sql = "SELECT * FROM(SELECT * FROM EMPLOYEES ORDER BY rownum desc)";
		
		try {
			
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				MemberVO mVo = new MemberVO();
				mVo.setId(rs.getString("id"));
				mVo.setPass(rs.getString("pass"));
				mVo.setName(rs.getString("name"));
				mVo.setLev(rs.getString("lev"));
				mVo.setEnter(rs.getTimestamp("enter"));
				mVo.setGender(rs.getString("gender"));
				mVo.setPhone(rs.getString("phone"));
				
				list.add(mVo);
			}
			
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			DBManager.closeConnection(conn, pstmt, rs);
		}
		
		
		return list;
	}

	///////////////////////////
	// insert 부분
	public void insertEmployees(MemberVO mVo) {
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "insert into employees(id,pass,name,lev,gender,phone) " +
				"values(?,?,?,?,?,?)";
		
		try {
			
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, mVo.getId());
			pstmt.setString(2, mVo.getPass());
			pstmt.setString(3, mVo.getName());
			pstmt.setString(4, mVo.getLev());
			pstmt.setString(5, mVo.getGender());
			pstmt.setString(6, mVo.getPhone());
			
			pstmt.executeUpdate();
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			DBManager.closeConnection(conn, pstmt);
		}
		
	}



	////////////////////////
	// 특정 개체만 가져오기 / 정보보기
	public MemberVO selectViewEmployees(String id) {
		
		MemberVO mVo = null;
		Connection conn =null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		String sql = "select * from employees where id = ?";
		
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				mVo = new MemberVO();
				
				mVo.setId(rs.getString("id"));
				mVo.setPass(rs.getString("pass"));
				mVo.setName(rs.getString("name"));
				mVo.setLev(rs.getString("lev"));
				mVo.setGender(rs.getString("gender"));
				mVo.setPhone(rs.getString("phone"));
				mVo.setEnter(rs.getTimestamp("enter"));
			}
			
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			DBManager.closeConnection(conn, pstmt, rs);
		}
		
		return mVo;
	}

	//////////
	// update 부분
	public void updateEmployees(MemberVO mVo) {
		
		String sql = "update employees set id=?, pass=?, name=?, lev=?, gender=?, phone=? where id=?";
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try {
			
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, mVo.getId());
			pstmt.setString(2, mVo.getPass());
			pstmt.setString(3, mVo.getName());
			pstmt.setString(4, mVo.getLev());
			pstmt.setString(5, mVo.getGender());
			pstmt.setString(6, mVo.getPhone());
			pstmt.setString(7, mVo.getId());
			
			pstmt.executeUpdate();
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			DBManager.closeConnection(conn, pstmt);
		}
		
	}

	///////////
	// delete 부분
	public void deleteEmployees(String id) {
		
		String sql = "delete employees where id = ?";
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try {
			
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			
			pstmt.executeUpdate();
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			DBManager.closeConnection(conn, pstmt);
		}
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
