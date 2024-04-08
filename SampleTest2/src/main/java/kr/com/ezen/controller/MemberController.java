package kr.com.ezen.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import kr.com.ezen.dto.MemberVO;
import kr.com.ezen.service.MemberService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j;

@Controller
@Log4j
@RequestMapping("/member")
@RequiredArgsConstructor
public class MemberController {
	
	//생성자 주입
	private final MemberService memberService;
	
	@GetMapping("/")
	public String member(Model model) {
		log.info("-----------------------------");
		String msg = "김대철";
		model.addAttribute("name", msg);
		return "member";
	}
	
	@GetMapping("/list")
	public String list(Model model) {
		List<MemberVO> list = memberService.list();
		model.addAttribute("list",list);
		
		list.forEach(vo -> log.info(vo));
		return "memberList";
	}
	
	@PostMapping("/insert")
	public String insert(MemberVO vo) {

		log.info("----------------------");
		log.info(vo);
		//저장
		memberService.insertMember(vo);
		
		return null;
	}
	
	//delete는 따로 어노테이션이 있음
	@PostMapping("/delete")
	public String delete(int id) {
		
		//삭제
		memberService.deleteMember(id);
		
		return null;
	}
	
	@PostMapping("/update")
	public String update(MemberVO vo) {
		memberService.updateMember(vo);
		
		return null;
	}

}
