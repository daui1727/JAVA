<%@page import="java.net.URLEncoder"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	당신의 학력, 소속국가 및 관심분야는 다음과 같습니다. <br><br>
	<%
		request.setCharacterEncoding("utf-8");
		String edu = request.getParameter("edu");
		String na = request.getParameter("na");
		String[] likes = request.getParameterValues("like");
	%>

	<b><%= edu %></b> 과 <b><%= na %></b><br><br>
	<%
		for(int i = 0; i < likes.length; i++){
	%>
			<b><%= likes[i]%></b><br>
	<%
		}
	%>

</body>
</html>