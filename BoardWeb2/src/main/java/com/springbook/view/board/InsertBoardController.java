package com.springbook.view.board;



import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.springbook.biz.board.BoardVO;
import com.springbook.biz.board.impl.BoardDAO;

@Controller
public class InsertBoardController{

	@RequestMapping("/insertBoard.do")
	public String insertBoard(BoardVO vo, BoardDAO boardDAO) {
		
		System.out.println("글 등록 처리");
		
		
		boardDAO.insertBoard(vo);

		return "getBoardList.do";
		// 3. 화면 네비게이션
//		return "getBoardList.do";
		
		
	}

	
	
}
