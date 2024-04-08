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
		MemberVO vo = MemberVO.builder().id(22).name("이름").phone("010-2322-2322").address("서울").build();
		memberMapper.insertMember(vo);
	}

	@Test
	public void testUpdate() {

		MemberVO vo = MemberVO.builder().id(19).name("조운").phone("010-1111-2222").address("경기도 수원시").build();
		memberMapper.updateMember(vo);
	}

	@Test
	public void testDelete() {
		memberMapper.deleteMember(19);
	}

	@Test
	public void testSelectAll() {
		log.info(memberMapper.selectAllList());
	}
}
