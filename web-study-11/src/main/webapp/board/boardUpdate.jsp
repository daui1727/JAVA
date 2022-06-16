<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="css/shopping.css">
<script type="text/javascript" src="script/board.js"></script>
</head>
<body>

	<div id="wrap" align="center">
		<h1> 게시글 수정 </h1>
		<form action="BoardServlet" method="post" name="frm">
			<input type="hidden" name="command" value="board_update">
			<input type="hidden" name="num" value="${boardList.num}">
			<table>
				<tr>
					<th> 작성자 </th>
					<td><input type="text" size="12" name="name" value="${boardList.name}"> * 필수 </td>
				</tr>
				
				<tr>
					<th> 비밀번호 </th>
					<td><input type="password" size="12" name="pass"> * 필수(게시물 수정 삭제 시 필요합니다.)</td>
				</tr>
				
				<tr>
					<th> 이메일 </th>
					<td><input type="text" size="40" name="email" value="${boardList.email}" maxlength="50"></td>
				</tr>
				
				<tr>
					<th> 제목 </th>
					<td><input type="text" size="70" name="title" value="${boardList.title}"> * 필수 </td>
				</tr>
				
				<tr>
					<th> 내용 </th>
					<td><textarea cols="70" rows="15" name="content">${boardList.content}</textarea></td>
				</tr>
			</table>
			<br><br>
			
			<input type="submit" value="등록" onclick="return boardCheck()">
			<input type="reset" value="다시 작성">
			<input type="button" value="목록" onclick="location.href='BoardServlet?command=board_list'">
		</form>
	</div>

</body>
</html>