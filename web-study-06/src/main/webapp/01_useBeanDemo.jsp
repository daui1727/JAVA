<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>자바 빈 객체 생성하기(useBean 액션 태그)</title>
</head>
<body>
	
	<!-- 객체 생성  MemberBean member = new MemberBean() 여기서는 id = "member"가 참조변수-->
	<jsp:useBean id="member" class="javabeans.MemberBean"/>
	
	<!-- 자바 빈 객체 생성 후 저장된 정보 출력하기 --><br><br>
	이름 : <%= member.getName() %><br>
	아이디 : <%= member.getUserid()%>
	<hr>
	
	<!-- 정보 변경한 후 변경된 정보 출력하기 --><br><br>
	<%
		member.setName("전수빈");
		member.setUserid("pinksubin");
	%>
	이름 : <%= member.getName() %><br>
	아이디 : <%= member.getUserid() %>
	
	
	

</body>
</html>