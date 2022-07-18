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
public class BoardServiceTests {

	@Autowired
	private BoardService service;
	
	@Test
	public void testRegister() {
		BoardVO vo = new BoardVO();
		vo.setTitle("삼국지");
		vo.setContent("영웅호걸전.......");
		vo.setWriter("황석영");
		service.register(vo);
		log.info("생성된 게시물 번호" + vo.getBno());
	}
	
	@Test
	public void testRead() {
		service.get(1L);
	}
	
	@Test
	public void testDelete() {
		log.info("삭제된 개수 : " + service.remove(6L));
	}
	
	@Test
	public void testModify() {
		BoardVO vo = new BoardVO();
		vo.setBno(21L);
		vo.setTitle("피곤");
		vo.setContent("하다");
		vo.setWriter("......");
		
		service.modify(vo);
	}
	
	@Test
	public void testGetList() {
		service.getList();
	}
}
