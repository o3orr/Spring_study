package org.zerock.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.zerock.domain.BoardVO;
import org.zerock.service.BoardService;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j;

@Controller
@Log4j
@RequiredArgsConstructor
@RequestMapping("/board/*")
public class BoardController {
	
	private final BoardService boardService;
	
	@GetMapping("/list")
	public void list(Model model) {
		
		model.addAttribute("list", boardService.getList()); //views/board/list.jsp
	}
	
	@PostMapping("/register")
	public String register(BoardVO board, RedirectAttributes rttr) {
		log.info("register");
		boardService.register(board);
		
		rttr.addFlashAttribute("result", board.getBno());
		//list페이지로 다시이동
		return "redirect:/board/list";
	}
	
	@GetMapping("/get")
	public void get(@RequestParam("bno") long bno, Model model) {
		log.info("get");
		model.addAttribute("board", boardService.get(bno));
		
	}
	
	@PostMapping("/modify")
	public String modify(BoardVO board, RedirectAttributes rttr) {
		log.info("modify");
		if(boardService.modify(board)) { //board입력받아서 수정성공하면 true, 실패하면 false
			rttr.addFlashAttribute("result", board.getBno());
		}
		
		return "redirect:/board/list";
	}
	
	@PostMapping("/remove")
	public String remove(@RequestParam("bno") Long bno, RedirectAttributes rttr) {
		log.info("remove");
		
		if(boardService.remove(bno)) {
			rttr.addFlashAttribute("result", "success");
		}
		
		return "redirect:/board/list";
	}
	
	
}
