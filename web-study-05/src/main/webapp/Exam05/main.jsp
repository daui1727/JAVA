<%@page import="java.net.URLDecoder"%>
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
		// Cookie에서 name과 value를 얻어와서 비교
		Cookie[] ck = request.getCookies();
		String name = null;
		String str = null;
		// 1. 클라이언트로부터 Cookie[]를 얻어옴
		if(ck != null){
			// 2. 쿠키의 name을 얻어서 "username"인지 비교하여 같으면
			for(Cookie cookie : ck){
				name = cookie.getName();
				if(name.equals("username"))
				    str = URLDecoder.decode(cookie.getValue(),"UTF-8");
			}
			out.print(str);
	%>
	
		님 안녕하세요!<br>
		저희 홈페이지를 방문해주셔서 감사합니다.<br>
		즐거운 시간 되세요.<br>
		<form action="logout.jsp" method="post">
			<input type="submit" value="로그아웃">
		</form>
	<%
		}else{
	%>
		<h2>로그인에 실패했습니다.</h2>
		<p>a<a href="loginForm.jsp">되돌아가기</a></p>
	<% 
		}
	%>

</body>
</html>