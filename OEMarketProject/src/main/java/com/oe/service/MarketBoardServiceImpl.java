package com.oe.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.oe.domain.DGVO;
import com.oe.mapper.CrawlingMapper;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;

@Service
@Log4j
@AllArgsConstructor
public class MarketBoardServiceImpl implements MarketBoardService {

	private CrawlingMapper mapper;
	
	@Override
	public void register(DGVO vo) {
		log.info("등록 완료 ======================= ");
		mapper.insert(vo);
	}

	@Override
	public DGVO get(int no) {
		return mapper.read(no);
	}

	@Override
	public int modify(DGVO vo) {
		return 0;
	}

	@Override
	public int remove(int no) {
		return 0;
	}

	@Override
	public List<DGVO> getList() {
		log.info("getList============================");
		return mapper.getList();
	}
	
	

}
