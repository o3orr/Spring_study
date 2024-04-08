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
		log.info(memberMapper.selectOneMember(18));
	}
	
	@Test
	public void testInsert() {
		MemberVO vo = MemberVO.builder()
				.id(20)
				.name("이름")
				.phone("010-1111-3333")
				.address("화성시")
				.build();
		memberMapper.insertMember(vo);
	}
	
	@Test
	public void testUpdate() {
		MemberVO vo = MemberVO.builder()
				.id(20)
				.name("이름")
				.phone("010-2222-4444")
				.address("제주도")
				.build();
		memberMapper.updateMember(vo);
	}
	
	@Test
	public void testDelete() {
		log.info(memberMapper.deleteMember(20));
	}
	
	@Test
	public void selectAllList() {
		log.info(memberMapper.selectAllList());
	}

}