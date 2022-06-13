<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>주소창 띄우기</title>
</head>

<body>

	<form action="join" method="post" name="frm">
		아이디 : <input type="text" name="id" required><br>
		비밀번호 : <input type="password" name="pwd" required="required" readonly="readonly"><br>
		주소 : <input type="text" id="address" name="address" size="70" required="required" readonly><br>
		<input type="button" value="주소검색" onclick="goPopup()"><br>
		<input type="submit" value="전송">
	</form>
	
	<script language="javascript">
		function goPopup(){
			var pop = window.open("jusoPopup.jsp","pop","width=570,height=420, scrollbars=yes, resizable=yes"); 
		}
		
		
		function jusoCallBack(roadFullAddr){
				document.frm.address.value = roadFullAddr;
		}
	</script>

	<!--
	
		 port 확인. 예제 작성 땐 8181이였음.
		juso.go.kr - 주소기반산업지원서비스 - api 신청하기 팝업api 업체명 시스템명 입력(중요 x) 
		url 작성에 http://localhost:8181
		인증하고 승인키 복사
		///U01TX0FVVEgyMDIyMDYxMzA5NTI0ODExMjY4MDc=   ////
		팝업 api 가서 jsp 다운
		다운 받은 파일을 index와 같은 위치에 복붙
		sample.jsp에서 window.open url을 수정. 실행 후 버튼을 눌렀을때 승인되지 않은 KEY라고 팝업이 먼저 뜨게
		jusoPopup.jsp안에 승인키 자리에 복붙. 한글 깨짐 주석도 다시 켜고~
		다시 실행하면 실행이 된다아~
		
		필요없는 부분 삭제. 이 예제에서는 도로명주소 전체 하나만 가져왔다.
		sample.jsp에서 index.jsp로 script 복붙
		button에 onclick메서드 작성
		script의 jusoCallBack 부분 name과 id를 맞게 변경.
		
		
	 -->

</body>
</html>