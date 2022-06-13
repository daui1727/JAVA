<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
	h1{text-align:center;}
	table{margin:0 auto; border:1px solid #000;}
	table tr td:first-child{padding:0 20px; background:#898989; font-weight:bold; text-align:center;}
	.btn{text-align:center; margin-top:20px;}
</style>
</head>
<body>

	<h1>게시판 글쓰기</h1>
	
	<form action="boardWrite.jsp" method="post">
		<table>
			<tr>
				<td>작성자</td>
				<td><input type="text" name="name"  size="20"></td>
			</tr>
			<tr>
				<td>비밀번호</td>
				<td><input type="password" name="pass" size="20"> (게시물 수정 삭제시 필요합니다.)</td>
			</tr>
			<tr>
				<td>이메일</td>
				<td><input type="text" name="email" size="30"></td>
			</tr>
			<tr>
				<td>글 제목</td>
				<td><input type="text" name="title" size="50"></td>
			</tr>
			<tr>
				<td>글 내용</td>
				<td><textarea rows="20" cols="60" name="content"></textarea></td>
			</tr>
		</table>
		
		<div class="btn">
			<input type="submit" value="등록">
			<input type="reset" value="다시 작성">			
		</div>
	</form>

</body>
</html>