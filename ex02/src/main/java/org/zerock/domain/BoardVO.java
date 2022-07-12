package org.zerock.domain;

import java.util.Date;

import lombok.Data;

/*
BNO NUMBER(10,0), 
TITLE VARCHAR2(200) NOT NULL, 
CONTENT VARCHAR2(2000) NOT NULL, 
WRITER VARCHAR2(50) NOT NULL, 
REGDATE DATE, 
UPDATEDATE DATE

 */

@Data
public class BoardVO {
	
	private Long bno;
	private String title, content, writer;
	private Date regdate, updatedate;

}
