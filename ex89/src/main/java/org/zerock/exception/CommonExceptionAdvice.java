package org.zerock.exception;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import lombok.extern.log4j.Log4j;

//예외처리 어노테이션
//모든 예외가 발생하면 여기로 옴
@ControllerAdvice
@Log4j
public class CommonExceptionAdvice {
	
	@ExceptionHandler
	public String except(Exception ex, Model model) {
		
		log.error("Exception" + ex.getMessage());
		model.addAttribute("exception", ex);
		log.error(model);
		
		return "error_page";
	}
}
