package com.oe.mapper;

import java.util.List;

import com.oe.domain.DGVO;

public interface CrawlingMapper {
	
	public List<DGVO> getList();
	public DGVO read(int no);
	public int insert(DGVO vo);

}
