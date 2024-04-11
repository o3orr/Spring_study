package org.zerock.controller2;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import lombok.extern.log4j.Log4j;

@Controller
@RequestMapping("/member/*")
@Log4j
public class MemberController {
	
	@GetMapping("/hello")
	@ResponseBody
	public String hello() {
		return "hello2";
	}

}

// -> localhost:8181/member/hello ===> 