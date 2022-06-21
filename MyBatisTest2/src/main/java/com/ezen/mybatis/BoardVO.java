package com.ezen.mybatis;

import lombok.Data;

/*
 create table board(
    id number(5) primary key,
    name varchar(20),
    phone varchar2(20),
    address varchar2(50)
);
 * */

@Data
public class BoardVO {
	private int id;
	private String name;
	private String phone;
	private String address;
	
}	
