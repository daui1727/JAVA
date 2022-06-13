<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원 정보 수정</title>
<link rel="stylesheet" href="css/common.css"/>
</head>
<body>

	<%@ include file="header.jsp" %>
	
	<section>
		<h2>홈쇼핑 정보 수정</h2>
		<form action="updateImpl.jsp" method="post">
		
			<table border="1" style="margin-left: auto; margin-right: auto;">
				<tr>
					<th>회원번호</th>
					<td><input type="text" name="custno" value="${mVo.custno}"><br></td>
				</tr>
				<tr>
					<th>회원성명</th>
					<td><input type="text" name="custname" value="${mVo.custname}"></td>
				</tr>
				<tr>
					<th>회원전화</th>
					<td><input type="text" name="phone" size="25" value="${mVo.phone}"></td>
				</tr>
				<tr>
					<th>회원주소</th>
					<td><input type="text" name="address" size="30" value="${mVo.address}"></td>
				</tr>
				<tr>
					<th>가입일자</th>
					<td><input type="text" name="joindate" value="${mVo.joindate}"></td>
				</tr>
				<tr>
					<th>고객등급 [A:VIP, B:일반, C:직원]</th>
					<td><input type="text" name="grade" value="${mVo.grade}"></td>
				</tr>
				<tr>
					<th>도시코드</th>
					<td><input type="text" name="city" value="${mVo.city}"></td>
				</tr>
				<tr class="txt-c">
					<td colspan="2"><input type="submit" value="수정">&nbsp;
					<input type="button" name="custno" value="조회" onclick="location.href='memberForm.jsp'">&nbsp;
					<input type="button" name="custno" value="삭제" onclick="location.href='deleteImpl.jsp?custno=${mVo.custno}">
					</td>
				</tr>
			</table>
		</form>
	</section>
	
	<%@ include file="footer.jsp" %>

</body>
</html>