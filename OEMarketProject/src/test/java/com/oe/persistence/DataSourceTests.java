package com.oe.persistence;

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
