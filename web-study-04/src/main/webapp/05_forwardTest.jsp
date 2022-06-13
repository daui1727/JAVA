<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<%
	
		int age = Integer.parseInt(request.getParameter("age"));
		
		if(age<=19){
			%>
			<script type="text/javascript">
				alert("19세 미만 입장 불가능")
				history.go(-1)
			</script>
			<%
		}else{
			request.setAttribute("name", "성윤정");
			RequestDispatcher dispatcher = request.getRequestDispatcher("05_forwardResult.jsp");
			dispatcher.forward(request, response);
		}
	
	%>

</body>
</html>