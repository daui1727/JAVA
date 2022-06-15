package com.it.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.it.dto.MemberVO;

import util.DBManager;

public class MemberDAO {
	
	private MemberDAO() {}
	
	//싱글톤 객체 생성
	private static MemberDAO instance = new MemberDAO();
	
	public static MemberDAO getInstance() {
		return instance;
	}
	
	/////////////////////////////

	// 홈 화면 - 리스트
	public List<MemberVO> selectALLMovies() {
		List<MemberVO> list = new ArrayList<MemberVO>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "select * from movie order by code desc";
		
		try {
			
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				MemberVO mVo = new MemberVO();
				mVo.setCode(rs.getInt("code"));
				mVo.setTitle(rs.getString("title"));
				mVo.setPrice(rs.getInt("price"));
				mVo.setDirector(rs.getString("director"));
				mVo.setActor(rs.getString("actor"));
				mVo.setPoster(rs.getString("poster"));
				mVo.setSynopsis(rs.getString("synopsis"));
				
				list.add(mVo);
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			DBManager.closeConnection(conn, pstmt, rs);
		}
		
		
		return list;
	}

	////////
	// insert 부분
	public int insertMovie(MemberVO mVo) {
		int result = -1;
		String sql = "insert into movie values(movie_seq.nextval, ?,?,?,?,?,?)";
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, mVo.getTitle());
			pstmt.setInt(2, mVo.getPrice());
			pstmt.setString(3, mVo.getDirector());
			pstmt.setString(4, mVo.getActor());
			pstmt.setString(5, mVo.getPoster());
			pstmt.setString(6, mVo.getSynopsis());
			
			pstmt.executeUpdate();
			
			if(mVo != null) {
				result = 1;
			}
						
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			DBManager.closeConnection(conn, pstmt);
		}
		
		return result;
	}
	
	/////////////
	
	// update 부분
	public MemberVO selectMovieByCode(String code) {
		MemberVO mVo = new MemberVO();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		String sql = "select * from movie where code=?";
		
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, code);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				mVo.setCode(rs.getInt("code"));
				mVo.setTitle(rs.getString("title"));
				mVo.setPrice(rs.getInt("price"));
				mVo.setDirector(rs.getString("director"));
				mVo.setActor(rs.getString("actor"));
				mVo.setSynopsis(rs.getString("synopsis"));
				mVo.setPoster(rs.getString("poster"));
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			DBManager.closeConnection(conn, pstmt, rs);
		}
		
		
		return mVo;
	}

	
	////
	// update 부분
	public void updateMovie(MemberVO mVo) {
		String sql = "update movie set title=?, price=?, director=?, actor=?, poster=?, synopsis=? where code=?";
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try {
			
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, mVo.getTitle());
			pstmt.setInt(2, mVo.getPrice());
			pstmt.setString(3, mVo.getDirector());
			pstmt.setString(4, mVo.getActor());
			pstmt.setString(5, mVo.getPoster());
			pstmt.setString(6, mVo.getSynopsis());
			pstmt.setInt(7, mVo.getCode());
			pstmt.executeUpdate();
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			DBManager.closeConnection(conn, pstmt);
		}
	}

	
	//////
	// delete 부분
	public void deleteMovie(String code) {
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "delete from movie where code=?";
		
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, code);
			pstmt.executeUpdate();
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			DBManager.closeConnection(conn, pstmt);
		}
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
