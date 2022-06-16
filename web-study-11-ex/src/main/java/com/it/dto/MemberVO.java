package com.it.dto;

import java.sql.Timestamp;

import lombok.Data;

/*
 create table employees(
    id varchar2(10) not null,
    pass varchar2(10) not null,
    name varchar2(24),
    lev char(1) default 'A',    -- A : 운영자, B : 일반회원
    enter DATE DEFAULT SYSDATE,  -- 등록일
    gender char(1) DEFAULT '1',   -- 1 : 남자, 2 : 여자
    phone varchar2(30),
    PRIMARY KEY (id)
);
 * */
@Data
public class MemberVO {
	
	private String id;
	private String pass;
	private String name;
	private String lev;
	private Timestamp enter;
	private String gender;
	private String phone;
	
	

}
