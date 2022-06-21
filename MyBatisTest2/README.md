mybatis

h2 database > download > version 2.1.214 zip 파일 다운 > C드라이브 > H2DB 폴더 생성 후 압축 풀기 >
ibatis import 사용

*************************진행 순서

1. Spring Legacy Project 생성

2. Templates : Persistence > Spring MVC Project 없으면 Configure templates > 
눌러서 1번째 3번째 remove Apply and Close > Spring MVC Project 나올때까지 sts 껏다키기 
or Restore Defaults 눌러서 다시 나타낸 후 다시 지우고 껏다키기 > 
Project Name : MybatistTest> Next > Yes > com.ezen.mybatist > finish 

3. 프로젝트 Properties --> Project Facets > java 11변경 아파치 선택
pom.xml > java version 1.8 변경 > org.springframework-version : 5.2.7.RELEASE 변경 > 
141번줄 source 1.8 변경 > 118번줄 119번줄 사이 > Maven Repository > lombok 검색 > Project Lombok >
1.18.24 선택 Maven 에서 
<!-- https://mvnrepository.com/artifact/org.projectlombok/lombok -->
<dependency>
    <groupId>org.projectlombok</groupId>
    <artifactId>lombok</artifactId>
    <version>1.18.24</version>
    <scope>provided</scope>
</dependency>

복사 후 119번줄에 붙여넣기 > Junit version 4.12로 변경 > Maven Repository > objdc8 검색 21.5.0.0 선택 > 
<!-- https://mvnrepository.com/artifact/com.oracle.database.jdbc/ojdbc8 -->
    <dependency>
    <groupId>com.oracle.database.jdbc</groupId>
    <artifactId>ojdbc8</artifactId>
    <version>21.5.0.0</version>
</dependency>

복사 후 붙여넣기 > Mybatis 검색 1번째(MyBatis) 
<!-- https://mvnrepository.com/artifact/org.mybatis/mybatis -->
<dependency>
    <groupId>org.mybatis</groupId>
    <artifactId>mybatis</artifactId>
    <version>3.5.10</version>
</dependency>

2번째(MyBatis Spring) 
<!-- https://mvnrepository.com/artifact/org.mybatis/mybatis-spring -->
<dependency>
    <groupId>org.mybatis</groupId>
    <artifactId>mybatis-spring</artifactId>
    <version>2.0.7</version>
</dependency>


4. 클래스 생성
Name : MyBatisMain 입력 후 main 선택 finish > 인터넷에 MyBatis org 검색 > 맨 위에것 선택 > 시작하기 > 
String resource = "com/ezen/mybatis/mybatis-config.xml";
InputStream inputStream = Resources.getResourceAsStream(resource);
SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream); 복사 후 
main에 붙여넣기 > ibatis 로 import 하고 Resource.get ~ try/catch 선택 > SqlsessionFactory Try문 안으로 옮기기 > 
패키지에 xml 파일 mybatis-config 이름으로 생성 > 
<?xml version="1.0" encoding="UTF-8" ?>
<!DOCTYPE configuration
  PUBLIC "-//mybatis.org//DTD Config 3.0//EN"
  "http://mybatis.org/dtd/mybatis-3-config.dtd">
<configuration>
  <environments default="development">
    <environment id="development">
      <transactionManager type="JDBC"/>
      <dataSource type="POOLED">
        <property name="driver" value="jdbc.oracle.driver.OracleDriver"/>
        <property name="url" value="oracle:jdbc:thin:@localhost:1521:xe"/>
        <property name="username" value="mybatis"/>
        <property name="password" value="1234"/>
      </dataSource>
    </environment>
  </environments>
  <mappers>
    <mapper resource="com/ezen/mybatis/BoardMapper.xml"/>
  </mappers>
</configuration>
붙여넣기

5. 오라클 실행 system 접속 후 
create user mybatis IDENTIFIED by 1234; 유저생성
grant connect, resource, dba to mybatis; 유저 권한주기
접속 MyBatis Test 이름 mybatis 비번 1234 접속
create table board(
    id number(5) primary key,
    name varchar(20),
    phone varchar2(20),
    address varchar2(50)
); 테이블 생성
insert into board values(1, '홍길동', '010-1111-2222', '서울시 강남구'); 
commit; 데이터 입력
SqlSession session = sqlSessionFactory.openSession();
BoardMethod mapper = session.getMapper(BoardMethod.class);
BoardVO vo = mapper.selectOne(1);
try 사이에 집어넣기 > 인터페이스 생성(BoardMethod) >
	public BoardVO selectOne(int id);
	public List<BoardVO> selectAllMember();
	
	
6. VO 생성(BoardVO) > xml 파일 생성(BoardMapper)
<?xml version="1.0" encoding="UTF-8" ?>
<!DOCTYPE mapper
  PUBLIC "-//mybatis.org//DTD Mapper 3.0//EN"
  "http://mybatis.org/dtd/mybatis-3-mapper.dtd">
<mapper namespace="com.ezen.mybatis.BoardMethod">
  <select id="selectOne" resultType="com.ezen.mybatis.BoardVO" parameterType="int">
    select * from Board where id = #{id}
  </select>
</mapper>
붙여넣기 >
sql 추가 할 때 는 BoardMethod 에 추가 후 Mapper에 
<select id="selectAllMember"  resultType="com.ezen.mybatis.BoardVO" >
  	select * from board
</select>
<delete id="deleteBoard">
	delete from board where id = #{id}
</delete>
<insert id="insertBoard" parameterType="com.ezen.mybatis.BoardVO">
	insert into board values(#{id}, #{name}, #{phone}, #{address})
</insert>



********************************************************


- MainClass 클래스 생성 후 mybatis 설정

- mybatis-config.xml 작성 (mapper는 일단 주석처리. 나중에 설정한 이후에 풀어준다)

- MapperInterface 인터페이스 생성. 

 public BoardVO selectOne(int id); 작성
 
- MainClass try 안에
	SqlSession session = sqlSessionFactory.openSession();
	MapperInterface mapper = session.getMapper(MapperInterface.class);
	BoardVO vo = mapper.selectOne(1);

작성하고 

- mapperInterface 인터페이스 작성
<?xml version="1.0" encoding="UTF-8" ?>
<!DOCTYPE mapper
  PUBLIC "-//mybatis.org//DTD Mapper 3.0//EN"
  "http://mybatis.org/dtd/mybatis-3-mapper.dtd">
<mapper namespace="com.ezen.mybatis.MapperInterface">

  <select id="selectOne" resultType="com.ezen.mybatis.BoardVO" parameterType="int">
    select * from board where id = #{id}
  </select>
</mapper>












