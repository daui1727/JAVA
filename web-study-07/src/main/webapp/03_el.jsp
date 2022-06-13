<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	\${5+2} : ${5+2} <br>
	\${5+2} : ${5+2} <br>
	 
	\${5 mod 2} : ${5 mod 2} <br>
	\${5 > 2} : ${5 > 2} <br>
	\${2 gt 10} : ${2 gt 10} <br>
	\${(5>2) ? 5 : 2} : ${(5>2) ? 5 : 2} <br>
	\${(5>2) || (2<10)} : ${(5>2) || (2<10)} <br>
	<%
		String input = null;
	%>
	\${emtpy input} :${empty input}<br>
	\${el : input} : ${input}<br>
	표현식 : input : <%= input%>
	

</body>
</html>