<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>새로운 게시글 작성</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<style type="text/css">

	.container{margin-top:50px;}
	.row{margin:0 auto; width:960px;}
	h1{text-align: center;}
	
</style>
</head>

<body>

	<div class="container">
		<h1>글쓰기</h1>
		<div class="row">
			<form action="insert_imple.jsp" method="get">
				<table class="table">
					<tr>
						<th class="text-right">이름</th>
						<td>
							<input type="text" name="name" size="15" class="input-sm">
						</td>
					</tr>
					<tr>
						<th class="text-right">제목</th>
						<td>
							<input type="text" name="subject" size="55" class="input-sm">
						</td>
					</tr>
					<tr>
						<th class="text-right">내용</th>
						<td>
							<textarea rows="10" cols="55" name="content"></textarea>
						</td>
					</tr>
					<tr>
						<th class="text-right">비밀번호</th>
						<td>
							<input type="password" name="pwd" size="10" class="input-sm">
						</td>
					</tr>
					<tr>
						<td colspan="2" class="text-center">
							<input type="submit" value="글쓰기" class="btn btn-sm btn-primary">
							<input type="button" value="취소" class="btn btn-sm btn-primary" onclick="javascript:history.back()">
						</td>
					</tr>
				</table>
			</form>
		</div>
	</div>
	
	<!-- 6) insert_imple.jsp 작성 -->

</body>
</html>