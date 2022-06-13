<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.sql.*, javax.sql.*"%>
    
<%
	request.setCharacterEncoding("utf-8");
	Connection conn = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	String url = "jdbc:oracle:thin:@localhost:1521:xe";
	String id = "system";
	String pwd = "1234";
	
	String sql = "select m2.custno, m1.custname, m1.grade, sum(m2.price) "
			+ "from MEMBER_TBL_02 m1, MONEY_TBL_02 m2 "
			+ "where m1.CUSTNO = m2.CUSTNO group by m2.CUSTNO, m1.custname, m1.grade "
			+ "order by 4 desc";
	
	try{
		Class.forName("oracle.jdbc.driver.OracleDriver");
		conn = DriverManager.getConnection(url,id,pwd);
		pstmt = conn.prepareStatement(sql);
		rs = pstmt.executeQuery();
%>    

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원매출조회</title>
<link rel="stylesheet" href="css/common.css"/>
<style type="text/css">
	
	section{height: 700px; background:#e5e5e5;}
	section h2{text-align:center; padding:40px 0;}
	section table{margin: 0 auto; width:700px;}
	section tr{height:45px; text-align:center;}
	
</style>
</head>
<body>

	<%@ include file="header.jsp" %>
	
	<section>
		<h2>회원 매출 조회</h2>
		<table border="1">
			<tr>
				<th>회원번호</th>
				<th>회원성명</th>
				<th>고객등급</th>
				<th>매출</th>
			</tr>
			<%
				while(rs.next()){
					String grade = "직원";
		 			if(rs.getString(3).equals("A")) grade = "VIP";
		 			else if(rs.getString(3).equals("B")) grade = "일반";
			%>
			<tr>
				<td><%= rs.getString(1) %></td>
				<td><%= rs.getString(2) %></td>
				<td><%= grade %></td>
				<td><%= rs.getString(4) %></td>				
			</tr>
			
			<%
				}
			%>
		</table>
	</section>
	
	<%@ include file="footer.jsp" %>

</body>
</html>

<%		
	}catch(Exception e){
		e.printStackTrace();
	}finally{
		try{
			if( rs != null) rs.close();
			if( pstmt != null) pstmt.close();
			if( conn != null) conn.close();
		}catch(Exception e){
			e.printStackTrace();
		}
	}
%>