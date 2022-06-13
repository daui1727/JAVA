<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <%@ page import="java.sql.*" %>
    
    <%!
    	Connection conn = null;
    	Statement stmt = null;
    	ResultSet rs = null;
    	
    	String url = "jdbc:oracle:thin:@localhost:1521:xe";
    	String uid = "scott";
    	String pass = "tiger";
    	String sql = "select * from member";
    %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JDBC</title>
</head>

<body>

	<table width="800" border="1">
		<tr>
			<th>이름</th>
			<th>아이디</th>
			<th>암호</th>
			<th>이메일</th>
			<th>전화번호</th>
			<th>권한(1:관리자, 0:일반회원)</th>
		</tr>
		<%
			try{
				// 꼭 commit하고 진행하자.
				// 1. 드라이브 로드
				Class.forName("oracle.jdbc.driver.OracleDriver");
				// 2. 연결
				conn = DriverManager.getConnection(url,uid,pass);
				// 3. sql문장 실행
				stmt = conn.createStatement();
				// 4. sql문 실행
				rs = stmt.executeQuery(sql);
				// 5. 실행된 결과물을 rs를 통해서 출력
				while(rs.next()){
					out.println("<tr>");
					out.println("<td>"+rs.getString("name")+"</td>");
					//out.println("<td>"+rs.getString(1)+"</td>"); 순서대로 숫자로 표현을 자주하기도 한다.
					out.println("<td>"+rs.getString("userid")+"</td>");
					//out.println("<td>"+rs.getString(2)+"</td>");
					out.println("<td>"+rs.getString("pwd")+"</td>");
					out.println("<td>"+rs.getString("email")+"</td>");
					out.println("<td>"+rs.getString("phone")+"</td>");
					out.println("<td>"+rs.getInt("admin")+"</td>");
					out.println("</tr>");
				} // end while
				
			}catch(Exception e){
				e.printStackTrace();
			}finally{
				try{
					
					if(rs != null) rs.close();
					if(stmt != null) stmt.close();
					if(conn != null) conn.close();
					
				}catch(Exception e){
					e.printStackTrace();
				}
			} // end finally
		%>
		
	</table>

</body>
</html>