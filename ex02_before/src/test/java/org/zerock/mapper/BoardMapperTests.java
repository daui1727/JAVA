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
//		mapper.getList().forEach(board->log.info(board));
		for(BoardVO vo : mapper.getList()) {
			log.info(vo);
		}
	}
	
	@Test
	public void testinsert() {
		BoardVO vo = new BoardVO();
		vo.setTitle("java의 정석");
		vo.setContent("자바 책.....");
		vo.setWriter("남궁성");
		
		mapper.insert(vo);
	}
	
	@Test
	public void testSelectKey() {
		BoardVO vo = new BoardVO();
		vo.setTitle("Jsp");
		vo.setContent("JSP/servlet");
		vo.setWriter("성윤정");
		mapper.insertSelectKey(vo);
		log.info(vo);
	}
	
	@Test
	public void testRead() {
		BoardVO vo = mapper.read(8L);
		log.info(vo);
	}
	
	@Test
    public void testDelete() {
       log.info("delete count : "+mapper.delete(2L));
    }
	
	@Test
    public void testUpdate() {
		BoardVO vo = new BoardVO();
		vo.setBno(3L);
		vo.setTitle("오라클");
		vo.setContent("오라클");
		vo.setWriter("오라클");
		log.info("update : " + mapper.update(vo));
    }
	
	

}




