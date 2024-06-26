package kr.com.ezen.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.com.ezen.dto.MemberVO;
import kr.com.ezen.mapper.MemberMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j;

@Service
@Log4j
@RequiredArgsConstructor //생성자 주입에 사용
public class MemberServiceImpl implements MemberService{
	
	//생성자 주입, final써야함
	//memberMapper안에 아무것도 없기때문에 실행안됨
	private final MemberMapper memberMapper;
	
//	@Autowired //필드주입 -> 안씀 값을 바꿀 수 있기 때문에
//	private MemberMapper mapper;

	
	@Override
	public void insertMember(MemberVO vo) {
		memberMapper.insertMember(vo);
		
	}

	@Override
	public void updateMember(MemberVO vo) {
		memberMapper.updateMember(vo);
		
	}

	@Override
	public void deleteMember(int id) {
		memberMapper.deleteMember(id);
		
	}

	@Override
	public MemberVO selectOne(int id) {
		return memberMapper.selectOneMember(id);
	}

	@Override
	public List<MemberVO> list() {
		return memberMapper.selectAllList();
	}

}
