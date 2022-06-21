package com.ezen.mybatis;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class MyBatisMain {

	public static void main(String[] args) {
		String resource = "com/ezen/mybatis/mybatis-config.xml";
		InputStream inputStream = null;
		try {
			inputStream = Resources.getResourceAsStream(resource);
			SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

			SqlSession session = sqlSessionFactory.openSession();
			System.out.println("sqlSessionFactory : "+sqlSessionFactory);
			System.out.println("session"+session);
			BoardMethod mapper = session.getMapper(BoardMethod.class);
			
			BoardVO  vo = mapper.selectOne(1);
			System.out.println(vo.getId());
			System.out.println(vo.getName());
			System.out.println(vo.getPhone());
			System.out.println(vo.getAddress());
			
//			mapper.deleteBoard(5);
//			BoardVO vo3 = new BoardVO();
//			vo3.setId(10);
//			vo3.setName("손흥민");
//			vo3.setPhone("010-2222-3333");
//			vo3.setAddress("영국");
//			mapper.insertBoard(vo3);
			
			BoardVO vo4 = new BoardVO();
			vo4.setName("홍길동10");
			vo4.setPhone("010-1234-1234");
			vo4.setAddress("서울");
			vo4.setId(10);
			mapper.updateBoard(vo4);
			
			session.commit();
			
			System.out.println("---------------------");
			List<BoardVO> list = mapper.selectAllMember();
			for(BoardVO vo2 : list	)
				System.out.println(vo2.toString());
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
