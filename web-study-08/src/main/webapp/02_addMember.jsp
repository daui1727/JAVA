<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.sql.*"%>
    
    <%!
    	Connection conn = null;
    	PreparedStatement pstmt = null;
    	String url = "jdbc:oracle:thin:@localhost:1521:XE";
    	String uid = "scott";
    	String pass = "tiger";
    	
    	String sql = "insert into member values(?, ?, ?, ?, ?, ?)";
    %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<%
		request.setCharacterEncoding("utf-8");
		String name = request.getParameter("name");
		String userid = request.getParameter("userid");
		String pwd = request.getParameter("pwd");
		String email = request.getParameter("email");
		String phone = request.getParameter("phone");
		String admin = request.getParameter("admin");
		
		try{
			// 1. JDBC 드라이버 로드
			Class.forName("oracle.jdbc.driver.OracleDriver");
			// 2. 데이터베이스 연결 객체인 Connection 생성
			conn = DriverManager.getConnection(url,uid,pass);
			
			// 3. PreparedStatement 객체 생성하기
			pstmt = conn.prepareStatement(sql);
			
			// 4. 바인딩 변수를 채운다.
			pstmt.setString(1,name);
			pstmt.setString(2,userid);
			pstmt.setString(3,pwd);
			pstmt.setString(4,email);
			pstmt.setString(5,phone);
			pstmt.setInt(6,Integer.parseInt(admin));
			// 5. sql문을 실행하여 결과 처리
			pstmt.executeUpdate();
			
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			// 6. 사용한 리소스 해제
			try{
				if(pstmt != null) pstmt.close();
				if(conn != null) conn.close();
				
			}catch(Exception e){
				e.printStackTrace();
			}
		} // end finally
		
	%>
	
	<h3> 회원 가입 성공! </h3>
	<a href="01_allMember.jsp"> 회원 전체 목록 보기 </a>

</body>
</html>