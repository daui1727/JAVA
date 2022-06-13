<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
	Cookie cookie = new Cookie("username","");
	cookie.setMaxAge(0);
	response.addCookie(cookie);
%>
<script>
	alert("로그 아웃 되었습니다.");
	location.href="loginForm.jsp";
</script>
</body>
</html>