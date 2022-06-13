<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="com.it.dao.*"%>

<jsp:useBean id="dao" class="com.it.dao.BoardDAO"/>

<%
	String no = request.getParameter("no");
	BoardVO vo = dao.boardDetailData(Integer.parseInt(no));  // 9) BoardDAO에 boardDetailData 기재
%>    

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시글</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<style type="text/css">

	.container{margin-top:50px;}
	.row{margin:0 auto; width:960px;}
	h1{text-align: center;}
	
</style>
</head>

<body>


	<div class="container">
		<h1>상세보기</h1>
		<div class="row">
			<table class="table">
				<tr>
					<th class="text-center danger" width="20%">번호</th>
					<td class="text-center" width="30%"><%= vo.getNo() %></td>
					<th class="text-center danger" width="20%">작성일</th>
					<td class="text-center" width="30%"><%= vo.getDbday() %></td>
				</tr>
				
				<tr>
					<th class="text-center danger" width="20%">이름</th>
					<td class="text-center" width="30%"><%= vo.getName() %></td>
					<th class="text-center danger" width="20%">조회수</th>
					<td class="text-center" width="30%"><%= vo.getHit() %></td>
				</tr>
				
				<tr>
					<th class="text-center danger" width="20%">제목</th>
					<td colspan="3"><%= vo.getSubject() %></td>
				</tr>
				
				<tr>
					<td colspan="4" class="text-left"height="200">
						<pre style="white-space:pre-wrap; border:none; background-color:white"><%= vo.getContent() %></pre>
					</td>
				</tr>
				
				<tr>
					<td colspan="4" class="text-right">
						<a href="update.jsp?no=<%= vo.getNo() %>" class="btn btn-xs btn-danger">수정</a>
						<a href="delete.jsp?no=<%= vo.getNo() %>" class="btn btn-xs btn-success">삭제</a>
						<a href="list.jsp" class="btn btn-xs btn-info">목록</a>
					</td>
				</tr>
			</table>
		</div>
	</div>

	<!-- 10) update.jsp 작성 -->


</body>
</html>