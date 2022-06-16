<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="css/main.css">
<script type="text/javascript" src="script/emp.js"></script>
</head>

<body>

	<div id="wrap" align="center">
		<h1> 정보 등록 </h1>
		<form action="MemberServlet" method="post" name="frm">
			<input type="hidden" name="command" value="emp_write">
			<table>
				<tr>
					<th>아이디</th>
					<td><input type="text" name="id" size="50"></td>
				</tr>
				
				<tr>
					<th>비밀번호</th>
					<td><input type="password" name="pass" size="50"></td>
				</tr>
				
				<tr>
					<th>이름</th>
					<td><input type="text" name="name" size="50"></td>
				</tr>
				
				<tr>
					<th>권한</th>
					<td>
						<select name="lev">
							<option value="A" selected>운영자</option>
							<option value="B">일반사원</option>
						</select>
					</td>
				</tr>
				
				<tr>
					<th>성별</th>
					<td>
						<select name="gender">
							<option value="1" selected>남자</option>
							<option value="2">여자</option>
						</select>
					</td>
				</tr>
				
				<tr>
					<th>전화번호</th>
					<td><input type="text" name="phone"></td>
				</tr>
				
			</table>
			<br><br>
			<input type="submit" value="확인" onclick="return empCheck()">
			<input type="reset" value="취소">
			<input type="button" value="목록" onclick="location.href='MemberServlet?command=emp_list'">
		</form>
	</div>

</body>
</html>