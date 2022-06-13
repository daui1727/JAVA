<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.sql.*"%>
    
    <%!
    	Connection conn = null;
    	Statement stmt = null;
    	ResultSet rs = null;
    	
    	String url = "jdbc:oracle:thin:@localhost:1521:xe";
    	String uid = "scott";
    	String pass = "tiger";
    	String sql = "select * from item";
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
			<tr>
				<th>상품명</th>
				<th>가격</th>
				<th>설명</th>
			</tr>
			<%
				try{
					Class.forName("oracle.jdbc.driver.OracleDriver");
					conn = DriverManager.getConnection(url,uid,pass);
					stmt = conn.createStatement();
					rs = stmt.executeQuery(sql);
					while(rs.next()){
			%>
						<tbody>
							<tr class="table-light">
								<td><%= rs.getString(1)%></td>
								<td><%= rs.getInt(2)%></td>
								<td><%= rs.getString(3)%></td>
							</tr>
						</tbody>
			<%
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
	</div>

</body>
</html>