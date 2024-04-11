package org.zerock.service;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.zerock.domain.BoardVO;

import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@Log4j
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
public class BoardServiceImplTest {

	//테스트환경에서는 생성자주입이안됨
	@Autowired
	private BoardService boardService;
	
	@Test
	public void test() {
		fail("Not yet implemented");
	}
	
	@Test
	public void testRegister() {
		BoardVO board = BoardVO.builder()
				.title("서비스 제목")
				.content("서비스 내용")
				.writer("service00")
				.build();
		boardService.register(board);
		log.info("생성된 게시물 번호 : " + board.getBno());
	}

}
