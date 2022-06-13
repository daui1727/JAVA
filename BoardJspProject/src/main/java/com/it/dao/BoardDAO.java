package com.it.dao;

import java.util.*;  // List
import java.sql.*;   // Connection, PreparedStatement, ResultSet

public class BoardDAO {

	private Connection conn = null;
	PreparedStatement pstmt = null;
	
	// 일반적으로 상수는 대문자로 표현한다.
	private final String URL = "jdbc:mysql://localhost:3306/db0416?serverTimezone=UTC";
	private final String USERNAME = "root";
	private final String PASSWORD = "1234";
	
	public BoardDAO() {
		try {
			
			Class.forName("com.mysql.cj.jdbc.Driver");  // 드라이브 메모리 할당
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	// mysql 연결
	public void getConnection() {
		try {
			
			conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
			
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	// mysql 해제
	public void disConnection() {
		
		try {
			
			if(pstmt != null) pstmt.close();
			if(conn != null) conn.close();
			
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	// 1. 목록 출력
	// 게시물 정보 한개 : BoardVO, 게시물 여러개 : (List)
	public List<BoardVO> boardListData(int page){
		List<BoardVO> list = new ArrayList<BoardVO>();
		
		try {
			
			//1. 연결
			getConnection();
			//2. SQL 문장 작성
			int rowSize = 10;
			int start = (rowSize*page) - rowSize;
			// 10*1 - 10 = 0,10  // 0 부터 10개 가지고 온다.
			String sql = "select no, subject, name, DATE_FORMAT(regdate, '%Y-%m-%d'), hit " // 여기 한칸 띄워야함
					+ "from jspBoard order by no desc limit ?, ?";
			
			// 3. 전송
			pstmt = conn.prepareStatement(sql);
			// 4. 데이터 채우기
			pstmt.setInt(1, start);
			pstmt.setInt(2, rowSize);
			
			// 5. 데이터 실행
			ResultSet rs= pstmt.executeQuery();
			
			while(rs.next()) {
				BoardVO vo = new BoardVO();
				vo.setNo(rs.getInt(1));
				vo.setSubject(rs.getString(2));
				vo.setName(rs.getString(3));
				vo.setDbday(rs.getString(4));
				vo.setHit(rs.getInt(5));
				
				list.add(vo);  // 가져온 회원 정보를 vo 객체에 넣고 list에 입력.
			}
			
			// 6. 닫기
			rs.close();
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			disConnection();
		}
		
		return list;
	} 
	
	
	
	// 2. 총페이지()
	public int boardTotalPage() {
		int total = 0;
		
		try {
			
			getConnection();
			String sql = "select ceil(count(*)/10.0) from jspBoard";
			
			pstmt = conn.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
			
			if(rs.next()) {
				total = rs.getInt(1);
			}
			
			rs.close();
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			disConnection();
		}
		
		return total;
	}
	
	
	// 3. Insert (새 글 입력)
	public void boardInsert(BoardVO vo) {
		try {
			
			getConnection();
			String sql = "insert into jspBoard(name, subject, content, pwd, regdate) value(?, ?, ?, ?, now())";
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, vo.getName());
			pstmt.setString(2, vo.getSubject());
			pstmt.setString(3, vo.getContent());
			pstmt.setString(4, vo.getPwd());
			
			pstmt.executeUpdate();
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			disConnection();
		}
	}
	
	// 상세보기(조회수 담당)
	public BoardVO boardDetailData(int no) {
		BoardVO vo = new BoardVO();
		
		try {
			
			getConnection();
			
			//*- 조회수 증가
			String sql = "update jspBoard set hit = hit+1 "
					+ "where no = ?";
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, no);
			pstmt.executeUpdate();
			
			sql = "select no, name, subject, content, DATE_FORMAT(regdate, '%Y-%m-%d'), hit "
					+ "from jspBoard where no = ?";
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, no);
			ResultSet rs = pstmt.executeQuery();
			
			if(rs.next()) {
				vo.setNo(rs.getInt(1));
				vo.setName(rs.getString(2));
				vo.setSubject(rs.getString(3));
				vo.setContent(rs.getString(4));
				vo.setDbday(rs.getString(5));
				vo.setHit(rs.getInt(6));
				
				rs.close();
			}
			
		}catch(Exception e){
			e.printStackTrace();
		}finally {
			disConnection();
		}
		
		return vo;
	}
	
	// 5. 수정하기(update)
	public BoardVO boardUpdateData(int no) {
		BoardVO vo = new BoardVO();
		
		try {
			
			getConnection();
			String sql = "select no, name, subject, content, DATE_FORMAT(regdate, '%Y-%m-%d'), hit "
					+ "from jspBoard where no = ?";
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, no);
			ResultSet rs = pstmt.executeQuery();
			
			if(rs.next()) {
				vo.setNo(rs.getInt(1));
				vo.setName(rs.getString(2));
				vo.setSubject(rs.getString(3));
				vo.setContent(rs.getString(4));
				vo.setDbday(rs.getString(5));
				vo.setHit(rs.getInt(6));
				
				rs.close();
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			disConnection();
		}
		
		return vo;
	}
	
	
	// 
	public boolean boardUpdate(BoardVO vo) {
		boolean chk = false;
		
		try {
			
			getConnection();
			String sql = "select pwd from jspBoard where no = ? ";
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, vo.getNo());
			ResultSet rs = pstmt.executeQuery();
			String chk_pwd = "";
			if(rs.next()) {
				chk_pwd = rs.getString(1);
				rs.close();
			}
			
			if(chk_pwd.equals(vo.getPwd())) {
				chk = true;
				
				sql = "update jspBoard set name = ?, subject = ?, content = ? where no = ?";
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, vo.getName());
				pstmt.setString(2, vo.getSubject());
				pstmt.setString(3, vo.getContent());
				pstmt.setInt(4, vo.getNo());
				
				pstmt.executeUpdate();
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			disConnection();
		}
		
		return chk;
	}
	
	// 삭제하기
	public boolean boardDelete(int no, String pwd) {
		boolean chk = false;
		
		try {
			
			getConnection();
			String sql = "select pwd from jspBoard where no = ? ";
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, no);
			ResultSet rs = pstmt.executeQuery();
			String chk_pwd = "";
			if(rs.next()) {
				chk_pwd = rs.getString(1);
				rs.close();
			}
			
			if(chk_pwd.equals(pwd)) {
				chk = true;
				
				sql = "delete from jspBoard where no = ?";
				pstmt = conn.prepareStatement(sql);
				pstmt.setInt(1, no);
				
				pstmt.executeUpdate();
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			disConnection();
		}
		
		return chk;
	}
	
	
	
	
}
