package org.zerock.mapper;

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
		log.info("---------------------");
		log.info(mapper.getList());
		log.info("---------------------");
	}
	
	@Test
	public void testRead() {
		log.info("---------------------");
		log.info(mapper.read(2L));
		log.info("---------------------");
	}
	
	@Test
	public void testDelete() {
		log.info("---------------------");
		log.info(mapper.delete(2L));
		log.info("---------------------");
	}
	
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
	
	@Test
	public void testUpdate() {
		log.info("---------------------");
		BoardVO vo = new BoardVO();
		vo.setBno(4L);
		vo.setTitle("java40");
		vo.setContent("내용40...");
		vo.setWriter("남궁성40");
		
		log.info("insert : " + mapper.update(vo));
		log.info("---------------------");
	}

	
	
	
	
	
	
	
}
