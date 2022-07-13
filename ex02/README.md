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


**10. src/main/java안에 org.zerock.service 패키지 작성 후 BoardService 인터페이스 작성
import java.util.List;

import org.zerock.domain.BoardVO;

public interface BoardService {
	
	public void register(BoardVO vo);  // 등록
	public int modify(BoardVO vo); // 수정
	public int remove(Long bno);  // 삭제
	public BoardVO get(Long bno);  // 읽기
	public List<BoardVO> getList();  // 전체 읽기
	public void registerSelectKey(BoardVO vo);

}

**11. org.zerock.service 패키지 안에 BoardServiceImpl 클래스 작성
import java.util.List;

import org.springframework.stereotype.Service;
import org.zerock.domain.BoardVO;
import org.zerock.mapper.BoardMapper;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;

@Service
@Log4j
@AllArgsConstructor  // AutoWired를 쓰지 않아도 변수를 자동 주입해주는.
public class BoardServiceImpl implements BoardService{

private BoardMapper mapper;

@Override
public void register(BoardVO vo) {
	log.info("register ---------------------- ");
	
	mapper.insert(vo);
}

@Override
public void registerSelectKey(BoardVO vo) {
	log.info("register ---------------------- ");
	
	mapper.insertSelectKey(vo);
}

@Override
public int modify(BoardVO vo) {
	log.info("modify ---------------------- ");
	
	return mapper.update(vo);
}

@Override
public int remove(Long bno) {
	log.info("remove ---------------------- ");
	
	return mapper.delete(bno);
}

@Override
public BoardVO get(Long bno) {
	log.info("get ---------------------- ");
	
	return mapper.read(bno);
}

@Override
public List<BoardVO> getList() {
	log.info("getList ---------------------- ");
	
	return mapper.getList();
}
	
	

}

**12. src/test/java에 org.zerock.service 패키지 생성 후 BoardServiceImplTests 클래스 작성
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
public class BoardServiceImplTests {
	
@Autowired
private BoardService service;

@Test
public void testRegister() {
	BoardVO vo = new BoardVO();
	vo.setTitle("java의 정석2");
	vo.setContent("자바 책2.....");
	vo.setWriter("남궁성2");
	service.register(vo);
 }
}

**13. root-context.xml에 아래 추가
<context:component-scan base-package="org.zerock.service"></context:component-scan>



**14. org.zerock.controller패키지 안에 BoardController 클래스 작성

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.zerock.service.BoardService;

import lombok.extern.log4j.Log4j;

@Controller
@Log4j
@RequestMapping("/board/*")
public class BoardController {
	
@Autowired
private BoardService service;

@RequestMapping("list")
public void list(Model model) {
	log.info("list");
	model.addAttribute("list", service.getList());
}
	
}

**15. views 폴더에 board 폴더 작성 후 list.jsp 작성

http://localhost:8181/board/list 호출 시 jsp 페이지 실행됨.

**16. src/test/java에 org.zerock.controller 패키지 안에 BoardControllerTests 클래스 작성
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import lombok.extern.log4j.Log4j;

@WebAppConfiguration
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"file:src/main/webapp/WEB-INF/spring/root-context.xml"
	, "file:src/main/webapp/WEB-INF/spring/appServlet/servlet-context.xml"})
@Log4j
public class BoardControllerTests {
	
@Autowired
private WebApplicationContext ctx;

private MockMvc mockMvc;

//@Test 어노테이션 실행 전 선행처리(before)
@Before
public void setup() {
	this.mockMvc = MockMvcBuilders.webAppContextSetup(ctx).build();
}

@Test
public void testList() throws Exception{
	log.info(mockMvc.perform(MockMvcRequestBuilders.get("/board/list"))
			.andReturn().getModelAndView().getModelMap());
	
}
	
}

**17. BoardController 클래스에 아래 추가
@PostMapping("/register")
public String register(BoardVO vo, RedirectAttributes rttr) {
	log.info("register : " + vo);
	service.register(vo);
	rttr.addFlashAttribute("result", vo.getBno());
	return "redirect:/board/list";
}

**18. BoardControllerTests 클래스에 아래 추가    // 서버를 돌리지 않아도 간단히 테스트를 확인할 수 있는 test~
@Test
public void testRegister() throws Exception{
	String resultPage =
			mockMvc.perform(MockMvcRequestBuilders.post("/board/register")
			.param("title", "돈가스")
			.param("content", "왕돈가스")
			.param("writer", "치즈돈가스")
			).andReturn().getModelAndView().getViewName();
	log.info(resultPage);
}


**19. BoardController 클래스에 아래 추가  // 게시글 하나 가져오기
@GetMapping("get")
public void get(Long bno, Model model) {
	log.info("get -------------------- ");
	model.addAttribute("board", service.get(bno));
}

**20. BoardControllerTests 클래스에 아래 추가 // 게시글 하나 가져오는지 확인
@Test
public void testGet() throws Exception{
	log.info(mockMvc.perform(MockMvcRequestBuilders.get("/board/get")
			.param("bno", "11"))
			.andReturn().getModelAndView().getModelMap());
}

**21. BoardController 클래스에 아래 추가  // 게시글 하나 삭제하기
@PostMapping("/remove")
public String remove(Long bno, RedirectAttributes rttr) {
	log.info("remove : " + bno);
	if(service.remove(bno) == 1) {
		rttr.addFlashAttribute("result", "success");
	}
	return "redirect:/board/list";
}

**22. BoardControllerTests 클래스에 아래 추가 // 게시글 하나 삭제하는 지 확인
@Test
public void testRemove() throws Exception{
	String resultPage =
			mockMvc.perform(MockMvcRequestBuilders.post("/board/remove")
			.param("bno", "11")
			).andReturn().getModelAndView().getViewName();
	log.info(resultPage);
}

**23. BoardController 클래스에 아래 추가  // 게시글 하나 수정하기
@PostMapping("/modify")
public String modify(BoardVO vo, RedirectAttributes rttr) {
	log.info("modify : " + vo);
	if(service.modify(vo) == 1) {
		rttr.addFlashAttribute("result", "success");
	}
	return "redirect:/board/list";
}


**24. BoardControllerTests 클래스에 아래 추가 // 게시글 하나 수정하는 확인
@Test
public void testModify() throws Exception{
	String resultPage =
			mockMvc.perform(MockMvcRequestBuilders.post("/board/modify")
			.param("bno", "15")
			.param("title", "java")
			.param("content", "자바의정석")
			.param("writer", "남궁성")
			).andReturn().getModelAndView().getViewName();
	log.info(resultPage);
}


**25. 









































