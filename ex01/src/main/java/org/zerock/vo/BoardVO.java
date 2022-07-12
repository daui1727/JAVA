package org.zerock.vo;

import java.util.Date;

import lombok.Data;

@Data
public class BoardVO {
	
	private int bno;
	private String title, content, writer;
	private Date regdate;

}
