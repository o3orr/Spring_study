package kr.com.ezen;

import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class Mainclass {

	public static void main(String[] args) {

		try {
			String resource = "kr/com/ezen/mybatis-config.xml";
			InputStream inputStream = Resources.getResourceAsStream(resource);
			SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

			SqlSession session = sqlSessionFactory.openSession(true);
			//매퍼를 이용해서 얻어올 수 없는 인터페이스 객체를 얻어옴
			MapperInterface mapper = session.getMapper(MapperInterface.class);

			System.out.println(session);
			
			MemberVO vo = new MemberVO();
			vo.setId(4);
			vo.setName("관우");
			vo.setPhone("010-1111-2222");
			vo.setAddress("경기도 수원시");
			
//			mapper.updateMember(vo);
//			mapper.deleteMember(2);
//			mapper.insertMember(vo);
			
			vo = mapper.selectMemberOne(1);
			List<MemberVO> list = mapper.selectMemberList();
			
			System.out.println(vo);
			
			for(MemberVO lists : list) {
				System.out.println(lists);
			}		
			

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}