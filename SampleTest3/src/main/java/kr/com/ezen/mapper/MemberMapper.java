package kr.com.ezen.mapper;

import java.util.List;

import org.mybatis.spring.annotation.MapperScan;

import kr.com.ezen.dto.MemberVO;

@MapperScan
public interface MemberMapper {
	public MemberVO selectOneMember(int id);
	public int insertMember(MemberVO vo);
	public int updateMember(MemberVO vo);
	public int deleteMember(int id);
	public List<MemberVO> selectAllList();
}
