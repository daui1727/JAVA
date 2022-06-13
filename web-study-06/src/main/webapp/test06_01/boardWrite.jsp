<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <%
    	request.setCharacterEncoding("utf-8");
    %>
    <jsp:useBean id="member" class="com.mission.javabeans.BoardBean"/>
    <jsp:setProperty name="member" property="*" />
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<h2>입력 완료된 정보</h2>
	<table>
			<tr>
				<td>작성자</td>
				<td><jsp:getProperty name="member" property="name" /></td>
			</tr>
			<tr>
				<td>비밀번호</td>
				<td><jsp:getProperty name="member" property="pass" /></td>
			</tr>
			<tr>
				<td>이메일</td>
				<td><jsp:getProperty name="member" property="email" /></td>
			</tr>
			<tr>
				<td>글 제목</td>
				<td><jsp:getProperty name="member" property="title" /></td>
			</tr>
			<tr>
				<td>글 내용</td>
				<td><jsp:getProperty name="member" property="content" /></td>
			</tr>
		</table>
		
		<%-- <table border="1">
	      <tr>
	         <th>작성자</th>
	         <td><%=member.getName() %></td>
	      </tr>
	      <tr>
	         <th>비밀번호</th>
	         <td><%=member.getPass() %></td>
	      </tr>
	      <tr>
	         <th>이메일</th>
	         <td><%=member.getEmail() %></td>
	      </tr>
	      <tr>
	         <th>글제목</th>
	         <td><%=member.getTitle() %></td>
	      </tr>
	      <tr>
	         <th>글내용</th>
	         <td><%=member.getContent() %></td>
	      </tr>
	   </table> --%>


</body>
</html>