<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
	.cen{margin-left: 195px;}
</style>
</head>
<body>

	<h2>정보 입력 폼</h2>
	
	<form action="itemWriteResult.jsp" method="post">
		<table>
			<tr>
				<th>상품명</th>
				<td><input type="text" id="name" name="name"></td>
			</tr>
			<tr>
				<th>가격</th>
				<td><input type="text" id="price" name="pr"></td>
			</tr>
			<tr>
				<th>설명</th>
				<td><textarea rows="10" cols="50" id="description" name="desc"></textarea></td>
			</tr>
		</table>
		
		<div class="cen">
			<input type="submit" value="전송">
			<input type="reset" value="취소">	
		</div>
	</form>
	
	
</body>
</html>