package com.it.dao;
// DBCP (톰캣)=> 웹에서만 사용이 가능 (웹애플리케이션의 데이터베이스 기본)
// 일반 JDBC 사용 
import java.util.*;
import java.sql.*;
/*
 *   MNO      NOT NULL NUMBER        
	CNO               NUMBER        
	TITLE    NOT NULL VARCHAR2(500) 
	GRADE    NOT NULL VARCHAR2(50)  
	RESERVE           VARCHAR2(20)  
	GENRE    NOT NULL VARCHAR2(200) 
	TIME              VARCHAR2(30)  
	REGDATE           VARCHAR2(200) 
	DIRECTOR NOT NULL VARCHAR2(100) 
	ACTOR             VARCHAR2(200) 
	SHOWUSER          VARCHAR2(20)  
	POSTER   NOT NULL VARCHAR2(260) 
	STORY             CLOB          
	KEY      NOT NULL VARCHAR2(50)  
	HIT               NUMBER        
	SCORE             NUMBER(3,2)   
 */
public class DataDAO {
   private Connection conn;
   private PreparedStatement ps;
   private final String URL="jdbc:mysql://localhost:3306/db0416?serverTimezone=UTC";
   private static DataDAO dao;
   // 드라이버 등록 
   public DataDAO()
   {
	   try
	   {
		   Class.forName("com.mysql.cj.jdbc.Driver");
	   }catch(Exception ex){}
   }
   // 연결 
   public void getConnection()
   {
	   try
	   {
		   conn=DriverManager.getConnection(URL,"root","1234");
	   }catch(Exception ex) {}
   }
   public void disConnection()
   {
	   try
	   {
		   if(ps!=null) ps.close();
		   if(conn!=null) conn.close();
	   }catch(Exception ex) {}
   }
   // 싱글턴 => DAO를 한번만 사용이 가능 (메모리 공간을 1개만 생성) = 재사용
   // 스프링에서는 기본 (싱글턴) => 필요시에는 여러개 객체 생성 => prototype
   public static DataDAO newInstance()
   {
	   if(dao==null)
		   dao=new DataDAO();
	   return dao;
   }
   // ==> 영화 => 맛집 => 레시피 => 명소 ,호텔 , 자연(관광) => 일정(코스) (추천)
   // 명소 
   /*
    *  NO      NOT NULL NUMBER         
	TITLE   NOT NULL VARCHAR2(200)  
	POSTER  NOT NULL VARCHAR2(500)  
	MSG     NOT NULL VARCHAR2(4000) 
	ADDRESS NOT NULL VARCHAR2(300)   
    */
   public void seoulShoppingInsert(SeoulShoppingVO vo) {
	   try {
		   getConnection();
		   String sql = "INSERT INTO seoul_shopping VALUES(?,?,?,?,?)";
		   ps = conn.prepareStatement(sql);
		   ps.setInt(1, vo.getNo());
		   ps.setString(2, vo.getTitle());
		   ps.setString(4, vo.getPoster());
		   ps.setString(5, vo.getMsg());
		   ps.setString(3, vo.getAddress());
		   ps.executeUpdate();
	   }catch(Exception ex) {
		   ex.printStackTrace();
	   }finally {
		   disConnection();
	   }
   }
   
   public void seoulLocationInsert(SeoulLocationVO vo)
   {
	   try
	   {
		   getConnection();
		   String sql="INSERT INTO seoul_location VALUES(?,?,?,?,?)";
		   ps=conn.prepareStatement(sql);
		   ps.setInt(1, vo.getNo());
		   ps.setString(2, vo.getTitle());
		   ps.setString(4, vo.getPoster());
		   ps.setString(5, vo.getMsg());
		   ps.setString(3, vo.getAddress());
		   ps.executeUpdate();
	   }catch(Exception ex)
	   {
		   ex.printStackTrace();
	   }
	   finally
	   {
		   disConnection();
	   }
   }
   // 호텔
   /*
    *  CREATE TABLE SEOUL_HOTEL
   (	
     no int, 
	 name varchar(100), 
	 score double, 
	 address varchar(200), 
	 poster varchar(200),
	 images varchar(1000)
   );

    */
   public void seoulHotelInsert(SeoulHotelVO vo)
   {
	   try
	   {
		   getConnection();
		   String sql="INSERT INTO seoul_hotel VALUES(?,?,?,?,?,?)";
		   ps=conn.prepareStatement(sql);
		   ps.setInt(1, vo.getNo());
		   ps.setString(2, vo.getName());
		   ps.setDouble(3, vo.getScore());
		   ps.setString(4, vo.getAddress());
		   ps.setString(5, vo.getPoster());
		   ps.setString(6, vo.getImages());
		   ps.executeUpdate();
	   }catch(Exception ex)
	   {
		   ex.printStackTrace();
	   }
	   finally
	   {
		   disConnection();
	   }
   }
   // 자연 
   /*
    * CREATE TABLE SEOUL_NATURE
   (	
       no int, 
       name varchar(100), 
       address varchar(200), 
	   poster varchar(200),
	   msg varchar(1000)
   );

    */
   public void seoulNatureInsert(SeoulNatureVO vo)
   {
	   try
	   {
		   getConnection();
		   String sql="INSERT INTO seoul_nature VALUES(?,?,?,?,?)";
		   ps=conn.prepareStatement(sql);
		   ps.setInt(1, vo.getNo());
		   ps.setString(2, vo.getTitle());
		   ps.setString(4, vo.getPoster());
		   ps.setString(5, vo.getMsg());
		   ps.setString(3, vo.getAddress());
		   ps.executeUpdate();
	   }catch(Exception ex)
	   {
		   ex.printStackTrace();
	   }
	   finally
	   {
		   disConnection();
	   }
   }
   // 레시피 
   // 레시피 상세
   // 쉐프 
   
}






