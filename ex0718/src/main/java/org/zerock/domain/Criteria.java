package org.zerock.domain;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class Criteria {
	
	private int pageNum;
	private int amount;
	
	public Criteria() {
		this(1,10);
	}
	
	public Criteria(int pageNum, int amount) {
		this.pageNum = pageNum;
		this.amount = amount;
	}

}
