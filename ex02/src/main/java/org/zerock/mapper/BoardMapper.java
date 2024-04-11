package org.zerock.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Select;
import org.zerock.domain.BoardVO;

public interface BoardMapper {
	public List<BoardVO> getList();
	public void insert(BoardVO board);
	
	//db에 몇번째 데이터가 들어갔는지 알고싶을때
	public void insertSelectKey(BoardVO board);
	
	
	public BoardVO read(Long bno);
	public int update(BoardVO boardVO);
	public int delete(Long bno);
}
