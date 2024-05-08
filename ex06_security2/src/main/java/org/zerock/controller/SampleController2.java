package org.zerock.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.extern.log4j.Log4j;

@RequestMapping("/sample")
@Log4j
@Controller
public class SampleController2 {

	@GetMapping("/all")
	public void doAll() {
		log.info("All"); //회원가입 하지않아도 아무나
	}
	
	
	//회원만
	@GetMapping("/member")
	public void doMember() {
		log.info("member");
	}
	
	//관리자만
	@GetMapping("/admin")
	public void doAdmin() {
		log.info("admin");
	}
}
