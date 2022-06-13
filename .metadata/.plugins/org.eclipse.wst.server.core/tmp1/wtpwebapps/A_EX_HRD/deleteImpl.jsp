<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.sql.*, javax.sql.*"%>
    
<%
	request.setCharacterEncoding("utf-8");
	String custno = request.getParameter("custno");
	
	String sql = "delete from MEMBER_TBL_02 where custno = ?";
	Connection conn = null;
	PreparedStatement pstmt = null;
	String url = "jdbc:oracle:thin:@localhost:1521:xe";
	String id = "system";
	String pwd = "1234";
	
	try{
		
		Class.forName("oracle.jdbc.driver.OracleDriver");
		conn = DriverManager.getConnection(url,id,pwd);
		pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, custno);		
		int result = pstmt.executeUpdate();
		
		
	}catch(Exception e){
		e.printStackTrace();
	}finally{
		try{
			if( pstmt != null) pstmt.close();
			if( conn != null) conn.close();
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	%>
	<script type="text/javascript">
		alert("회원 삭제가 완료되었습니다.");
		location.href="memberForm.jsp";
	</script>
		


