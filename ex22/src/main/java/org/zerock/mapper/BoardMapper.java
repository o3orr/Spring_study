package org.zerock.mapper;

import java.util.List;

import org.zerock.domain.BoardVO;

public interface BoardMapper {
	
//	@Select("select * from tbl_board")
	public List<BoardVO> getList();
	
	//insert만 처리되고 생성된 PK값을 알 필요가 없는 경우
	public void insert(BoardVO board);
	
	//insert문이 실행되고 생성된 PK값을 알아야 하는 경우
	public void insertSelectKey(BoardVO board);
	
	
	//select
	public BoardVO read(Long bno);
	
	public int delete(Long bno);
	
	public int update(BoardVO board);
}
