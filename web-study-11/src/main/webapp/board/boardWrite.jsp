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
		<h1> 게시글 등록 </h1>
		<form action="BoardServlet" method="post" name="frm">
			<input type="hidden" name="command" value="board_write">
			
			<table>
				<tr>
					<th>작성자</th>
					<td><input type="text" name="name"> * 필수 </td>
				</tr>
				
				<tr>
					<th>비밀번호</th>
					<td><input type="password" name="pass"> * 필수 (게시물 수정 삭제시 필요합니다.)</td>
				</tr>
				
				<tr>
					<th>이메일</th>
					<td><input type="text" name="email"></td>
				</tr>
				
				<tr>
					<th>제목</th>
					<td><input type="text" name="title" size="70"> * 필수 </td>
				</tr>
				
				<tr>
					<th>내용</th>
					<td><textarea rows="15" cols="70" name="content"></textarea></td>
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