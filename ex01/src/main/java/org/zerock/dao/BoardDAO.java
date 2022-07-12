package org.zerock.dao;

import org.zerock.vo.BoardVO;

public interface BoardDAO {
	
	// 게시글 작성
	public void write(BoardVO vo);

}
