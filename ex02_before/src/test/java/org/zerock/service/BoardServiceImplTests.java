package org.zerock.service;

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
		vo.setTitle("java의 정석3");
		vo.setContent("자바 책3.....");
		vo.setWriter("남궁성3");
		
		service.register(vo);
	}
	
	@Test
	public void testRegisterSelectKey() {
		BoardVO vo = new BoardVO();
		vo.setTitle("java의 정석5");
		vo.setContent("자바 책5.....");
		vo.setWriter("남궁성5");
		
		service.registerSelectKey(vo);
		log.info("생성된 게시물 번호 : " + vo.getBno());
	}
	
	@Test
	public void testRead() {
		log.info("READ ------------------- ");
		log.info(service.get(9L));
		
	}
	
	@Test
	public void testGetList() {
		
		log.info("getList ------------------- ");
		service.getList();
		
	}
	
	@Test
	public void testRemove() {
		
		log.info("remove ------------------- ");
		log.info("삭제 : " + service.remove(10L));
		
	}
	
	@Test
	public void testModify() {
		
		log.info("modify ------------------- ");
		BoardVO vo = new BoardVO();
		vo.setBno(12L);
		vo.setTitle("수원");
		vo.setContent("경기도");
		vo.setWriter("학원");
		
		log.info("수정 : " + service.modify(vo));
		
	}
	
	
	
	
	

}
