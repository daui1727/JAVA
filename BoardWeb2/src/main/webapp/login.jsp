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
		<h1>로그인</h1>
		<br><br>
		
		<form action="login.do" method="post">
			<table border="1">
				<tr>
					<td bgcolor="orange">아이디</td>
					<td><input type="text" name="id"/></td>
				</tr>
				
				<tr>
					<td bgcolor="orange">비밀번호</td>
					<td><input type="password" name="password"/></td>
				</tr>
				
				<tr>
					<td align="center" colspan="2"><input type="submit" value="로그인"/></td>
				</tr>
			</table>
		</form>
	</center>

</body>
</html>