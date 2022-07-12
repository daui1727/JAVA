0711 - 수업

*******************

1. pom.xml 1.8/5.2.7 등 설정 변경.

2. lombok, ojdbc8, HikariCP 등 아래처럼 등록

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



--추가--
<dependency>
	<groupId>org.springframework</groupId>
	<artifactId>spring-test</artifactId>
	<version>${org.springframework-version}</version>
</dependency>

--수정--
<dependency>
	<groupId>log4j</groupId>
	<artifactId>log4j</artifactId>
	<version>1.2.17</version>
</dependency>

<dependency>
	<groupId>junit</groupId>
	<artifactId>junit</artifactId>
	<version>4.12</version>
	<scope>test</scope>
</dependency>

3. org.zerock.persistence 패키지 작성 - JDBCTests 클래스 작성 
- Junit 창에서 testConnection 메서드만 실행했을때 성공 실패 여부를 알 수 있다.

import java.sql.Connection;
import java.sql.DriverManager;
import org.junit.Test;
import lombok.extern.log4j.Log4j;

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
	try(Connection conn = DriverManager.getConnection(
			"jdbc:oracle:thin:@localhost:1521:xe",
			"book",
			"1234" )){
		log.info("---------------");
		log.info("connection : " + conn);
	}catch(Exception e) {
		e.printStackTrace();
	}
 }
}

4. pom.xml에 커넥션 풀 추가 HikariCP

<!-- https://mvnrepository.com/artifact/com.zaxxer/HikariCP -->
<dependency>
    <groupId>com.zaxxer</groupId>
    <artifactId>HikariCP</artifactId>
    <version>5.0.1</version>
</dependency>


5. root-context.xml에 아래와 같이 추가 후 메이븐 업데이트

<bean id="hikariConfig" class="com.zaxxer.hikari.HikariConfig">
	<property name="driverClassName" value="oracle.jdbc.driver.OracleDriver"></property>
	<property name="jdbcUrl" value="jdbc:oracle:thin:@localhost:1521:xe"></property>
	<property name="username" value="book"></property>
	<property name="password" value="1234"></property>
</bean>

<bean id="dataSource" class="com.zaxxer.hikari.HikariDataSource" destroy-method="close">
	<constructor-arg ref="hikariConfig"></constructor-arg>
</bean>

6. org.zerock.persistence에 DataSourceTests클래스 생성

import java.sql.Connection;

import javax.sql.DataSource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Log4j
public class DataSourceTests {
	
@Autowired
private DataSource dataSource;

@Test
public void testConnection() {
	try(Connection conn = dataSource.getConnection()) {
		log.info(conn);
	}catch(Exception e) {
		e.printStackTrace();
	}
 }
}

7. pom.xml에 mybatis, mybatis-spring 추가
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

--추가--

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


**8. root-context.xml 에 아래 추가
<bean id="sqlSessionFactory" class="org.mybatis.spring.SqlSessionFactoryBean">
	<property name="dataSource" ref="dataSource"></property>
</bean>

**9. org.zerock.mapper 패키지 만들고 TimeMapper 인터페이스 생성

@Select("select sysdate from dual")
public String getTime();

**10. root-context.xml에 mybatis-spring 체크.

**11. root-context.xml에 아래 추가
<mybatis-spring:scan base-package="org.zerock.mapper"/>

**12. org.zerock.persistence에 TimeMapperTests 클래스 생성
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.zerock.mapper.TimeMapper;

import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Log4j
public class TimeMapperTests {
	
@Autowired
private TimeMapper timeMapper;

@Test
public void testGetTime() {
	log.info("------------------------------------");
	log.info("info1" + timeMapper.getClass().getName());
	log.info("info2" + timeMapper.getTime());
}

}

**13. src/main/resources에 org/zerock/mapper 폴더들을 만들고 TimeMapper.xml 생성
<?xml version="1.0" encoding="UTF-8"?>
<!DOCTYPE mapper
  PUBLIC "-//mybatis.org//DTD Mapper 3.0//EN"
  "http://mybatis.org/dtd/mybatis-3-mapper.dtd">
  
<mapper namespace="org.zerock.mapper.TimeMapper">
  
  <select id="getTime2" resultType="string">
  	select sysdate from dual
  </select>
  
</mapper>

TimeMapper.java와 TimeMapperTests.java에 getTime2를 만들어서 junit 테스트 해본다.

**14. pom.xml에 아래 추가
<!-- https://mvnrepository.com/artifact/org.bgee.log4jdbc-log4j2/log4jdbc-log4j2-jdbc4.1 -->
<dependency>
    <groupId>org.bgee.log4jdbc-log4j2</groupId>
    <artifactId>log4jdbc-log4j2-jdbc4.1</artifactId>
    <version>1.16</version>
</dependency>


**15. org.zerock.controller에 SampleController 클래스 생성
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.extern.log4j.Log4j;

@Controller
@RequestMapping("/sample/*")
@Log4j
public class SampleController {
	
@RequestMapping("")
public void basic() {
	log.info("basic--------------");
	
}
}

**16. sample.jsp 작성
실행 후 주소창에 /sample/ 작성하면 jsp 파일 화면이 뜬다.

**17. SampleController 클래스 변경
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import lombok.extern.log4j.Log4j;

@Controller
@RequestMapping("/sample/*")
@Log4j
public class SampleController {
	
@RequestMapping(value="sample", method = RequestMethod.GET)  // "" 부분에 쓰는 글자를 리턴하는. home을 찾아가는 부분처럼 동작한다.
public String basic() {
	log.info("basic--------------");
	return "sample";
}

@RequestMapping(value="sample", method = RequestMethod.POST)
public String basic2() {
	log.info("basic2--------------");
	return "sample";
}

@GetMapping("/basicOnlyGet")
public void basicGet2() {
	log.info("basicGet2()--------------");
}
}

실행 후 주소창에 /sample/sample 작성하면 jsp 파일 화면이 뜬다.

**18. src/main/java에 org.zerock.domain 패키지 작성 SampleDTO 클래스 작성

@Data
public class SampleDTO {
	
private String name;
private int age;
}

**19. **17. SampleController 클래스에 아래 추가 / ex00.jsp 작성
@GetMapping("/ex00")
public String ex00(SampleDTO dto) {
	log.info("dto -------------- : " + dto);
	return "ex00";
}

http://localhost:8181/sample/ex00?name=AAA&age=20 입력하면 jsp 화면과 콘솔창에 나타난다.

***
@GetMapping("/ex00")
public String ex00(SampleDTO dto, Model model) {
	log.info("dto -------------- : " + dto);
	model.addAttribute("model",model);
	return "ex00";
}

jsp엔 <h3>${model}</h3> 추가하는 식으로 나타낼 수도 있다.

***

@GetMapping("/ex02")
public String ex02(SampleDTO dto, @ModelAttribute("page")int page) {
	log.info(dto);
	log.info(page);
	return "ex02";
}

ex02.jsp 작성. 
${SampleDTO} 
${page}

http://localhost:8181/sample/ex02?name=AAA&age=30&page=10

***
@GetMapping("/ex03")
public String ex03(@ModelAttribute("SD") SampleDTO dto, @ModelAttribute("page")int page) {
	log.info(dto);
	log.info(page);
	return "ex03";
}

<h1>ex03</h1>
${SD.name}<br>
${SD.age}<br>
${page}<br>

http://localhost:8181/sample/ex03?name=AAA&age=30&page=10


**20. pom.xml에 추가 . 서버 다운시키고 넣자.
<!-- https://mvnrepository.com/artifact/com.fasterxml.jackson.core/jackson-databind -->
<dependency>
    <groupId>com.fasterxml.jackson.core</groupId>
    <artifactId>jackson-databind</artifactId>
    <version>2.13.3</version>
</dependency>

@GetMapping("/ex04")
public @ResponseBody SampleDTO ex04() {
	log.info("ex04 -------------- ");
	SampleDTO dto = new SampleDTO();
	dto.setName("홍길동");
	dto.setAge(50);
	return dto;
}

**21. sql 작성
create SEQUENCE seq_board;

create table tbl_board(
    bno number(10,0),
    title varchar2(200) not null,
    content varchar2(2000) not null,
    writer varchar2(50) not null,
    regdate date default sysdate,
    updatedate date default sysdate
);

alter table tbl_board add CONSTRAINT pk_board
PRIMARY key(bno);

desc tbl_board;

insert into tbl_board(bno,title,content,writer)
values(seq_board.nextval, '홍길동전', '도둑이야기', '허균');

commit;

select * from tbl_board;


**22. pom.xml에 복붙 후 원래 있던것 지우기
<!-- https://mvnrepository.com/artifact/javax.servlet/javax.servlet-api -->
<dependency>
    <groupId>javax.servlet</groupId>
    <artifactId>javax.servlet-api</artifactId>
    <version>4.0.1</version>
    <scope>provided</scope>
</dependency>


**23. org.zerock.domain 패키지에 BoardVO 클래스 작성
import java.util.Date;
import lombok.Data;

/* 오라클 BoardVO와 연동(tbl_board)
 BNO        NOT NULL NUMBER(10)     
TITLE      NOT NULL VARCHAR2(200)  
CONTENT    NOT NULL VARCHAR2(2000) 
WRITER     NOT NULL VARCHAR2(50)   
REGDATE             DATE           
UPDATEDATE          DATE   
*/

@Data
public class BoardVO {
	
private Long bno;
private String title, content, writer;
private Date regdate, updatedate;

}

**24. org.zerock.mapper패키지에 BoardMapper 인터페이스 작성
import java.util.List;

import org.apache.ibatis.annotations.Select;
import org.zerock.domain.BoardVO;

public interface BoardMapper {
	
@Select("select * from tbl_board where bno > 0")
public List<BoardVO> getList();

}

**25. src/test/java에 org.zerock.mapper 패키지 생성 후 BoardMapperTests 클래스 생성











******************************
sql
******************************

create user book IDENTIFIED by 1234
default tablespace users
temporary tablespace temp;

grant connect, dba to book;

작성 후 

+ 버튼 눌러서 book 만들기

select dbms_xdb.gethttpport() from dual; -- 사용 포트번호 확인

exec dbms_xdb.sethttpport(9090); -- 포트번호 변경



********************************



0712 - 수업

select sysdate from dual

dual은 system에서 기본으로 만들어 놓은 테이블 sys 소유
select 만으로 데이터를 조회하고 싶을때 dual을 이용한거 처럼특별한 from에 담을 게 없을때 사용하는 용도

SELECT SYSDATE FROM DUAL;
SELECT SYSTIMESTAMP FROM DUAL

계산식을 출력해보고 싶을때도 사용이 가능합니다.
SELECT (10+10)/2 FROM DUAL;
테이블만들기전에 임시 데이터를 만들때도 사용합니다
SELECT * from  (    
	SELECT 'GoCoder' AS Name FROM dual 
	union all    
	SELECT 'Gocoder.Tistory.com' AS Blog FROM dual    
	union all    
	SELECT 'GoCoder.net' AS HomePage FROM dual
)



























