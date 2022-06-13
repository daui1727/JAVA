package com.saeyan.dto;

import lombok.Getter;
import lombok.Setter;

/*
 create table product(
    code number(5),
    name varchar2(100),
    price number(8),
    pictureurl varchar(50),
    description varchar(1000),
    PRIMARY KEY (code)
);
*/

@Getter
@Setter
public class ProductVO {
	
	private Integer code;
	private Integer price;
	private String name;
	private String pictureurl;
	private String description;

}
