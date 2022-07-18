package org.zerock.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.zerock.domain.BoardVO;
import org.zerock.mapper.BoardMapper;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;

@Service
@Log4j
@AllArgsConstructor  // AutoWired를 쓰지 않아도 변수를 자동 주입해주는.
public class BoardServiceImpl implements BoardService{

	private BoardMapper mapper;
	
	@Override
	public void register(BoardVO vo) {
		log.info("register ---------------------- ");
		
		mapper.insert(vo);
	}
	
	@Override
	public void registerSelectKey(BoardVO vo) {
		log.info("register ---------------------- ");
		
		mapper.insertSelectKey(vo);
	}

	@Override
	public int modify(BoardVO vo) {
		log.info("modify ---------------------- ");
		
		return mapper.update(vo);
	}

	@Override
	public int remove(Long bno) {
		log.info("remove ---------------------- ");
		
		return mapper.delete(bno);
	}

	@Override
	public BoardVO get(Long bno) {
		log.info("get ---------------------- ");
		
		return mapper.read(bno);
	}

	@Override
	public List<BoardVO> getList() {
		log.info("getList ---------------------- ");
		
		return mapper.getList();
	}
	
	

}
