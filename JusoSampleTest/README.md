JusoSampleTest

환경
1. windows
2. sts tool (Version:3.9.17.RELEASE)
3. oracle 11g
4. jdk11
5. 인코딩 utf-8
6. git


순서
1. juso.go.kr로 접속
2. 주소기반산업지원서비스 - api 신청하기 - uri작성 http://localhost:8181(톰캣 포트)
3. 승인키 획득 /U01TX0FVVEgyMDIyMDYxMzA5NTI0ODExMjY4MDc=
4. 팝업 api에서 jsp source 다운
5. 다운 받은 파일을 index와 같은 위치에 복붙
6. sample.jsp에서 window.open url을 수정. 실행 후 버튼을 눌렀을때 승인되지 않은 KEY라고 팝업이 먼저 뜨게
7. jusoPopup.jsp안에 승인키 자리에 복붙. 한글 깨짐 주석도 다시 켜고~
8. 다시 실행하면 실행이 된다아~

9. 필요없는 부분 삭제. 이 예제에서는 도로명주소 전체 하나만 가져왔다.
10. sample.jsp에서 index.jsp로 script 복붙
11. button에 onclick메서드 작성
12. script의 jusoCallBack 부분 name과 id를 맞게 변경.

function init(){
	var url = location.href;
	var confmkey = "승인키";   // 승인키란에 획득한 승인키를 붙여넣기 한다.
}