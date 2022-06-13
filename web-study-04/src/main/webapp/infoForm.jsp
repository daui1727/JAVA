<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
	form input[type=text]{margin-left:52px;}
</style>
</head>
<body>

	가입할 ID와 Password 및 자기소개를 입력하세요.
	<form action="infoResult.jsp" method="post"><br>
		ID  <input type="text" name="id"><br>
		Password  <input type="password" name="pw"><br><br>
		자기소개<br>
		<textarea name="desc" rows="4" cols="50"></textarea><br>
		<input type="submit" value="전송">
		<input type="reset" value="초기화">
	</form>

</body>
</html>