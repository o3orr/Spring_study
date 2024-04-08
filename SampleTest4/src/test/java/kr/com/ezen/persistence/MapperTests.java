package kr.com.ezen.persistence;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import kr.com.ezen.dto.MemberVO;
import kr.com.ezen.mapper.MemberMapper;
import lombok.extern.log4j.Log4j;

@Log4j
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
public class MapperTests {
	
	@Autowired
	private MemberMapper memberMapper;
	
	@Test
	public void testSelectOne() {
		log.info(memberMapper.selectOneMember(20));
	}
	
	@Test
	public void testInsert() {
		MemberVO vo = MemberVO.builder()
				.id(21)
				.name("이름!!")
				.phone("010-3333-4444")
				.address("서울")
				.build();
		memberMapper.InsertMember(vo);
	}
	
	@Test
	public void testUpdate() {
		MemberVO vo = MemberVO.builder()
				.id(21)
				.name("이름!!!!")
				.phone("010-2323-2323")
				.address("제주")
				.build();
		memberMapper.updateMember(vo);
	}
	
	@Test
	public void testDelete() {
		log.info(memberMapper.deleteMember(21));
	}
	
	@Test
	public void testSelectList() {
		log.info(memberMapper.selectAllList());
	}

}