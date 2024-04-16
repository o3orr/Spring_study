package org.zerock.service;

import java.util.List;

import org.zerock.domain.BoardVO;
import org.zerock.domain.Criteria;

public interface BoardService {
	
	//insert
	public void register(BoardVO board);
	
	//select
	public BoardVO get(Long bno);
	
	//update
	public boolean modity(BoardVO board);
	
	//delete
	public boolean remove(Long bno);
	
	//selectAll
	public List<BoardVO> getList(Criteria cri);
}
