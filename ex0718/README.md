0714 - 수업

********************* 처음부터.

**1. 설정 변경 / pom.xml 변경

1.8 / 5.2.7 / ${java-version}

**2. pom.xml에 DI 추가 /  lombok, ojdbc8, junit 수정 등
<!-- https://mvnrepository.com/artifact/org.projectlombok/lombok -->
<dependency>
    <groupId>org.projectlombok</groupId>
    <artifactId>lombok</artifactId>
    <version>1.18.24</version>
    <scope>provided</scope>
</dependency>

<!-- https://mvnrepository.com/artifact/com.oracle.database.jdbc/ojdbc8 -->
<dependency>
    <groupId>com.oracle.database.jdbc</groupId>
    <artifactId>ojdbc8</artifactId>
    <version>21.6.0.0.1</version>
</dependency>

<dependency>
	<groupId>org.springframework</groupId>
	<artifactId>spring-test</artifactId>
	<version>${org.springframework-version}</version>
</dependency>

<dependency>
	<groupId>org.springframework</groupId>
	<artifactId>spring-jdbc</artifactId>
	<version>${org.springframework-version}</version>
</dependency>

<dependency>
	<groupId>org.springframework</groupId>
	<artifactId>spring-tx</artifactId>
	<version>${org.springframework-version}</version>
</dependency>

-- 수정
<!-- Test -->
<dependency>
	<groupId>junit</groupId>
	<artifactId>junit</artifactId>
	<version>4.12</version>
	<scope>test</scope>
</dependency>

<dependency>
	<groupId>log4j</groupId>
	<artifactId>log4j</artifactId>
	<version>1.2.17</version>
</dependency>


**3. sql developer에서 혹시나 있을 톰캣 오류를 대비하기 위해서 포트번호 변경 / 안해도 되긴 했음;
system 계정에서.

select DBMS_XDB.GETHTTPPORT() from dual; -- 현재 사용 포트번호 확인

exec dbms_xdb.sethttpport(8080);  -- 8080으로 포트번호 변경

**4. book 계정에서 아래 추가

-- 오라클 사용자 생성
create user book IDENTIFIED by book
default TABLESPACE users
TEMPORARY TABLESPACE temp;

grant connect, dba to book;

**5. src/test/java 에 org.zerock.persistence 패키지 생성 JDBCTests.java 클래스 생성.

	@Log4j
	public class JDBCTests {
	
	static {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void testConnection() {
		try (Connection conn = DriverManager.getConnection(
				"jdbc:oracle:thin:@localhost:1521:xe",
				"book",
				"1234"
				)){
			log.info(conn);
		}catch(Exception e) {
			e.printStackTrace();
		}
	 }
	}
	
**6. pom.xml에 hikariCP 추가 / 커넥션 풀 DBCP 역할
<!-- https://mvnrepository.com/artifact/com.zaxxer/HikariCP -->
<dependency>
    <groupId>com.zaxxer</groupId>
    <artifactId>HikariCP</artifactId>
    <version>5.0.1</version>
</dependency>

**7. root-context.xml 에 아래 추가
<!-- HikariCP 설정 객체 생성 / id 객체를 생성하지 않으면 HikariConfig(hikariConfig) 자동 지정-->
<bean id="hikariConfig" class="com.zaxxer.hikari.HikariConfig">
	<property name="driverClassName" value="oracle.jdbc.driver.OracleDriver"/>
	<!-- setter 방식 주입 - setDriverClassName -->
	<property name="jdbcUrl" value="jdbc:oracle:thin:@localhost:1521:xe"/>
	<property name="username" value="book"/>
	<property name="password" value="1234"/>
</bean>
	
<!-- HikariCP로 데이터 가져오기(dataSource) 객체 생성 -->
<bean id="dataSource" class="com.zaxxer.hikari.HikariDataSource" destroy-method="close">
	<constructor-arg ref="hikariConfig"/>
</bean>

**8. org.zerock.persistence 패키지에 DataSourceTests.java 클래스 작성

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Log4j
public class DataSourceTests {

 @Autowired
 private DataSource dataSource;

 @Test
 public void testConnection() { // hikaricp 연동이 잘 되었는지 확인
 	 try (Connection conn = dataSource.getConnection()){
		 log.info("----------------------------------");
		 log.info("dataSource : " + dataSource);
		 log.info(conn);
		 log.info("----------------------------------");
	 }catch(Exception e) {
		 e.printStackTrace();
	 }
  }
}

**9. pom.xml에 mybatis, mybatis-spring 추가
<!-- https://mvnrepository.com/artifact/org.mybatis/mybatis -->
<dependency>
    <groupId>org.mybatis</groupId>
    <artifactId>mybatis</artifactId>
    <version>3.5.10</version>
</dependency>

<!-- https://mvnrepository.com/artifact/org.mybatis/mybatis-spring -->
<dependency>
    <groupId>org.mybatis</groupId>
    <artifactId>mybatis-spring</artifactId>
    <version>2.0.7</version>
</dependency>

*****
* jdbc 연결
.connection 연결하고 close 작업
.preparedstatement 생성 및 처리
.setXX() 처리
.select문 ResultSet 처리 등

*Mybatis
자동 연결 및 해제
Mybatis가 내부적으로 preparestatement처리
ResultSet 처리도 Mybatis 처리함

Sql문 처리만 신경쓴다.


spring boot에서는 jpa를 사용
*****

**10. root-context.xml 에 아래 추가
<!-- Mybatis와 Spring 연결 객체 -->
<bean id="sqlSessionFactory" class="org.mybatis.spring.SqlSessionFactoryBean">
	<property name="dataSource" ref="dataSource"></property>
</bean>

<mybatis-spring:scan base-package="org.zerock.mapper"/>

**11. org.zerock.mapper 패키지 생성 후 TimeMapper.java 인터페이스 작성
public interface TimeMapper {
	
	public String getTime();

}

**12. src/main/resources 에 org/zerock/mapper 폴더 만들고 TimeMapper.xml 작성
<?xml version="1.0" encoding="UTF-8" ?>
<!DOCTYPE mapper
  PUBLIC "-//mybatis.org//DTD Mapper 3.0//EN"
  "http://mybatis.org/dtd/mybatis-3-mapper.dtd">
  
<mapper namespace="org.zerock.mapper.TimeMapper">
  <select id="getTime2" resultType="string">
    select sysdate from dual
  </select>
</mapper>

**13. org.zerock.persistence 패키지에 TimeMapperTests.java 클래스 작성 후 테스트 실행
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Log4j
public class TimeMapperTests {
	
	@Autowired
	private TimeMapper mapper;
	
	@Test
	public void testGetTime() {
		log.info("---------------------");
		log.info(mapper.getTime());
		log.info(mapper.getClass().getName());
		log.info("---------------------");
	}
}


**14. pom.xml에 아래 추가
<!-- https://mvnrepository.com/artifact/org.bgee.log4jdbc-log4j2/log4jdbc-log4j2-jdbc4.1 -->
<dependency>
    <groupId>org.bgee.log4jdbc-log4j2</groupId>
    <artifactId>log4jdbc-log4j2-jdbc4.1</artifactId>
    <version>1.16</version>
</dependency>


**15. log4jdbc.log4j2.properties 파일을 src/main/resources 와 src/test/resources 에 추가
log4jdbc.spylogdelegator.name=net.sf.log4jdbc.log.slf4j.Slf4jSpyLogDelegator

**16. root-context.xml 수정
<property name="driverClassName" value="net.sf.log4jdbc.sql.jdbcapi.DriverSpy"/>
<property name="jdbcUrl" value="jdbc:log4jdbc:oracle:thin:@localhost:1521:xe"/>

******
log 기록 정리

log4j.xml 에 아래 추가

<logger name="jdbc.audit">
		<level value="warn" />
</logger>

<logger name="jdbc.resultset">
	<level value="warn" />
</logger>

<logger name="jdbc.connection">
	<level value="warn" />
</logger>

<!-- Root Logger -->

******



**17. org.zerock.controller 패키지에 SampleController.java 클래스 작성
@Controller
@RequestMapping("/sample/*")
@Log4j
public class SampleController {

	@RequestMapping("/basic")
	public void basic() {
		log.info("basic ----------------- ");
	}
}

**18. views 폴더에 sample 폴더, basic.jsp 생성

주소창에 http://localhost:8181/sample/basic 입력했을때 나오면 됩니다.

**19. src/main/java 에 org.zerock.domain 패키지 생성, SampleVO.java 클래스 작성
@Data
public class SampleVO {
	
	private String name;
	private int age;
	
}

**20. org.zerock.controller 패키지에 SampleController.java 클래스를 아래처럼 수정
@Controller
@RequestMapping("/sample/*")
@Log4j
public class SampleController {

	@GetMapping("/basic")
	public void basic(SampleVO vo) {
		log.info("basic ----------------- ");
		log.info("vo ==> " + vo);
	}
}

http://localhost:8181/sample/basic?name=aaa&age=20 이렇게 입력하면 콘솔창에 값이 찍힌다.

**21. org.zerock.controller 패키지에 SampleController.java 클래스를 아래처럼 수정
@Controller
@RequestMapping("/sample/*")
@Log4j
public class SampleController {

	@GetMapping("/basic")
	public void basic(SampleVO vo, Model model) {
		log.info("basic ----------------- ");
		log.info("vo ==> " + vo);
		model.addAttribute("list", vo);
	}
}

**22. basic.jsp 수정
<h1>${list}</h1>
<h1>${list.name}</h1>
<h3>${sampleVO}</h3>
<h3>${sampleVO.name}</h3>

http://localhost:8181/sample/basic?name=aaa&age=20 주소창 입력하면 화면에 표시된다.

@GetMapping("/basic")
public String basic(SampleVO vo, Model model) {
	log.info("basic ----------------- ");
	log.info("vo ==> " + vo);
	model.addAttribute("list", vo);
	return "sample/basic";
}
	
이렇게도 표시 가능.

**23. sql developer에 아래 추가
create SEQUENCE seq_board;

create table tbl_board(
    bno number(10,0),
    title varchar2(200) not null,
    content varchar2(2000) not null,
    writer varchar2(20) not null,
    regdate date default sysdate,
    updatedate date default sysdate
);

alter table tbl_board add CONSTRAINT pk_board PRIMARY key(bno);

insert into TBL_BOARD(bno, title, content, writer)
values(seq_board.nextval, 'java', '내용...', '남궁성');

select * from TBL_BOARD;

commit;

**24. org.zerock.domain 패키지에 BoardVO.java 클래스 작성
@Data
public class BoardVO {
	
	private Long bno;
	private String title, content, writer;
	private Date regdate, updatedate;

}


**25. org.zerock.mapper 패키지 안에 BoardMapper.java 인터페이스 작성
public interface BoardMapper {

	public List<BoardVO> getList();
	
}


**26. src/main/resources 안 mapper 폴더 안에 BoardMapper.xml 작성
<?xml version="1.0" encoding="UTF-8"?>
<!DOCTYPE mapper
  PUBLIC "-//mybatis.org//DTD Mapper 3.0//EN"
  "http://mybatis.org/dtd/mybatis-3-mapper.dtd">
  
<mapper namespace="org.zerock.mapper.BoardMapper">
  <select id="getList" resultType="org.zerock.domain.BoardVO">
    select * from tbl_board where bno > 0
  </select>
</mapper>

**27. src/test/java 안 org.zerock.mapper 패키지 작성 후 BoardMapperTests.java 클래스 작성
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Log4j
public class BoardMapperTests {
	
	@Autowired
	private BoardMapper mapper;
	
	@Test
	public void testGetList() {
		log.info("---------------------");
		log.info(mapper.getList());
		log.info("---------------------");
	}

}

**28. Read / BoardMapper.java 인터페이스에 아래 추가
public BoardVO read(Long bno);

BoardMapper.xml 에 아래 추가
<select id="read" resultType="org.zerock.domain.BoardVO">
  	select * from tbl_board where bno = #{bno}
</select>


BoardMapperTests.java 클래스에 아래 추가 후 실행
@Test
public void testRead() {
	log.info("---------------------");
	log.info(mapper.read(2L));
	log.info("---------------------");
}


**29. Delete / BoardMapper.java 인터페이스에 아래 추가
public int delete(Long bno);

BoardMapper.xml 에 아래 추가
<delete id="delete">
  	delete from tbl_board where bno = #{bno}
</delete>


BoardMapperTests.java 클래스에 아래 추가 후 실행
@Test
public void testDelete() {
	log.info("---------------------");
	log.info(mapper.delete(2L));
	log.info("---------------------");
}


**30. Insert / BoardMapper.java 인터페이스에 아래 추가
public int insert(BoardVO vo);

BoardMapper.xml 에 아래 추가
<insert id="insert">
  	insert into TBL_BOARD(bno, title, content, writer)
	values(seq_board.nextval, #{title}, #{content}, #{writer})
</insert>


BoardMapperTests.java 클래스에 아래 추가 후 실행
@Test
public void testInsert() {
	log.info("---------------------");
	BoardVO vo = new BoardVO();
	vo.setTitle("java3");
	vo.setContent("내용3...");
	vo.setWriter("남궁성3");
	log.info("insert : " + mapper.insert(vo));
	log.info("---------------------");
}

**31. InsertSelectKey / BoardMapper.java 인터페이스에 아래 추가
public int insertSelectKey(BoardVO vo);

BoardMapper.xml 에 아래 추가
<insert id="insertSelectKey">
  	<selectKey keyProperty="bno" order="BEFORE" resultType="long">
  		select seq_board.nextval from dual
  	</selectKey>
  
  	insert into TBL_BOARD(bno, title, content, writer)
	values(#{bno}, #{title}, #{content}, #{writer})
</insert>


BoardMapperTests.java 클래스에 아래 추가 후 실행
@Test
public void testInsertSelectKey() {
	log.info("---------------------");
	BoardVO vo = new BoardVO();
	vo.setBno(4L);
	vo.setTitle("java4");
	vo.setContent("내용4...");
	vo.setWriter("남궁성4");
	log.info("insert : " + mapper.insertSelectKey(vo));
	log.info(vo);
	log.info("---------------------");
}

*********************************

**31. src/main/java 에 org.zerock.service 패키지 생성 후 BoardService.java 인터페이스 작성
public interface BoardService {
	
	public void register(BoardVO vo);
	public BoardVO get(Long bno);
	public int modify(BoardVO vo);
	public int remove(Long bno);
	public List<BoardVO> getList();

}

**32. org.zerock.service 패키지에 BoardServiceImpl.java 클래스 작성
@Service
@Log4j
@AllArgsConstructor
public class BoardServiceImpl implements BoardService {
	
	private BoardMapper mapper;
	
	@Override
	public void register(BoardVO vo) {
		log.info("register ---------- ");
		mapper.insert(vo);
//		mapper.insertSelectKey(vo);
	}

	@Override
	public BoardVO get(Long bno) {
		return mapper.read(bno);
	}

	@Override
	public int modify(BoardVO vo) {
		return mapper.update(vo);
	}

	@Override
	public int remove(Long bno) {
		return mapper.delete(bno);
	}

	@Override
	public List<BoardVO> getList() {
		return mapper.getList();
	}

}

**33. root-context.xml 에 아래 추가
<context:component-scan base-package="org.zerock.service"></context:component-scan>

**34. src/test/java 에 org.zerock.service 패키지 생성 후 BoardServiceTests.java 작성
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Log4j
public class BoardServiceTests {
	
	@Autowired
	private BoardService service;

	@Test
	public void testRegister() {
		BoardVO vo = new BoardVO();
		vo.setTitle("삼국지");
		vo.setContent("영웅호걸전");
		vo.setWriter("작자미상");
		
		service.register(vo);
		log.info("생성된 게시물 번호 : " + vo.getBno());
	}
	
	@Test
	public void testGet() {
		service.get(2L);
	}
	
	@Test
	public void testDelete() {
//		service.remove(1L);
		log.info("삭제된 개수 : " + service.remove(1L));
	}
	
	@Test
	public void testGetList() {
		service.getList();
	}
	
	@Test
	public void testModify() {
		BoardVO vo = new BoardVO();
		vo.setBno(2L);
		vo.setTitle("삼국지2");
		vo.setContent("영웅호걸전2");
		vo.setWriter("작자미상2");
		service.modify(vo);
	}
	
}


**35. org.zerock.controller 패키지에 BoardController.java 클래스 작성
@Controller
@Log4j
@RequestMapping("/board/*")
@AllArgsConstructor
public class BoardController {

	private BoardService service;
	
	@GetMapping("/list")
	public void list(Model model) {
		log.info("list ---------------- ");
		model.addAttribute("list", service.getList());
	}
	
}

후 서버 실행하고 주소창에 http://localhost:8080/board/list 찍으면 콘솔에 로그가 찍힌다.


**36. views 폴더에 board 폴더 생성 후 list.jsp 작성
<c:forEach items="${list}" var="board">
	<h3>${board}</h3>
</c:forEach>


******************** 0715
**37. sql 문에 아래 추가 / 댓글 관련


create table tbl_reply(
    rno number(10,0),
    bno NUMBER(10,0) not null,
    reply varchar2(1000) not null,
    replyer varchar2(50) not null,
    replyDate date default sysdate,
    updateDate date default sysdate
)

create SEQUENCE seq_reply;

alter table tbl_reply add CONSTRAINT pk_reply PRIMARY key (rno);

alter table tbl_reply add CONSTRAINT fk_reply_board
foreign key (bno) references tbl_board(bno);

**38. src/test/java 안 org.zerock.service 패키지에 BoardControllerTests.java 클래스 작성
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"file:src/main/webapp/WEB-INF/spring/root-context.xml",
		"file:src/main/webapp/WEB-INF/spring/appServlet/servlet-context.xml"})
@WebAppConfiguration
@Log4j
public class BoardControllerTests {
	
	@Autowired
	private WebApplicationContext ctx;
	
	private MockMvc mockMvc;
	
	@Before
	public void setup() {
		this.mockMvc = MockMvcBuilders.webAppContextSetup(ctx).build();
	}
}

**39. BoardController.java 클래스에 아래 추가 / register
@PostMapping("/register")
	public String register(BoardVO vo, RedirectAttributes rttr) {
		log.info("register : " + vo);
		service.register(vo);
		rttr.addFlashAttribute("result", vo.getBno());
		return "redirect:/board/list";
	} 
	
**40. src/test/java의 BoardControllerTests.java 클래스에 아래 추가
@Test
	public void testRegister() throws Exception {
		String resultPage = 
				mockMvc.perform(MockMvcRequestBuilders.post("/board/register")
				.param("title","금요일")
				.param("content","주말이네")
				.param("writer","한 잔")
				)
				.andReturn()
				.getModelAndView()
				.getViewName();
		log.info(resultPage);
	}
	
**41. BoardController.java 클래스에 아래 추가 / get
@GetMapping("/get")
	public void get(Long bno ,Model model) {
		log.info("get ---------------- ");
		model.addAttribute("board", service.get(bno));
	}

**42. src/test/java의 BoardControllerTests.java 클래스에 아래 추가
@Test
	public void testGet() throws Exception {
		log.info(
				mockMvc.perform(MockMvcRequestBuilders.get("/board/get")
				.param("bno", "3")		
				)
				.andReturn()
				.getModelAndView()
				.getModelMap()
				);
	}



**43. BoardController.java 클래스에 아래 추가 / remove
@PostMapping("/remove")
	public String remove(Long bno, RedirectAttributes rttr) {
		if(service.remove(bno) == 1) {
			rttr.addFlashAttribute("result", "success");
		}
		return "redirect:/board/list";
	}


**44. src/test/java의 BoardControllerTests.java 클래스에 아래 추가
@Test
	public void testRemove() throws Exception {
		String resultPage = 
				mockMvc.perform(MockMvcRequestBuilders.post("/board/remove")
				.param("bno","3")
				)
				.andReturn()
				.getModelAndView()
				.getViewName();
		log.info(resultPage);
	}
	
	
**45. BoardController.java 클래스에 아래 추가 / modify
@PostMapping("/modify")
	public String modify(BoardVO vo, RedirectAttributes rttr) {
		if(service.modify(vo) == 1) {
			rttr.addFlashAttribute("result", "success");
		}
		return "redirect:/board/list";
	}



**46. src/test/java의 BoardControllerTests.java 클래스에 아래 추가
@Test
	public void testModify() throws Exception {
		String resultPage = 
				mockMvc.perform(MockMvcRequestBuilders.post("/board/modify")
				.param("bno", "2")
				.param("title","삼국지")
				.param("content","영웅호걸전")
				.param("writer","김소진")
				)
				.andReturn()
				.getModelAndView()
				.getViewName();
		log.info(resultPage);
	}

**47. 선생님이 주신 파일 startbootstrap-sb-admin-2-gh-pages의 table.html을 복사하여
list.jsp에 복붙

**48. webapp 폴더 아래에 resources 폴더를 만들고 startbootstrap-sb-admin-2-gh-pages의 모든 폴더 복붙.

**49. list.jsp의 경로 설정 ../  --> /resources/로 replace all

**50. views 폴더에 includes 폴더 만들고 header, footer.jsp 생성

**51. list.jsp의 <div id="page-wrapper"> 부분을 포함하여 위로 전부 ctrl+x 후 header.jsp에 복붙 - 이후 list.jsp에 <%@include file="../includes/header.jsp" %> 추가
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
이 부분은 남겨야함.

**52. list.jsp의 <div class="row">
             <div class="col-lg-6"> 부분을 포함하여 아래로 전부 ctrl+x 후 footer.jsp에 복붙 - 이후 list.jsp에 <%@include file="../includes/footer.jsp" %> 추가
footer에는 header와는 다르게
<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%> 이게 남음.

**53. footer.jsp에 <!-- jQuery -->
    <script src="/resources/vendor/jquery/jquery.min.js"></script> 삭제하고
    jquery-cdn에서 <script
  src="https://code.jquery.com/jquery-3.6.0.min.js"
  integrity="sha256-/xUj+3OJU5yExlq6GSYGSHk7tPXikynS7ogEvDej/m4="
  crossorigin="anonymous"></script> 를 header.jsp 맨 아래에 복붙.
  
  
**54. footer.jsp의 <!-- Page-Level Demo Scripts - Tables - Use for reference --> 부분을 아래로 교체
<script>
  $(document).ready(function() {
    $('#dataTables-example').DataTable({
      responsive: true
    });
    $(".sidebar-nav")
      .attr("class","sidebar-nav navbar-collapse collapse")
      .attr("aria-expanded",'false')
      .attr("style","height:1px");
  });
</script>
    

**55. list.jsp의 아래 부분 삭제
<div class="well">
                                <h4>DataTables Usage Information</h4>
                                <p>DataTables is a very flexible, advanced tables plugin for jQuery. In SB Admin, we are using a specialized version of DataTables built for Bootstrap 3. We have also customized the table headings to use Font Awesome icons in place of images. For complete documentation on DataTables, visit their website at <a target="_blank" href="https://datatables.net/">https://datatables.net/</a>.</p>
                                <a class="btn btn-default btn-lg btn-block" target="_blank" href="https://datatables.net/">View DataTables Documentation</a>
                            </div>

**56. footer의 html 구조 코드만 전부 삭제 혹은 아래만 남기거나
			<!-- /#page-wrapper -->

        </div>
        <!-- /#page-wrapper -->

    </div>
    <!-- /#wrapper -->



**57. list.jsp를 아래 정도로 줄이고 수정함
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<%@include file="../includes/header.jsp" %>

            <div class="row">
                <div class="col-lg-12">
                    <h1 class="page-header">Tables</h1>
                </div>
                <!-- /.col-lg-12 -->
            </div>
            <!-- /.row -->
            <div class="row">
                <div class="col-lg-12">
                    <div class="panel panel-default">
                        <div class="panel-heading">
                            Board List Page
                            <button id="regBtn" type="button" class="btn btn-xs pull-right">
                            	Register New Board
                            </button>
                        </div>
                        <!-- /.panel-heading -->
                        <div class="panel-body">
                            <table width="100%" class="table table-striped table-bordered table-hover">
                                <thead>
                                    <tr>
                                        <th>#번호</th>
                                        <th>제목</th>
                                        <th>작성자</th>
                                        <th>작성일</th>
                                        <th>변경일</th>
                                    </tr>
                                </thead>
                                <c:forEach items="${list}" var="board">
                                    <tr class="odd gradeX">
                                        <td><c:out value="${board.bno}" /></td>
                                        <td><c:out value="${board.title}" /></td>
                                        <td><c:out value="${board.writer}" /></td>
                                        <td><fmt:formatDate pattern="yyy-MM-dd" value="${board.regdate}"/></td>
	        							<td><fmt:formatDate pattern="yyy-MM-dd" value="${board.updatedate}"/></td>
                                    </tr>
                                </c:forEach>
                            </table>
                            <!-- /.table-responsive -->
                            
                        </div>
                        <!-- /.panel-body -->
                    </div>
                    <!-- /.panel -->
                </div>
                <!-- /.col-lg-12 -->
            </div>
            <!-- /.row -->

<%@ include file="../includes/footer.jsp" %>

**58. BoardController.java 클래스에 아래 추가
@GetMapping("/register")
	public void register() {
		
	} 

**59. register.jsp에 아래 복붙
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<%@include file="../includes/header.jsp" %>

            <div class="row">
                <div class="col-lg-12">
                    <h1 class="page-header">Tables</h1>
                </div>
                <!-- /.col-lg-12 -->
            </div>
            <!-- /.row -->
            <div class="row">
                <div class="col-lg-12">
                    <div class="panel panel-default">
                        <div class="panel-heading">
                            Board Register
                        </div>
                        <!-- /.panel-heading -->
                        <div class="panel-body">
                        	<form action="/board/register" method="post" role="form">
                        	
	                                <div class="form-group">
	                                	<label>Title</label><input name="title" class="form-control">
	                                </div>
	                                <div class="form-group">
	                                	<label>Text area</label><textarea rows="3" name="content" class="form-control"></textarea>
	                                </div>
	                                <div class="form-group">
	                                	<label>Writer</label><input name="writer" class="form-control">
	                                </div>
	                                
	                                <button type="submit" class="btn btn-default">Submit</button>
	                                <button type="reset" class="btn btn-default">Reset Button</button>
	                                
                            </form>
                        </div>
                        <!-- /.panel-body -->
                    </div>
                    <!-- /.panel -->
                </div>
                <!-- /.col-lg-12 -->
            </div>
            <!-- /.row -->

<%@ include file="../includes/footer.jsp" %>

http://localhost:8080/board/register 주소창 검색하면 등록 폼 나옴
등록되지만 콘솔창에 에러는 발생한다. 한글 처리도 안됨


**********
0718 - 수업

**60. web.xml에 아래 코드 추가 // 한글 작업
<filter>
	<filter-name>encoding</filter-name>
	<filter-class>org.springframework.web.filter.CharacterEncodingFilter</filter-class>
	<init-param>
		<param-name>encoding</param-name>
		<param-value>UTF-8</param-value>
	</init-param>
</filter>

<filter-mapping>
	<filter-name>encoding</filter-name>
	<servlet-name>appServlet</servlet-name>
</filter-mapping>

**61. list.jsp 에 아래 추가
<script>
	// 새로고침해서 등록이 계속 되는것을 방지
	$(document).ready(function() {

		var result = '<c:out value="${result}"/>';
		console.log("result" + result);
		
		checkModal(result);
		
		function checkModal(result){
			if(result === ''){
				return ;
			}
			
			if(parseInt(result) > 0){
				$(".modal-body").html("게시글" + parseInt(result) + "번이 등록됐습니다.");
			}
			
			$("#myModal").modal("show");
		}
		
		$("#regBtn").on("click", function(){
			self.location = "/board/register";
		});
	});
</script>

**62. list.jsp에 <!-- /.table-responsive --> 바로 아래에 아래 추가
<!-- Modal 창 추가 -->
				<div id="myModal" class="modal" tabindex="-1" role="dialog">
					<div class="modal-dialog" role="document">
						<div class="modal-content">
							<div class="modal-header">
								<h5 class="modal-title">Modal title</h5>
								<button type="button" class="close" data-dismiss="modal"
									aria-label="Close" >
									<span aria-hidden="true">&times;</span>
								</button>
							</div>
							<div class="modal-body">
								처리가 완료됐습니다.
							</div>
							<div class="modal-footer">
								<button type="button" class="btn btn-primary">Save
									changes</button>
								<button type="button" class="btn btn-secondary"
									data-dismiss="modal"
								>Close</button>
							</div>
						</div>
					</div>
				</div>
				<!-- Modal 창 닫기 -->


**63. get.jsp 작성
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"
%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<%@include file="../includes/header.jsp" %>
            <div class="row">
                <div class="col-lg-12">
                    <h1 class="page-header">Tables</h1>
                </div>
                <!-- /.col-lg-12 -->
            </div>
            <!-- /.row -->
            <div class="row">
                <div class="col-lg-12">
                    <div class="panel panel-default">
                        <div class="panel-heading">
                            Board Read Page
                        </div>
                        <!-- /.panel-heading -->
                        <div class="panel-body">
							<div class="form-group">
								<label>Bno</label>
								<input name="bno" class="form-control" readonly="readonly" value='<c:out value="${board.bno}"/>'><br>
							</div>
							<div class="form-group">
								<label>Title</label>
								<input name="title" class="form-control" readonly="readonly" value='<c:out value="${board.title}"/>'><br>
							</div>
							<div class="form-group">
								<label>Text area</label>
								<textarea class="form-control" rows="3" name="content" readonly="readonly">
								<c:out value="${board.content}" /></textarea><br>
							</div>
							<div class="form-group">
								<label>Writer</label>
								<input name="writer" class="form-control" readonly="readonly" value='<c:out value="${board.writer}"/>'><br>
							</div>
							
							<button data-oper="modify" class="btn btn-default"
							onclick="location.href='/board/modify?bno=<c:out value="${board.bno}"/>'">Modify</button>
							<button data-oper="list" class="btn btn-default"
							onclick="location.href='/board/list'">List</button>
							
                        </div>
                        <!-- /.panel-body -->
                    </div>
                    <!-- /.panel -->
                </div>
                <!-- /.col-lg-12 -->
            </div>
            <!-- /.row -->
      <%@include file="../includes/footer.jsp" %>



**64. list.jsp의 script 안에 아래 추가 및 수정
history.replaceState({},null,null);
		
function checkModal(result){
	if(result === ''||history.state){
		return ;
	}
	
	
	
**65. modify.jsp 작성  // 수정 페이지 밑 버튼은 아직 수정해야함.
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"
%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<%@include file="../includes/header.jsp" %>
            <div class="row">
                <div class="col-lg-12">
                    <h1 class="page-header">Tables</h1>
                </div>
                <!-- /.col-lg-12 -->
            </div>
            <!-- /.row -->
            <div class="row">
                <div class="col-lg-12">
                    <div class="panel panel-default">
                        <div class="panel-heading">
                            Board Modify Page
                        </div>
                        <!-- /.panel-heading -->
                        <div class="panel-body">
	                        <form action="/board/modify" method="post" role="form">
								<div class="form-group">
									<label>Bno</label>
									<input name="bno" class="form-control" readonly="readonly" value='<c:out value="${board.bno}"/>'><br>
								</div>
								<div class="form-group">
									<label>Title</label>
									<input name="title" class="form-control" value='<c:out value="${board.title}"/>'><br>
								</div>
								<div class="form-group">
									<label>Text area</label>
									<textarea class="form-control" rows="3" name="content">
									<c:out value="${board.content}" /></textarea><br>
								</div>
								<div class="form-group">
									<label>Writer</label>
									<input name="writer" class="form-control" readonly="readonly" value='<c:out value="${board.writer}"/>'><br>
								</div>
								<div class="form-group">
									<label>RegDate</label>
									<input name="regdate" class="form-control" readonly="readonly" value='<fmt:formatDate pattern="yyy-MM-dd" value="${board.regdate}"/>'><br>
								</div>
								<div class="form-group">
									<label>Updatedate</label>
									<input name="updatedate" class="form-control" readonly="readonly" value='<fmt:formatDate pattern="yyy-MM-dd" value="${board.updatedate}"/>'><br>
								</div>
								
								<button data-oper="modify" class="btn btn-default"
								onclick="location.href='/board/modify?bno=<c:out value="${board.bno}"/>'">Modify finish</button>
								<button data-oper="list" class="btn btn-default"
								onclick="location.href='/board/list'">List</button>
							</form>	
                        </div>
                        <!-- /.panel-body -->
                    </div>
                    <!-- /.panel -->
                </div>
                <!-- /.col-lg-12 -->
            </div>
            <!-- /.row -->
      <%@include file="../includes/footer.jsp" %>



**66. modify.jsp의 버튼 부분을 아래처럼 수정
<button type="submit" data-oper='modify' class="btn btn-default">Modify</button>
<button type="submit" data-oper='remove' class="btn btn-danger">Remove</button>
<button type="submit" data-oper='list' class="btn btn-info">List</button>	

그리고 아래에 script 추가

$(document).ready(function(){
           		
	var formObj = $("form");
	
	$('button').on("click", function(e){
		e.preventDefault();
		
		var operation = $(this).data('oper');
		console.log(operation);
		
		if(operation === 'remove'){
			formObj.attr("action","/board/remove");
		}else if(operation === 'list'){
			self.location = "/board/list";
			return;
		}
		
		formObj.submit();
		
	});           		
});
</script>


**67. get.jsp에 아래처럼 추가 및 수정
<script>
	$(document).ready(function(){
		
		var operForm = $("#operForm");
		
		$("button[data-oper='modify']").on("click",function(){
			operForm.attr("action", "/board/modify").submit();
		});
		
		$("button[data-oper='list']").on("click",function(){
			operForm.find("#bno").remove();
			operForm.attr("action", "/board/list").submit();
		});
		
	});
</script>

<%-- <button data-oper="modify" class="btn btn-default"
							onclick="location.href='/board/modify?bno=<c:out value="${board.bno}"/>'">Modify</button>
							<button data-oper="list" class="btn btn-default"
							onclick="location.href='/board/list'">List</button> --%> 
							
							<button data-oper="modify" class="btn btn-default">Modify</button>
							<button data-oper="list" class="btn btn-default">List</button>
							
							<form id='operForm' action="/board/modify" method="get">
								<input type="hidden" id="bno" name="bno" value='<c:out value="${board.bno}" />'>
							</form>
							

**68. modify.jsp에 아래처럼 수정
<script type="text/javascript">
            
           	$(document).ready(function(){
           		
				var formObj = $("form");
            	
            	$('button').on("click", function(e){
					e.preventDefault();
					
					var operation = $(this).data('oper');
					console.log(operation);
					
					if(operation === 'remove'){
						formObj.attr("action","/board/remove");
					}else if(operation === 'list'){
						//self.location = "/board/list";
						formObj.attr("action", "/board/list").attr("method","get");
						formObj.empty();
					}
					formObj.submit();
            	});           		
           	});
            </script>

**69. sql에 아래 추가 / 항목 늘리기
insert into TBL_BOARD(bno,title,content,writer)
    (select seq_board.nextval, title, content, writer from TBL_BOARD);


**70. 두 문장의 sql문을 실행하는 속도를 비교. 두번째 index 방식이 훨씬 빠르다.

select * from TBL_BOARD order by bno+1 desc;

--실행계획, 인덱스+힌트
select /*+ index_desc(tbl_board pk_board) */ *
from tbl_board where bno > 0;


**71. ********************** 매우 중요한 sql문

select /*+ index_desc(tbl_board pk_board) */ rownum rs, bno, title, writer
from tbl_board where bno > 0;

*************************************

select /*+ index_desc(tbl_board pk_board) */ rownum, bno, title, writer
from tbl_board 
where rownum <= 10;

************************************* 페이징 때 갯수 제한하기 위한

select
    bno, title, writer
from(
    select /*+ index_desc(tbl_board pk_board) */ rownum rn, bno, title, writer
    from tbl_board 
    where rownum <= 20
)
where rn > 10;

**72. org.zerock.domain 에 Criteria.java 클래스 작성

@Data
@ToString
public class Criteria {
	
	private int pageNum;
	private int amount;
	
	public Criteria() {
		this(1,10);
	}
	
	public Criteria(int pageNum, int amount) {
		this.pageNum = pageNum;
		this.amount = amount;
	}
}


**73. org.zerock.mapper 패키지의 BoardMapper.java 안에 아래 추가
public List<BoardVO> getListWithPagging(Criteria cri);

**74. BoardMapper.xml 에 아래 추가
<select id="getListWithPagging"   resultType="org.zerock.domain.BoardVO">
      <![CDATA[
      select bno, title, content, writer, regdate, updatedate
      from (
         select /*+ index_desc(tbl_board pk_board) */
         rownum rn, bno, title,content, writer,regdate, updatedate
         from tbl_board
         where ROWNUM <= 20
      )
      where rn >10
      ]]>
   </select>
   
**75. BoardMapperTests.java 클래스에 아래 추가해서 테스트 실행
@Test
	public void testPagging() {
		Criteria cri = new Criteria();
		List<BoardVO> list = mapper.getListWithPagging(cri);
		log.info(list);
	}
	
	
**76. ***********중요 sql문 xml에 수정

<select id="getListWithPagging"   resultType="org.zerock.domain.BoardVO">
      <![CDATA[
      select bno, title, content, writer, regdate, updatedate
      from (
         select /*+ index_desc(tbl_board pk_board) */
         rownum rn, bno, title,content, writer,regdate, updatedate
         from tbl_board
         where ROWNUM <= #{pageNum}*#{amount}
      )
      where rn > (#{pageNum}-1)*#{amount}
      ]]>
   </select>
   
   
**77. BoardMapperTests.java 클래스에 아래 추가해서 테스트 실행 / 5쪽에 10개
@Test
	public void testPagging() {
		Criteria cri = new Criteria();
		cri.setPageNum(5);
		cri.setAmount(10);
		List<BoardVO> list = mapper.getListWithPagging(cri);
		log.info(list);
	}



*******************************************************
0719 - 수업

**78. BoardService.java 클래스를 다음과 같이 수정
public List<BoardVO> getList(Criteria cri);


**79. BoardServiceImpl.java 클래스도 다음과 같이 수정
@Override
public List<BoardVO> getList(Criteria cri) {
  return mapper.getListWithPagging(cri);
}



**80. src/test/java의 BoardServiceTests.java 클래스를 다음과 같이 수정
@Test
public void testGetList() {
// service.getList();
   service.getList(new Criteria(2,10));
   log.info("--------------------------");
}

여기까지 했을 때 테스트 실행을 하면 콘솔에 나타나긴 한다. 
이 후 화면에 뿌리는 작업 진행.

**81. BoardController.java 클래스를 다음과 같이 수정
@GetMapping("/list")
public void list(Criteria cri, Model model) {
	log.info("list------------------");
	model.addAttribute("list", service.getList(cri));
}

**82. src/test/java의 BoardControllerTests.java 클래스에 아래 추가
@Test
public void testListPaging() throws Exception {
	log.info(
			mockMvc.perform(MockMvcRequestBuilders.get("/board/list")
			.param("pageNum", "5")
			.param("amount", "30"))
			.andReturn()
			.getModelAndView()
			.getModelMap()
			);
}

실행하면 30개의 데이터가 나타난다.

**83. org.zerock.domain에 PageDTO.java 클래스 작성
@Getter
@ToString
public class PageDTO {
	
	private int startPage;
	private int endPage;
	private boolean prev, next;
	private int total;
	private Criteria cri;
	
	public PageDTO(Criteria cri, int total) {
		this.cri = cri;
		this.total = total;
		
		this.endPage = (int)(Math.ceil(cri.getPageNum()/10.0)) * 10;
		this.startPage = endPage-9;
		
		
		int readEnd = (int)(Math.ceil(total*1.0)/cri.getAmount());
		
		if(endPage > readEnd) {
			endPage = readEnd;
		}
		
		this.prev = this.startPage > 1;
		this.next = this.endPage < readEnd;
		
	}
	
}

**84. src/test/java의 BoardMapperTests.java 클래스에 아래 테스트
@Test
public void testPageDTO() {
	Criteria cri = new Criteria();
	cri.setPageNum(15);
	cri.setAmount(10);
	PageDTO pageDTO = new PageDTO(cri,315);
	log.info(pageDTO);
}

**85. BoardController.java에 아래처럼 수정
@GetMapping("/list")
	public void list(Criteria cri, Model model) {
		log.info("list------------------");
		model.addAttribute("list", service.getList(cri));
		model.addAttribute("pageMaker", new PageDTO(cri, 315));
	}
	
**86. list.jsp에 아래 추가 </table> 아래에
<!-- 페이지 처리 Start -->
<div class="pull-right">
  <ul class="pagination">
  
  	<c:if test="${pageMaker.prev}">
	    <li class="paginate_button previous"><a href="${pageMaker.startPage-1}">Previous</a></li>				  		
  	</c:if>
  	
  	<c:forEach var="num" begin="${pageMaker.startPage}" end="${pageMaker.endPage}">
    	<li class="page-button ${pageMaker.cri.pageNum == num ? "active":""}">
    	<a href="${num}">${num}</a></li>
	</c:forEach>
					    
    <c:if test="${pageMaker.next}">
	    <li class="paginate_button next"><a href="${pageMaker.endPage+1}">Next</a></li>				  		
  	</c:if>
  </ul>
</div>
<!-- //페이지 처리 End -->

이 시점에 실행하면 크롬 화면에 에러는 나지만 주소창에 페이징 버튼을 눌렀을때 값이 넘어가는 것이 나타난다.


**87. <!-- //페이지 처리 End --> 아래에 다음 추가
<form id="actionForm" action="/board/list" method="get">
	<input type="hidden" name="pageNum" value="${pageMaker.cri.pageNum}">
	<input type="hidden" name="amount" value="${pageMaker.cri.amount}">
</form>

**88. script에































