package com.it.main;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.text.AbstractDocument.Content;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class Database2 {
	
	private Connection con; // mysql 연결
	private PreparedStatement pstmt;  // sql 문장 전송
	private final String URL = "jdbc:mysql://localhost:3306/naver?serverTimezone=UTC";
	
	// 드라이버 등록 : 한번만 등록하면 된다.
	public Database2() {
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
				+ " "
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
	public void mydbInsert(int no, String title, String text) {
		try {
			// 1. 연결
			getConnection();
			// 2. sql 문장 작성
			String sql = "insert into member(no, title, text) "  // 오라클? 에서 에러가 나기 때문에 반드시 한 칸 띄워야한다
					+ "values(?,?,?)";
			// 3. mysql로 sql 문장 전송
			pstmt = con.prepareStatement(sql);

			// 4. ????를 채운다.
			pstmt.setInt(1, no);
			pstmt.setString(2, title);
			pstmt.setString(3, text);
			
			// 5. 실행
			pstmt.executeUpdate();  // db값 변동시에는 executeUpdate
			
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			disConnection();
		}
	}
	
	// 수정
	public void mydbUpdate(int no, String title1, String text1) {
		try {
				getConnection();
				String sql = "update member set name = ?, sex = ?, content = ? "
						+ "where no = ?";
				pstmt = con.prepareStatement(sql);
				pstmt.setString(1, title1);
				pstmt.setString(2, text1);
				pstmt.setInt(3, no);
				
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
				+ " ");
			
		}catch(Exception e){
			e.printStackTrace();
		}finally {
			disConnection();
		}
	}
	
	// 추가(Insert)
		public void mydbInsertin(String text) {
			try {
				// 1. 연결
				getConnection();
				// 2. sql 문장 작성
				String sql = "insert into member(text) "  // 오라클? 에서 에러가 나기 때문에 반드시 한 칸 띄워야한다
						+ "values(?)";
				// 3. mysql로 sql 문장 전송
				pstmt = con.prepareStatement(sql);

				// 4. ????를 채운다.
				pstmt.setString(3, text);
				
				// 5. 실행
				pstmt.executeUpdate();  // db값 변동시에는 executeUpdate
				
				
			}catch(Exception e) {
				e.printStackTrace();
			}finally {
				disConnection();
			}
		}
	
	
	public static void main(String[] args) throws IOException {
		
		int pages = 2;
		for(int i = 1; i < pages; i++) {
			
			String url = "https://news.naver.com/main/list.naver?mode=LS2D&sid2=249&sid1=102&mid=shm&date=20220502&page=1" + i;
			
			Document doc = Jsoup.connect(url).get();
			
//			System.out.println(doc);
			
			Elements elements = doc.getElementsByAttributeValue("class", "list_body newsflash_body");
			
//			System.out.println(elements.get(0));
		
			Element element = elements.get(0);
			
//			System.out.println(element);
			
			Elements photoElements = element.getElementsByAttributeValue("class", "photo");
			
//			System.out.println(photoElements);
			
			for(int j = 0; j < photoElements.size(); j++) {
				
				
				Element articleElement = photoElements.get(j);
//				System.out.println(articleElement);
				Elements aElements = articleElement.select("a");
				Element aElement = aElements.get(0);
//				System.out.println(aElements);
				
				String newsUrl = aElement.attr("href");
//				System.out.println(newsUrl);
				
				Element imgElement = aElement.select("img").get(0);
				String imgUrl = imgElement.attr("src");
//				System.out.println(imgUrl);
				
				String title = imgElement.attr("alt");
//				System.out.println(title);
				
				Document detailDoc = Jsoup.connect(newsUrl).get();
				Element contentElement = detailDoc.getElementById("dic_area");
				String content = contentElement.text();
				
				System.out.println(content);
				
			}
		
		} // end for

		Database2 db = new Database2();
		db.getConnection();
		db.mydbListData();
		
		db.mydbInsertin("content");
		
//		db.mydbInsert(13, "김이박", "남성");
//		System.out.println("--------------------");
//		db.mydbInsert(13, "김이박", "남성", "김씨이씨박씨");
//		System.out.println("--------------------");
//		
//		db.mydbUpdate(15, "으으으", "으으");
//		db.mydbDelete(13);
//		db.mydbListData();
//		System.out.println("--------------------");
//		db.mydbSelect(4);
	}

}
