package com.oe.domain;

import lombok.Data;

/*

create SEQUENCE seq_crawling;

create table crawlingTest(
    no number,
    title varchar2(100),
    content varchar2(500),
    poster varchar2(500),
    address varchar2(500),
    heart number,
    price number
);

alter table crawlingTest add CONSTRAINT pk_crawlingTest PRIMARY key(no);

select * from CRAWLINGTEST;
 
*/


@Data
public class DGVO {
	
	private int no, price, heart;
	private String title, content, poster, address;

}
