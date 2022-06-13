<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<h1>정보 등록</h1>
	
	<form action="movieWrite.jsp" method="post">
		<table>
			<tr>
				<td>제목</td>
				<td><input type="text" name="title" /></td>
			</tr>
			
			<tr>
				<td>가격</td>
				<td><input type="text" name="price" /></td>
			</tr>
			
			<tr>
				<td>감독</td>
				<td><input type="text" name="director" /></td>
			</tr>
			
			<tr>
				<td>출연배우</td>
				<td><input type="text" name="actor" /></td>
			</tr>
			
			<tr>
				<td>시놉시스</td>
				<td><textarea rows="10" cols="40" name="synopsis"></textarea></td>
			</tr>
			
			<tr>
				<td>장르</td>
				<td>
					<select name="genre" size="4" multiple>
						<option>로맨스</option>
						<option>코미디</option>
						<option>액션</option>
						<option>스릴러</option>
						<option>미스터리</option>
						<option>애니메이션</option>
					</select>
				</td>
			</tr>
		</table>
		
		<input type="submit" value="확인">
		<input type="reset" value="취소">	

	
	</form>

</body>
</html>