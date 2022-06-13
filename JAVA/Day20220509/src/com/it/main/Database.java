package com.it.main;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Database {
	
	private Connection con; // mysql 연결
	private PreparedStatement pstmt;  // sql 문장 전송
	private final String URL = "jdbc:mysql://localhost:3306/mydb?serverTimezone=UTC";
	
	// 드라이버 등록 : 한번만 등록하면 된다.
	public Database() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	// 연결
	public void getConnection() {
		try {
			
			con = DriverManager.getConnection(URL, "root", "1234");  // 경로, 아이디, 비번
		
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	// 연결 해제
	public void disConnection() {
		try {
			
			if(pstmt != null) pstmt.close();
			if(con != null) con.close();
			
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	// 정보 가져오기 / 데이터 목록
	public void mydbListData() {
		try {
			// 1. MySql 연결
			getConnection();
			// 2. SQL 문장 작성
			String sql = "select * from member";
			// 3. MySql로 SQL 문장 전송
			pstmt = con.prepareStatement(sql);
			// 4. 실행결과를 받아온다.
			ResultSet rs = pstmt.executeQuery();  // db값을 조회할 때
			// 5. 결과를 출력
			while(rs.next()) {
				System.out.println(rs.getInt(1) + ", " + rs.getString(2) + ", " + rs.getString(3)
				+ ", " + rs.getString(4) + " "
						);
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			disConnection();
		}
	}
	
	/*
	 try {
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			disConnection();
		}
	 * */
	// 추가(Insert)
	public void mydbInsert(int no, String name, String sex, String content) {
		try {
			// 1. 연결
			getConnection();
			// 2. sql 문장 작성
			String sql = "insert into member(no, name, sex, content) "  // 오라클? 에서 에러가 나기 때문에 반드시 한 칸 띄워야한다
					+ "values(?,?,?,?)";
			// 3. mysql로 sql 문장 전송
			pstmt = con.prepareStatement(sql);

			// 4. ????를 채운다.
			pstmt.setInt(1, no);
			pstmt.setString(2, name);
			pstmt.setString(3, sex);
			pstmt.setString(4, content);
			
			// 5. 실행
			pstmt.executeUpdate();  // db값 변동시에는 executeUpdate
			
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			disConnection();
		}
	}
	
	// 수정
	public void mydbUpdate(int no, String name1, String sex1, String content1) {
		try {
				getConnection();
				String sql = "update member set name = ?, sex = ?, content = ? "
						+ "where no = ?";
				pstmt = con.prepareStatement(sql);
				pstmt.setString(1, name1);
				pstmt.setString(2, sex1);
				pstmt.setString(3, content1);
				pstmt.setInt(4, no);
				
				pstmt.executeUpdate();
				
			}catch(Exception e) {
				e.printStackTrace();
			}finally {
				disConnection();
			}
		
	}
	
	// 삭제
	public void mydbDelete(int no) {
		 try {
			 
			 getConnection();
			 String sql = "delete from member where no = ? ";
			 
			 pstmt = con.prepareStatement(sql);
			 pstmt.setInt(1, no);
			 
			 pstmt.executeUpdate();
				
			}catch(Exception e) {
				e.printStackTrace();
			}finally {
				disConnection();
			}
	}
	
	// 선택
	public void mydbSelect(int no) {
		try {
			
			getConnection();
			String sql = "select * from member where no = ? ";
			
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, no);
			ResultSet rs = pstmt.executeQuery();
			rs.next();
			System.out.println(rs.getInt(1) + ", " + rs.getString(2) + ", " + rs.getString(3)
				+ ", " + rs.getString(4) + " ");
			
		}catch(Exception e){
			e.printStackTrace();
		}finally {
			disConnection();
		}
	}
	
	
	public static void main(String[] args) {

		Database db = new Database();
		db.getConnection();
		db.mydbListData();
		System.out.println("--------------------");
//		db.mydbInsert(13, "김이박", "남성", "김씨이씨박씨");
//		System.out.println("--------------------");
		
		db.mydbUpdate(15, "으으으", "으으", "일이삼사오");
		db.mydbDelete(13);
		db.mydbListData();
		System.out.println("--------------------");
		db.mydbSelect(4);
	}

}
