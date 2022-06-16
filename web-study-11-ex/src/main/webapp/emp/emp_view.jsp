<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="css/main.css">
</head>

<body>

	<div id="wrap" align="center">
		<h1>정보 보기</h1>
		<table class="list">
			<tr>
				<th>아이디</th>
				<td>${emp.id}</td>
			</tr>
			
			<tr>
				<th>비밀번호</th>
				<td>${emp.pass}</td>
			</tr>
			
			<tr>
				<th>이름</th>
				<td>${emp.name}</td>
			</tr>
			
			<tr>
				<th>권한</th>
				<td>
					<c:choose>
						<c:when test="${emp.lev == 'A'}">운영자</c:when>
						<c:otherwise>일반사원</c:otherwise>
					</c:choose>
				</td>

			</tr>
			
			<tr>
				<th>성별</th>
				<td>
					<c:choose>
						<c:when test="${emp.gender == '1'}">남자</c:when>
						<c:otherwise>여자</c:otherwise>
					</c:choose>
				</td>
			</tr>
			
			<tr>
				<th>전화번호</th>
				<td>${emp.phone}</td>
			</tr>
			
			<tr>
				<th>가입일</th>
				<td>${emp.enter}</td>
			</tr>
		</table>
		<br><br>
		<input type="button" value="수정" onclick="location.href='MemberServlet?command=emp_update_form&id=${emp.id}'">
		<input type="button" value="삭제" onclick="location.href='MemberServlet?command=emp_delete&id=${emp.id}'">
		<input type="button" value="목록" onclick="location.href='MemberServlet?command=emp_list'">
		<input type="button" value="등록" onclick="location.href='MemberServlet?command=emp_write_form'">
	</div>

</body>
</html>