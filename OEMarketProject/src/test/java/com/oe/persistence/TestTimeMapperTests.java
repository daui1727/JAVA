package com.oe.persistence;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.oe.mapper.TestTimeMapper;

import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Log4j
public class TestTimeMapperTests {
	
	@Autowired
	private TestTimeMapper mapper;
	
	@Test
	public void testGetTime() {
		log.info("---------------------");
		log.info(mapper.getTime());
		log.info(mapper.getClass().getName());
		log.info("---------------------");
	}
}
