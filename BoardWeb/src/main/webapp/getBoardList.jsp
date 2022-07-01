<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.springbook.biz.board.impl.BoardDAO" %>  
<%@ page import="com.springbook.biz.board.BoardVO" %>  
<%@page import="java.util.*"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%
	request.setCharacterEncoding("utf-8");

	BoardVO vo = new BoardVO();
	
	BoardDAO boardDAO = new BoardDAO();
	

%>

<%
	/* 340p 이후 주석처리 List<BoardVO> boardList = (List)session.getAttribute("boardList"); */
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="css/main.css"/>
</head>
<body>

	<center>
	
		<h1>글 목록</h1><br><br>
		<h3>테스트님 환영합니다...<a href="logout.do">Log-out</a></h3>
		
		<!-- 검색 시작 -->
		<form action="getBoardList.jsp" method="post">
			<table>
				<tr>
					<td align="right">
						<select name="searchCondition">
							<option value="TITLE">제목</option>
							<option value="CONTENT">내용</option>
						</select>
						<input type="text" name="searchKeyword"/>
						<input type="submit" value="검색"/>
					</td>
				</tr>
			</table>
		</form>
		<!-- 검색 종료 -->
		
		<table border="1">
			<tr>
				<th bgcolor="orange" width="100">번호</th>
				<th bgcolor="orange" width="200">제목</th>
				<th bgcolor="orange" width="150">작성자</th>
				<th bgcolor="orange" width="150">등록일</th>
				<th bgcolor="orange" width="100">조회수</th>
			</tr>
			
			<%-- <% for(BoardVO board : boardList){ %> --%>
			<c:forEach items="${boardList}" var="board">
				<tr>
					<td>${board.seq}</td>
					<td align="left"><a href="getBoard.do?seq=${board.seq}">${board.title}</a></td>
					<td>${board.writer}</td>
					<td>${board.regDate}</td>
					<td>${board.cnt}</td>
				</tr>
			</c:forEach>
			
			<%-- <% } %> --%>
		</table>
		<br>
		
		<a href="insertBoard.jsp">새 글 등록</a>
	
	
	</center>
	
	
	
	<!-- <input type="button" value="뒤로가기" onclick="location.href='javascript:history.back()'"> -->

</body>
</html>