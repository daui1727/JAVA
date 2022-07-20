package com.oe.service;

import java.util.List;

import com.oe.domain.DGVO;

public interface MarketBoardService {
	
	public void register(DGVO vo);
	public DGVO get(int no);
	public int modify(DGVO vo);
	public int remove(int no);
	public List<DGVO> getList();

}
