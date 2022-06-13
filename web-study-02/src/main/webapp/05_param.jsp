<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="param.js"></script>
</head>

<body>
	
	<form action="ParamServlet" method="get" name = "frm">
		이 름 : <input type="text" name="name"><br>
		<label for = "userid">아이디 : </label>
		<input type="text" name="id" id="userid"><br>
		나 이 : <input type="text" name="age"><br>
		<input type="submit" value="전송" onclick = "return check()">
		
	</form>

</body>
</html>