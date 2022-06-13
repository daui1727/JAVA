<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>홈쇼핑 회원 등록</title>
<script type="text/javascript" src="script/member.js"></script>
<link rel="stylesheet" href="css/common.css"/>
</head>

<body>

	<%@ include file="header.jsp" %>
	
	<section>
		<h2>홈쇼핑 회원 등록</h2>
		<form action="joinForm.do" method="post" name="frm">
			<table border="1" style="margin-left: auto; margin-right: auto;">
				<tr>
					<th>회원번호(자동발생)</th>
					<td><input type="text" name="custno" value="${mVo.custno}" readonly><br></td>
				</tr>
				<tr>
					<th>회원성명</th>
					<td><input type="text" name="custname"></td>
				</tr>
				<tr>
					<th>회원전화</th>
					<td><input type="text" name="phone" size="25"></td>
				</tr>
				<tr>
					<th>회원주소</th>
					<td><input type="text" name="address" size="30"></td>
				</tr>
				<tr>
					<th>가입일자</th>
					<td><input type="text" name="joindate" id="date"></td>
				</tr>
				<tr>
					<th>고객등급 [A:VIP, B:일반, C:직원]</th>
					<td><input type="text" name="grade" id="fname"></td>
				</tr>
				<tr>
					<th>도시코드</th>
					<td><input type="text" name="city" id="city_num"></td>
				</tr>
				<tr class="txt-c">
					<td colspan="2"><input type="submit" value="등록" onclick="return registerCheck()">&nbsp;
					<input type="button" name="custno" value="조회" onclick="location.href='memberForm.jsp'"></td>
				</tr>
				
			</table>
		</form>
	</section>
	
	<%@ include file="footer.jsp" %>

</body>
</html>