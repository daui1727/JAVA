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

	<%
		String id = "pinksung";
		String pwd = "1234";
		String name = "성윤정";
		
		if(id.equals(request.getParameter("id")) && 
				pwd.equals(request.getParameter("pwd")) ){
			// id, pwd가 같을 때만 쿠키를 생성하고 client에 추가
			// 1. Cookie 객체 생성(username에 성윤정을 맵핑)
			Cookie c = new Cookie("username", URLEncoder.encode(name,"UTF-8"));
			// 2. 속성 부여
			c.setMaxAge(365*24*60*60);
			// 3. 클라이언트에 전송
			response.addCookie(c);
			response.sendRedirect("main.jsp");
		}else{
			response.sendRedirect("loginForm.jsp");
		}
	%>

</body>
</html>