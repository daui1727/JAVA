<%@page import="java.util.ArrayList"%>
<%@page import="com.it.dao.MemberDAO"%>
<%@page import="com.it.dto.MemberVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원목록 조회 / 수정</title>
<link rel="stylesheet" href="css/common.css"/>
<style type="text/css">
	section tr{height:45px; text-align:center;}
</style>
</head>
<body>

	<%@ include file="header.jsp" %>
	
	<section>
		<h2>회원목록 조회 / 수정</h2>
			<table border="1" style="margin-left: auto; margin-right: auto;">
				<tr>
					<th>회원번호</th>
					<th>회원성명</th>
					<th>전화번호</th>
					<th>주소</th>
					<th>가입일자</th>
					<th>고객등급</th>
					<th>거주지역</th>
				</tr>
				<%
				MemberDAO mDao = new MemberDAO();
				ArrayList<MemberVO> list = mDao.boardListData();
				for(MemberVO vo : list){
				%>
					<tr>
						<td><a href="updateForm.do?cutno=<%= vo.getCustno() %>"><%= vo.getCustno()%></a></td>
						<td><%= vo.getCustname()%></td>
						<td><%= vo.getPhone()%></td>
						<td><%= vo.getAddress()%></td>
						<td><%= vo.getJoindate()%></td>
						<td><%= vo.getGrade()%></td>
						<td><%= vo.getCity()%></td>
					</tr>
				<%
				}
				%>
				
			</table>
	</section>
	
	<%@ include file="footer.jsp" %>

</body>
</html>