MovieTest - 594p 문제

환경
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


////////////////////////////////////////////////////////////////////////
// 
MemberVO 작성
create table movie (
    code number(4),
    title varchar2(50),
    price number(10),
    director varchar2(20),
    actor varchar2(20),
    poster varchar2(100),
    synopsis varchar2(3000),
    PRIMARY KEY (code)
);


// 
server.xml
-->  <Resource auth="Container"
		driverClassName="oracle.jdbc.OracleDriver" maxIdle="10"
		maxTotal="20" maxWaitMillis="-1" name="jdbc/myoracle"
		password="tiger" type="javax.sql.DataSource"
		url="jdbc:oracle:thin:@127.0.0.1:1521:xe" username="scott" />
	</Context>
DB연결

//
MemberDAO 작성
--> 
private MemberDAO() {}
	
//싱글톤 객체 생성
private static MemberDAO instance = new MemberDAO();

public static MemberDAO getInstance() {
	return instance;
}

//
index -> movieList.do 호출

//
MovieListServlet doGet 작성, selectALLMovies()메서드 DAO에 작성, movieList.jsp 호출

//
movieList.jsp 작성, css도 작성
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 사용

<c:forEach var="movie" items="${movieList}">
	<tr class="record">
		<td> ${movie.title} </td>
		<td> ${movie.director} </td>
		<td> ${movie.actor} </td>
		<td> ${movie.price} </td>
		<td><a href="movieUpdate.do?code=${movie.code}">정보 수정</a></td>
		<td><a href="movieDelete.do?code=${movie.code}">정보 삭제</a></td>
	</tr>
</c:forEach>

//
// 다음 MovieWriteServlet 작성
doGet에서 movieWrite.jsp로 보내준다

//
movieWrite.jsp 작성

//
doPost에서 업로드 관련 코드 작성

ServletContext context = getServletContext(); // 업로드할 파일 경로를
String path = context.getRealPath("upload");  // 서버 상의 실제 경로로 찾아온다.
String encType = "UTF-8";
int sizeLimit = 20*1024*1024;

MultipartRequest multi = new MultipartRequest(request, path, sizeLimit, encType, new DefaultFileRenamePolicy());
String title = multi.getParameter("title");
int price = Integer.parseInt(multi.getParameter("price"));
String director = multi.getParameter("director");
String actor = multi.getParameter("actor");
String synopsis = multi.getParameter("synopsis");
String poster = multi.getFilesystemName("poster");

insertMovie() 메서드 DAO에 작성
* insert에서 넣는 순서를 poster먼저 해야한다 db 테이블을 잘 보고 넣자

//
// 다음 MovieUpdateServlet 작성
doGet에서 코드를 받아주고 -- String code = request.getParameter("code");
selectMovieByCode() 메서드 DAO에 작성
movie에 mVo 값을 넣어주고 포워드로 movieUpdate.jsp 호출

//
movieUpdate.jsp 작성

//
doPost에서 업로드 관련 코드 작성

updateMovie() 메서드 DAO에 작성

//
// 다음 MovieDeleteServlet 작성
doGet에서 코드를 받아주고 -- String code = request.getParameter("code");
deleteMovie() 메서드 DAO에 작성

response.sendRedirect("movieList.do");

끝



<cos.jar를 이용한 업로드>
1. webapp 아래에 upload 폴더 생성
2. 업로드할 폼을 작성. form의 method는 post, enctype="multipart/form-data"를 설정한다. enctype 속성을 사용해야 업로드가 가능하다.

form으로부터 넘어온 파일을 실제로 업로드를 할 로직을 작성한다. 
enctype 속성에 의해 request나 setProperty 액션 태그로 값을 받을 수 없다.
따라서 cos 라이브러리에서 제공하는 MultipartRequest 객체를 이용해야한다.








