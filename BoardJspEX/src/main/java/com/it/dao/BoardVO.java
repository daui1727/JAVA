package com.it.dao;

import java.util.*;

/* 게시판 만들기 순서
1)  DB에 테이블을 만든다.

create table jspBoard(
	no int auto_increment,
   name varchar(34) not null,
   subject varchar(1000) not null,
   content text not null,
   pwd varchar(10) not null,
   regdate datetime,
   hit int default 0,
   primary key(no)
);

2) 패키지 안에 VO와 DAO를 설정한다.

*/


public class BoardVO {
	
	private int no, hit;
	private String name, subject, content, pwd, dbday;
	private Date regdate;
	
	public int getNo() {
		return no;
	}
	public void setNo(int no) {
		this.no = no;
	}
	public int getHit() {
		return hit;
	}
	public void setHit(int hit) {
		this.hit = hit;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	public String getDbday() {
		return dbday;
	}
	public void setDbday(String dbday) {
		this.dbday = dbday;
	}
	public Date getRegdate() {
		return regdate;
	}
	public void setRegdate(Date regdate) {
		this.regdate = regdate;
	}
	
	

}
