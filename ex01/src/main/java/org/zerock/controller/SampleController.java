package org.zerock.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import lombok.extern.log4j.Log4j;

@Controller
@RequestMapping("/sample/*")
@Log4j
public class SampleController {
	
	@RequestMapping("")
	public void basic() {
		log.info("basic..................");
		
	}
	
	//경로똑같은데 get 요청이 오면 이 메서드 호출
	@RequestMapping(value = "/basic", method = RequestMethod.GET)
	public void basicGetPost() {
		log.info("basic get.............");
	}
	
	//경로똑같은데 post 요청이 오면 이 메서드 호출
	@RequestMapping(value = "/basic", method = RequestMethod.POST)
	public void basicGetPost2() {
		log.info("basic post.............");
	}
	
	@GetMapping("/basic2")
	public void basicGet2() {
		log.info("basic post2.............");
	}
	
	@PostMapping("/basic2")
	public void basicPost2() {
		log.info("basic post2.............");
	}

}
