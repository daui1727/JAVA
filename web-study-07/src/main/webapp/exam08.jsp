<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<!-- 이 코드를 JSTL코드로 바꿔라 -->
	<%
		java.util.List<String> seasonList = new java.util.ArrayList<String>();
		seasonList.add("봄");
		seasonList.add("여름");
		seasonList.add("가을");
		seasonList.add("겨울");
		
		request.setAttribute("list", seasonList);
	%>
	
	<select name="season">
	<%
		java.util.ArrayList list = (java.util.ArrayList)request.getAttribute("list");
		int i;
		for(i = 0; i < list.size(); i++){
	%>
		<option value="<%= list.get(i)%>"> <%= list.get(i)%>
	<%
		}
	%>		

	</select>
	
	
</body>
</html>