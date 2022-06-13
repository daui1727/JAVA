<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.Arrays"%>
    
    <%
    	request.setCharacterEncoding("utf-8");
    %>
    <jsp:useBean id="member" class="com.mission.javabeans.MovieBean" />
    <jsp:setProperty name="member" property="*" />
    <%
    	String[] showGenre = request.getParameterValues("genre");
    	String str = "";
    	if(member.getGenre() != null){
    		for(String tmp : member.getGenre()){
    			str += tmp + " ";
    		}
    	}
    %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<h1>입력 완료된 정보</h1>
	
	<table>
			<tr>
				<td>제목</td>
				<td><jsp:getProperty name="member" property="title" /></td>
			</tr>
			
			<tr>
				<td>가격</td>
				<td><jsp:getProperty name="member" property="price" /></td>
			</tr>
			
			<tr>
				<td>감독</td>
				<td><jsp:getProperty name="member" property="director" /></td>
			</tr>
			
			<tr>
				<td>출연배우</td>
				<td><jsp:getProperty name="member" property="actor" /></td>
			</tr>
			
			<tr>
				<td>시놉시스</td>
				<td><textarea rows="10" cols="40"><jsp:getProperty name="member" property="synopsis" /></textarea></td>
			</tr>
			
			<tr>
				<td>장르</td>
				<td>
					<%-- <jsp:getProperty name="member" property="genre[i]" /> --%>
				
					<!-- 1번 방법 -->	
					<%= str %>
					
					<!-- 2번 방법  -->
					<%-- <%
						if(showGenre == null){
							out.print(" 선택하지 않았습니다.");
						} else {

							for(int i = 0; i <showGenre.length; i++) {

								out.print(showGenre[i] + "  ");
							}
						}
					%> --%>
				</td>
			</tr>
		</table>

</body>
</html>