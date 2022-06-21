package com.ezen.mybatis;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class MainClass {

	public static void main(String[] args) {
		
		/* DB 접속 */
		
		String resource = "com/ezen/mybatis/mybatis-config.xml";
		InputStream inputStream;
		try {
			inputStream = Resources.getResourceAsStream(resource);
			SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
			/* //DB 접속 */
			System.out.println(sqlSessionFactory);
			
			SqlSession session = sqlSessionFactory.openSession();
			
			mapperInterface mapper = session.getMapper(mapperInterface.class);
			BoardVO vo = mapper.selectOne(1);
			System.out.println(vo.getName());
				
			
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
