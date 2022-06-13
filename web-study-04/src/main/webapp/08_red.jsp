<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body bgcolor="red">

	이 파일은 red.jsp입니다.<br>
	브라우저에 배경색이 빨간색으로 나타날까요?
	노란색으로 나타날까요?
	
	forward 액션태그가 실행되면 이 페이지의 내용은 출력되지 않습니다. <br>
	<jsp:forward page = "08_yellow.jsp"/>
	

</body>
</html>