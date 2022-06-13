<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.sql.*"%>
    
<%!
	Connection conn = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	
	String url = "jdbc:oracle:thin:@localhost:1521:XE";
	String uid = "scott";
	String pass = "tiger";
	String sql = "select * from employee";
	
%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css">
<script src="https://cdn.jsdelivr.net/npm/jquery@3.6.0/dist/jquery.slim.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/js/bootstrap.bundle.min.js"></script>
<title>Insert title here</title>
</head>
<body>
	
	<div class="container">
		<table width="800" border="1" class="table table-striped">
			<thead>
				<tr class="table-primary">
					<th>이름</th>
					<th>주소지</th>
					<th>주민등록번호</th>
				</tr>
			</thead>
				<%
					try{
						
						Class.forName("oracle.jdbc.driver.OracleDriver");
						conn = DriverManager.getConnection(url,uid,pass);
						pstmt = conn.prepareStatement(sql);
						
						rs = pstmt.executeQuery();
						
						while(rs.next()){
				%>
				<tbody>
					<tr class="table-light">
						<td><%= rs.getString(1)%></td>
						<td><%= rs.getString(2)%></td>
						<td><%= rs.getString(3)%></td>
					</tr>
				</tbody>
				<%
						}
						
					}catch(Exception e){
						e.printStackTrace();
					}finally{
						try{
							
							if(rs != null) rs.close();
							if(pstmt != null) pstmt.close();
							if(conn != null) conn.close();
							
						}catch(Exception e){
							e.printStackTrace();
						}
					} // end finally
				%>
			
		</table>
	</div>

</body>
</html>