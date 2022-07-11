게시판 만들기

************************************
개발 환경


************************************
************************************

개발 순서

**1. web.xml에 아래 코드 추가. 한글 인코딩  // 기본 설정 utf-8로
<!-- 한글 인코딩 Start -->
	<filter>
		<filter-name>encodingFilter</filter-name>
		<filter-class>
			org.springframework.web.filter.CharacterEncodingFilter
		</filter-class>
		<init-param>
			<param-name>encoding</param-name>
			<param-value>UTF-8</param-value>
		</init-param>
		<init-param>
			<param-name>forceEncoding</param-name>
			<param-value>true</param-value>
		</init-param>
	</filter>
	<filter-mapping>
		<filter-name>encodingFilter</filter-name>
		<url-pattern>/*</url-pattern>
	</filter-mapping>
<!-- 한글 인코딩 End -->


**2. home.jsp에 <%@ page session="false" %>를 지우고
<%@ page language="java" pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" %> 추가

**3. <Mybitis와 오라클을 연동하는 방법> - pom.xml에 아래 추가

<!-- 오라클 -->
<repositories>
	<repository>
		<id>oracle</id>
		<url>http://maven.jahia.org/maven2</url>
	</repository>
</repositories>

 spring-jdbc, junit, spring-test, log4jdbc, mybatis, mybatis-spring 추가
 
 <!-- spring-jdbc -->
<dependency>
    <groupId>org.springframework</groupId>
    <artifactId>spring-jdbc</artifactId>
    <version>${org.springframework-version}</version>
</dependency>
 
<!-- Test -->
<dependency>
    <groupId>junit</groupId>
    <artifactId>junit</artifactId>
    <version>4.12</version>
    <scope>test</scope>
</dependency>
 
<!-- spring-test -->
<dependency>
    <groupId>org.springframework</groupId>
    <artifactId>spring-test</artifactId>
    <version>${org.springframework-version}</version>
    <scope>test</scope>
</dependency>
 
<!-- log4jdbc-log4j2-jdbc4 -->
<dependency>
    <groupId>org.bgee.log4jdbc-log4j2</groupId>
    <artifactId>log4jdbc-log4j2-jdbc4</artifactId>
    <version>1.16</version>
</dependency>
  
<!-- org.mybatis/mybatis -->
<dependency>
    <groupId>org.mybatis</groupId>
    <artifactId>mybatis</artifactId>
    <version>3.4.1</version>
</dependency>
      
<!-- mybatis-spring -->
<dependency>
    <groupId>org.mybatis</groupId>
    <artifactId>mybatis-spring</artifactId>
    <version>1.3.0</version>
</dependency>


**4. src/main/resources에 log4jdbc.log4j2.properties 파일 생성

log4jdbc.spylogdelegator.name=net.sf.log4jdbc.log.slf4j.Slf4jSpyLogDelegator


**5. WEB-INF 에 lib 폴더 생성. ojdbc6.jar 붙여넣기 - Build Path 추가

**6. root-context.xml을 열고 Namespaces 클릭 후 beans, context, jdbc, mybatis-spring 체크 / source 탭에 아래 추가
<!-- 오라클 접속 -->
<bean class="org.springframework.jdbc.datasource.DriverManagerDataSource" id="dataSource">
    <property name="driverClassName" value="net.sf.log4jdbc.sql.jdbcapi.DriverSpy"/>
    <property name="url" value="jdbc:log4jdbc:oracle:thin:@localhost:1521/orcl"/>
    <property name="username" value="MelonPeach"/>
    <property name="password" value="1234"/>
</bean>
   
<!-- Mybatis 연동 -->
<bean id="sqlSessionFactory" class="org.mybatis.spring.SqlSessionFactoryBean">
     <property name="dataSource" ref="dataSource"></property>
     <property name="configLocation" value="classpath:/mybatis-config.xml"></property>
     <property name="mapperLocations" value="classpath:mappers/**/*Mapper.xml"/>
</bean>
<bean id="sqlSession" class="org.mybatis.spring.SqlSessionTemplate" destroy-method="clearCache">
    <constructor-arg name="sqlSessionFactory" ref="sqlSessionFactory"></constructor-arg>
</bean>


**7. resources 폴더 아래에 mappers 폴더 만든 후 boardMapper.xml 파일 만들고 아래 추가
<?xml version="1.0" encoding="UTF-8"?>
<!DOCTYPE mapper
  PUBLIC "-//mybatis.org//DTD Mapper 3.0//EN"
  "http://mybatis.org/dtd/mybatis-3-mapper.dtd">
<mapper namespace="boardMapper">
   
</mapper>

**8. resources 폴더에 mybatis-config.xml 파일 만들고 아래 추가
<?xml version="1.0" encoding="UTF-8" ?>
<!DOCTYPE configuration
  PUBLIC "-//mybatis.org//DTD Config 3.0//EN"
  "http://mybatis.org/dtd/mybatis-3-config.dtd">
<configuration>
  
</configuration>

**9. src/test/java -> kr.co.controller에 Test.java파일 생성 후 아래처럼 작성
















