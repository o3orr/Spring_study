package org.zerock.mapper;

import java.util.List;
import java.util.stream.IntStream;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.zerock.domain.Criteria;
import org.zerock.domain.ReplyVO;

import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Log4j
public class ReplyMapperTests {

	@Autowired
	private ReplyMapper replyMapper;

	private Long[] bnoArr = { 4194307L, 4194306L, 4194305L, 4194304L, 4194303L };

	@Test
	public void testMapper() {
		log.info(replyMapper);
	}

	// C
	@Test
	public void testCreate() {
		
		IntStream.range(1, 101).forEach(i -> {
		
		ReplyVO vo = ReplyVO.builder()
				.bno(bnoArr[i%5])
				.reply("댓글 테스트" + i)
				.replyer("repleyer" + i)
				.build();
		replyMapper.insert(vo);
	});
	}

	// R
	@Test
	public void testRead() {
		log.info(replyMapper.read(101L));
	}
	
	// U
	@Test
	public void testUpdate() {
		ReplyVO reply = ReplyVO.builder()
				.rno(102L)
				.reply("수정 테스트")
				.build();
		log.info(replyMapper.update(reply));
	}
	
	// D
	@Test
	public void testDelete() {
		log.info(replyMapper.delete(102L));
	}
	
	@Test
	public void getGetList() {
		
		Criteria cri = new Criteria();
		List<ReplyVO> list = replyMapper.getListWithPaging(cri, bnoArr[0]);
		list.forEach(reply -> log.info(reply));
		
	}
}