<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="css/main.css"/>
</head>

<body>

	<center>
	
		<h1>새로운 글 등록</h1>
		<br><br>
		<a href="logout_proc.jsp">Log-out</a>
		
		<hr>
		
		<form action="insertBoard_proc.jsp" method="post">
			<table border="1">
				<tr>
					<td bgcolor="orange" width="70">제목</td>
					<td align="left"><input type="text" name="title"></td>
				</tr>
				
				<tr>
					<td bgcolor="orange">작성자</td>
					<td align="left"><input type="text" name="writer"></td>
				</tr>
				
				<tr>
					<td bgcolor="orange">내용</td>
					<td align="left"><textarea name="content" cols="40" rows="10"></textarea></td>
				</tr>
				
				<tr>
					<td bgcolor="orange">등록일</td>
					<td align="left"><input type="text" name="regDate" readonly></td>
				</tr>
				
				<tr>
					<td align="center" colspan="2">
						<input type="submit" value="등록하기">
					</td>
				</tr>
			</table>
		</form>
		
		<hr>
		
		<a href="deleteBoard.jsp">글 삭제</a>&nbsp;&nbsp;&nbsp;
		<a href="getBoardList.jsp">글 목록</a>
	
	</center>

</body>
</html>