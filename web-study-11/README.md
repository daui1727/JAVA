WEB-STUDY-10

********************************** 환경
1. windows
2. sts tool (Version:3.9.17.RELEASE)
3. oracle 11g
4. jdk11
5. 인코딩 utf-8
6. git
7. jstl.jar
8. objdbc6.jar
9. standard.jar
10. cos.jar(version:cos-22.05.zip)
11. lombok-1.18.24.jar


*********************************** DB
create table board(
    num number(5) PRIMARY KEY,
    pass varchar2(30),
    name varchar2(30),
    email varchar2(30),
    title varchar2(50),
    content varchar2(1000),
    readcount number(4) DEFAULT 0,
    writedate date DEFAULT sysdate
);

create SEQUENCE board_seq start with 1 INCREMENT by 1;

insert into board(num, name, email, pass, title, content) 
values(BOARD_SEQ.NEXTVAL, '성윤정', 'pinksung@nate.com', '1234', '첫방문', '반갑습니다');
insert into board(num, name, email, pass, title, content) 
values(BOARD_SEQ.NEXTVAL, '홍길동', 'one@nate.com', '1234', '김밥', '맛있음');
insert into board(num, name, email, pass, title, content) 
values(BOARD_SEQ.NEXTVAL, '전수빈', 'two@nate.com', '3333', '고등어', '생선입니다');
insert into board(num, name, email, pass, title, content) 
values(BOARD_SEQ.NEXTVAL, '전원지', 'three@nate.com', '1111', '갯골마을', '돼지삼겹살이 맛있습니다');

commit;

************************************* 특징
dbcp : <Resource auth="Container"
			driverClassName="oracle.jdbc.OracleDriver" maxIdle="10"
			maxTotal="20" maxWaitMillis="-1" name="jdbc/myoracle"
			password="tiger" type="javax.sql.DataSource"
			url="jdbc:oracle:thin:@127.0.0.1:1521:xe" username="scott" />
		</Context>

당연하게도 비번과 아이디 등은 어디 올릴때 보여주면 안됩니다..





************************************* 공부

PreparedStatement란:데이터베이스 관리 시스템(DBMS)에서 동일하거나 비슷한 데이터베이스 문을 높은 효율성으로 반복적으로 실행하기 위해 사용되는 기능을 말할다.

그럼 PreparedStatement는 어떤식으로 동작할까?

1.준비(Prepare): 먼저 애플리케이션은 문의 틀을 만들고 이를 DBMS로 보낸다. 특정값은 지정하지 않은 채로 남겨진다 
INSERT INTO products (name, age) VALUES (?, ?);
 
2.그 다음, DBMS는 문의 틀을 컴파일하며(최적화 및 변환) 아직 실행하지 않고 결과만 저장한다.

3.실행(Execute): 나중에 애플리케이션이 문 틀의 변수에 값(바인드)을 지정하면 DBMS는 (결과를 반환할 수도 있는) 문을 실행한다. 애플리케이션은 여러 값으로 원하는 횟수만큼 문을 실행할 수 있다. 위의 예에서 첫 번째 변수로 "bike"로, 두 번째 변수로 "20"을 지정한다.

Statement와 PreparedStatement의 아주 큰 차이는 바로 캐시(cache)사용여부이다. 

Statement를 사용하면 매번 쿼리를 수행할 때마다 4단계를 거치게 되고(계속적으로 단계를 거치면서 수행)
PreparedStatement는 처음 한 번만 세 단계를 거친 후 캐시에 담아 재사용을 한다는 것이다. 만약 동일한 
쿼리를 반복적으로 수행한다면 PreparedStatment가 DB에 훨씬 적은 부하를 주며, 성능도 좋다.

Statement는 SQL문을 수행하는 과정에서 매번 컴파일을 하기 때문에 Prepared Statement에 비해 효율성이 떨어진다.


*************************************************

JSP의 표현언어인 param과 paramValues는 전송방식(get 혹은 post)와 관계없이 form으로 부터 전달되는 값을 매개변수로 받을 수 있다.
param --> request.getParameter()와 비슷하게 매개변수를 받아온다.
paramValues --> request.getParamaterValues()와 비슷하게 String형 배열로 매개변수를 받는다.

ex)

PersonForm.jsp

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ParaForm.jsp</title>
</head>
<body>
	<h2>Form으로 데이터 전달하기</h2>
	<form name="person" method="post" action="PersonResult.jsp">
	이름 : <input type="text" name="name" /><br />
	나이 : <input type="number" name="age" /><br />
		
		
   취미 :
	<select name="hobby">
		<option value="Game">게임</option>
		<option value="Cokking">요리</option>
		<option value="Reading">독서</option>
	</select><br />
		
   관심사항 :
	<input type="checkbox" name="Interests" value="politics" />경제
	<input type="checkbox" name="Interests" value="culture" />문화
	<input type="checkbox" name="Interests" value="sports" />스포츠 <br />
	<input type="submit" value="transmit" />
	</form>
</body>
</html>

위와 비교

PersonResult.jsp

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>PersonResult.jsp</title>
</head>
<body>
	<h2>param과 pramValus로 매개변수 받기</h2>
	이름 : ${ param.name } <br />
	나이 : ${ param.age }  <br />
	취미 : ${ param.hobby }<br />
	관심사항 : ${paramValues.Interests[0] }
		${paramValues.Interests[1] }
		${paramValues.Interests[2] }
</body>
</html>



*************************************************

MVC

Client가 controller에게 command 요청
controller가 handler에게 command를 전달하고 어떤 기능을 요청했는지 분석

controller --> BoardServlet
handler    --> ActionFactory

model 	   -->  --??--Action 들  --> interface --> Action
view       --> JSP들

Client 요청 --> Controller가 요청을 받아들여 Handler에게 기능 분석 요청 --> 요청에 따라
Model 실행 (BoardDetailAction 등에서 값을 받아주고 DAO에 기재된 메서드를 수행하여 해당하는
View로 넘겨줌) 괄호 안의 기능을 수행하는 해당 객체가 Controller에서 생성되어 Client에게 화면을 다시 보여준다. 



new BoardListAction().execute(request, response); 부분 체크.

***************************************************





		