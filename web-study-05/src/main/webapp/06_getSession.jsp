<%@page import="java.util.Enumeration"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<h3>세션에 설정된 모든 값 얻어오기</h3>
	
	<%
		session.setAttribute("num", "123");
		// 여러개의 데이터를 집합처럼 관리하는 인터페이스 Enumeration
		Enumeration names = session.getAttributeNames();
		while(names.hasMoreElements()){
			String name = names.nextElement().toString();
			String value = session.getAttribute(name).toString();
			out.println(name + " : " + value + "<br>");
		}
		
	%>

</body>
</html>