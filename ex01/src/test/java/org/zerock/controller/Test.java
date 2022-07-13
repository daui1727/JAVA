package org.zerock.controller;

import java.sql.Connection;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Log4j
public class Test {
	
	@Autowired
	private DataSource ds;
	
	@Autowired
	private SqlSessionFactory sqlFactory;

	@org.junit.Test
	public void test() {
		try(Connection conn = ds.getConnection()) {
			log.info("---------------");
			log.info(conn);
			log.info("---------------");
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	@org.junit.Test
    public void factoryTest() {
        System.out.println(sqlFactory);
      
    }
	
	@org.junit.Test
	public void sessionTest() {
		try(SqlSession session = sqlFactory.openSession()) {
			log.info("---------------");
			log.info(session);
			log.info("---------------");
        }catch(Exception e) {
            e.printStackTrace();
        }
	}
}
