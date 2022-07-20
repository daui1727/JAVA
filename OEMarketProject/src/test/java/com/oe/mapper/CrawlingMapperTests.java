package com.oe.mapper;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Log4j
public class CrawlingMapperTests {
	
	@Autowired
	private CrawlingMapper mapper;
	
	@Test
	public void testGetList() {
		log.info("---------------------");
		log.info(mapper.getList());
		log.info("---------------------");
	}
	
	@Test
	public void testRead() {
		log.info("---------------------");
		log.info(mapper.read(2));
		log.info("---------------------");
	}

}
