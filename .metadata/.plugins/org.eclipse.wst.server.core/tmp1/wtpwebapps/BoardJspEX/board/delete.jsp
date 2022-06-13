<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String no = request.getParameter("no");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>삭제하기</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<style type="text/css">

	.container{margin-top:50px;}
	.row{margin:0 auto; width:960px;}
	h1{text-align: center;}
	
</style>
<script type="text/javascript" src="http://code.jquery.com/jquery.js"></script>
<script type="text/javascript">
	
	$(function(){
		
		$('#delBtn').click(function(){
			let pwd = $('#pwd').val();
			if(pwd.trim() == ""){  // 비밀번호 입력값 확인
				$('#pwd').focus();
				return;
			}
		})
		
		$.ajax({
			type:'POST',  // 전송 방식
			url: 'delete_imple.jsp',  // 데이터를 받아올 페이지
			data:{"no":$('#no').val, "pwd":pwd}  // 데이터 요청 시에 함께 보낼 전송 파라미터
			success:function(res){  // 성공 시에 수행할 핸들러를 받는다.
				let r = res.trim();
				if(r == 0){
					alert("비밀번호가 틀립니다.");
					$('#pwd').val("");
					$('#pwd').focus();
				}else{
					location.href="list.jsp";
				}
			}
		})
		
	})
	
</script>
</head>

<body>

	<div class="container">
		<h1>삭제하기</h1>
		<div class="row">
			<form action="delete_imple.jsp" method="get">
				<table class="table">
					<tr>
						<td class="text-center">
							비밀번호 : <input type="password" name="pwd" size="10" class="input-sm" id="pwd">
							<input type="hidden" id="no" name="no" value=<%= no %>>
						</td>
					</tr>
					
					<tr>
						<td class="text-center">
							<input type="submit" value="삭제" class="btn btn-sm btn-primary" id="delBtn">
							<input type="button" value="취소" class="btn btn-sm btn-primary" onclick="javascript:history.back()">
						</td>
					</tr>
				</table>
			</form>
		</div>
	</div>
	
	<!-- 14) delete_imple.jsp 작성 -->

</body>
</html>