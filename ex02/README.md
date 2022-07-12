0712 - 수업

ex00에서 이어짐 01은 다른거.
********************

<!-- Servlet -->
<dependency>
	<groupId>javax.servlet</groupId>
	<artifactId>javax.servlet-api</artifactId>
	<version>3.1.0</version>
	<scope>provided</scope>
</dependency>

SampleController 만드는 시점에 위로 수정.


다시 필기. 겹치는 부분 있음.

**1. src/main/java에 org.zerock.domain 패키지 생성 후 BoardVO 클래스 작성
/*
BNO NUMBER(10,0), 
TITLE VARCHAR2(200) NOT NULL, 
CONTENT VARCHAR2(2000) NOT NULL, 
WRITER VARCHAR2(50) NOT NULL, 
REGDATE DATE, 
UPDATEDATE DATE
 */
@Data
public class BoardVO {
	
private Long bno;
private String title, content, writer;
private Date regdate, updatedate;

}

**2. org.zerock.mapper 패키지에 BoardMapper 인터페이스 작성
import java.util.List;

import org.zerock.domain.BoardVO;

public interface BoardMapper {
	
public List<BoardVO> getList();

}


**3. src/main/resources 패키지 안 > > mapper 폴더 안에 BoardMapper.xml 작성
<?xml version="1.0" encoding="UTF-8" ?>
<!DOCTYPE mapper
  PUBLIC "-//mybatis.org//DTD Mapper 3.0//EN"
  "http://mybatis.org/dtd/mybatis-3-mapper.dtd">
  
<mapper namespace="org.zerock.mapper.BoardMapper">
  <select id="getList" resultType="org.zerock.domain.BoardVO">
  	select * from tbl_board where bno > 0
  </select>
</mapper>

**4. src/test/java에 org.zerock.mapper 패키지를 만들고 BoardMapperTests 클래스 작성
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.zerock.domain.BoardVO;

import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Log4j
public class BoardMapperTests {
	
@Autowired
private BoardMapper mapper;

@Test
public void testGetList() {
//		mapper.getList().forEach(board->log.info(board));
		for(BoardVO vo : mapper.getList()) {
			log.info(vo);
		}
	}

}


**5. org.zerock.mapper안 BoardMapper 클래스에 아래 추가
public void insert(BoardVO vo);

BoardMapper.xml에 아래 추가
<insert id="insert">
  	insert into tbl_board(bno,title,content,writer)
	values(seq_board.nextval, #{title}, #{content}, #{writer})
</insert>

src/test/java 안 org.zerock.mapper 안에 BoardMapperTests 에 아래 추가
@Test
public void testinsert() {
	BoardVO vo = new BoardVO();
	vo.setTitle("java의 정석");
	vo.setContent("자바 책.....");
	vo.setWriter("남궁성");
	mapper.insert(vo);
}

**6. org.zerock.mapper안 BoardMapper 클래스에 아래 추가
public void insertSelectKey(BoardVO vo);

BoardMapper.xml에 아래 추가
<insert id="insertSelectKey">
  	<selectKey keyProperty="bno" order="BEFORE" resultType="long">
  		select seq_board.nextval from dual
  	</selectKey>
  	
  	insert into tbl_board(bno,title,content,writer)
	values(#{bno}, #{title}, #{content}, #{writer})
</insert>

src/test/java 안 org.zerock.mapper 안에 BoardMapperTests 에 아래 추가
@Test
public void testSelectKey() {
	BoardVO vo = new BoardVO();
	vo.setTitle("Jsp");
	vo.setContent("JSP/servlet");
	vo.setWriter("성윤정");
	mapper.insertSelectKey(vo);
	log.info(vo);
}

**7. org.zerock.mapper안 BoardMapper 클래스에 아래 추가
public BoardVO read(Long bno);

BoardMapper.xml에 아래 추가
<select id="read" resultType="org.zerock.domain.BoardVO">
  	select * from tbl_board where bno = #{bno}
</select>

src/test/java 안 org.zerock.mapper 안에 BoardMapperTests 에 아래 추가
@Test
public void testRead() {
	BoardVO vo = mapper.read(8L);
	log.info(vo);
}



**8. org.zerock.mapper안 BoardMapper 클래스에 아래 추가
public void delete(Long bno);

BoardMapper.xml에 아래 추가
<!-- 데이터 삭제 -->
<delete id="delete">
  	delete from tbl_board where bno = #{bno}
</delete>

src/test/java 안 org.zerock.mapper 안에 BoardMapperTests 에 아래 추가
@Test
public void testDelete() {
	mapper.delete(8L);
	log.info("---------------------");
}

************----------------
public int delete(Long bno);

@Test
public void testdelete() {
   log.info("delete count : "+mapper.delete(9L));
}

로도 가능.


**9. org.zerock.mapper안 BoardMapper 클래스에 아래 추가
public int update(BoardVO vo);

BoardMapper.xml에 아래 추가
<!-- 데이터 수정 -->
  <update id="update">
  	update tbl_board set
  	title=#{title},
  	content=#{content},
  	writer=#{writer},
  	updatedate=sysdate
  	where bno = #{bno}
</update>

src/test/java 안 org.zerock.mapper 안에 BoardMapperTests 에 아래 추가
@Test
public void testUpdate() {
	BoardVO vo = new BoardVO();
	vo.setBno(3L);
	vo.setTitle("오라클");
	vo.setContent("오라클");
	vo.setWriter("오라클");
	log.info("update : " + mapper.update(vo));
}

**10. org.zerock.controller 안에 BoardController 작성




















































