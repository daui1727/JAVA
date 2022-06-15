<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="css/shopping.css">
</head>

<body>

	<div id="wrap" align="center">
		<h1> 게시글 상세보기 </h1>
		<table class="list">
			<tr>
				<th> 작성자 </th>
				<td> ${boardList.name}</td>
				<th> 이메일 </th>
				<td> ${boardList.email}</td>
			</tr>
			
			<tr>
				<th>작성일</th>
				<td><fmt:formatDate value="${boardList.writedate}"/></td>
				<th>조회수</th>
				<td>${boardList.readcount}</td>
			</tr>
			
			<tr>
				<th>제목</th>
				<td colspan="3">${boardList.title}</td>
			</tr>
			
			<tr>
				<th>내용</th>
				<td colspan="3"><pre>${boardList.content}</pre></td>
			</tr>
		</table>
		<br><br>
		
		<input type="button" value="게시글 수정">
		<input type="button" value="게시글 삭제">
		<input type="button" value="게시글 리스트">
		<input type="button" value="게시글 등록">
	</div>

</body>
</html>