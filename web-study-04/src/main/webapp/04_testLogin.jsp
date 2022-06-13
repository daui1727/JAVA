<%@page import="java.net.URLEncoder"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>testLogin</title>
</head>
<body>

	<% 
		String id="pinksung";
		String pwd = "1234";
		String name = "성윤정";
		
		request.setCharacterEncoding("utf-8");
		if(id.equals(request.getParameter("id")) && pwd.equals(request.getParameter("pwd")) ){
			response.sendRedirect("04_main.jsp?name=" + URLEncoder.encode(name, "UTF-8"));
		}else{
			response.sendRedirect("04_loginForm.jsp");
		}
	%>	

</body>
</html>