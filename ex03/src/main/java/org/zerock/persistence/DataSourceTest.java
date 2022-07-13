package org.zerock.persistence;

import javax.inject.Inject;
import javax.sql.DataSource;

import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
public class DataSourceTest {
	
	// DataSource의 객체를 new를 사용해 따로 생성해줄 필요없이 스프링이 생성해서 주입해준다.
	@Inject
	private DataSource ds;
	
	public void testConnection() throws Exception{
		
	}

}
