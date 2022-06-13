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
		request.setCharacterEncoding("utf-8");
		String site = request.getParameter("site");
		
		if(site.equals("네이버")){ 
			response.sendRedirect("https://www.naver.com/");
		}else if(site.equals("다음")){
			response.sendRedirect("https://www.daum.net/");
		}else if(site.equals("네이트")){
			response.sendRedirect("https://www.nate.com/");
		}else{
			response.sendRedirect("https://www.google.co.kr/");
		}
	%>

</body>
</html>