<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ page import="java.sql.Connection" %>
<%@ page import="com.saeyan.dao.MemberDAO" %>
   
 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<%
		MemberDAO memDao = MemberDAO.getInstance();
		Connection conn = memDao.getConnection();
		out.print("DB 연동성공");
	%>

</body>
</html>