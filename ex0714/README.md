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





































