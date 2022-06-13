<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <%!
    	int global_cnt = 0;
    %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>

<body>

	<%
		int local_cnt = 0;
		out.print("<br> local_cnt : ");
		out.print(++local_cnt);
		
		out.print("<br> global_cnt : ");
		out.print(++global_cnt);
	%>
	<h1>Hello</h1>
	<%
		int local_cnt2 = 0;
		out.print("<br> local_cnt2 : ");
		out.print(++local_cnt);
		
		out.print("<br> global_cnt2 : ");
		out.print(++global_cnt);
	%>
	<%=global_cnt %>
	<%=local_cnt %>

</body>
</html>