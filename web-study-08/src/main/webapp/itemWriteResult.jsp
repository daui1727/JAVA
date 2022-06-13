<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.sql.*"%>
    
    
    <%!
    	Connection conn = null;
    	PreparedStatement pstmt = null;
    	String url = "jdbc:oracle:thin:@localhost:1521:XE";
    	String uid = "scott";
    	String pass = "tiger";
    	
    	String sql = "insert into item values(?, ?, ?)";
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
		String price = request.getParameter("pr");
		String description = request.getParameter("desc");
		
		try{
			
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection(url,uid,pass);
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1,name);
			pstmt.setInt(2,Integer.parseInt(price));
			pstmt.setString(3,description);
			
			pstmt.executeUpdate();
			
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			try{
				
				if(pstmt != null) pstmt.close();
				if(conn != null) conn.close();
				
			}catch(Exception e){
				e.printStackTrace();
			}
		} // end finally
		
	%>

	<a href="itemWrite.jsp"> 결과 보기 </a>
	

</body>
</html>