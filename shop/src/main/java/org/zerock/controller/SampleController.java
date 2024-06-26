package org.zerock.controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;

import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.zerock.domain.SampleDTO;
import org.zerock.domain.TodoDTO;

import com.google.gson.Gson;

import lombok.extern.log4j.Log4j;

@Controller
//@RestController -> @Controller + @ResponseBody
@RequestMapping("/sample/*")
@Log4j
public class SampleController {
	
	//웹에서 날짜처리하는 방법
//	@InitBinder
//	public void initBinder(WebDataBinder binder) {
//		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-mm-dd");
//		binder.registerCustomEditor(java.util.Date.class, new CustomDateEditor(dateFormat, false));
//	}
	
	
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
	
	
	
	//INFO : org.zerock.controller.SampleController - SampleDTO(name=aaa, age=20)
	@GetMapping("/ex01")
	public String ex01(SampleDTO dto) {
		log.info(dto);
		return "ex01";
	}
	
	// INFO : org.zerock.controller.SampleController - SampleDTO(name=aaa, age=20)
	@PostMapping("/ex01")
	public String ex01_(SampleDTO dto) {
		log.info(dto);
		return "ex01";
	}
	
	
	//INFO : org.zerock.controller.SampleController - aaa
	//INFO : org.zerock.controller.SampleController - 20
	@GetMapping("/ex02")
	public String ex02(@RequestParam("name") String name, @RequestParam("age") int age) {
		log.info(name);
		log.info(age);
		return "ex02";
	}
	
//	INFO : org.zerock.controller.SampleController - aaa
//	INFO : org.zerock.controller.SampleController - 20
	@PostMapping("/ex02")
	public String ex02_(@RequestParam("name") String name, @RequestParam("age") int age) {
		log.info(name);
		log.info(age);
		return "ex02";
	}
	
	
	
	@GetMapping("/ex03")
	public String ex03(TodoDTO dto) {
		log.info(dto);
		log.info(dto.getTitle());
		log.info(dto.getDueDate());
		
		return "ex03";
	}
	
	
	// 모델에 담아서 보내는 방식 -> forward 방식
	@GetMapping("/ex04")
	public String ex04(SampleDTO dto, int page, Model model) {
		log.info(dto);
		log.info(page);
		
		model.addAttribute("sample", dto);
		model.addAttribute("page", page);
		
		return "/sample/ex04";
	}
	
	
	// 리다이렉트 방식
	@GetMapping("/ex044")
	public String ex04_(@RequestParam("name2") String name2, @RequestParam("age2") int age2, RedirectAttributes rttr) {
		
		rttr.addFlashAttribute("age2", age2);
		
		return "redirect:/sample/ex01";
	}
	
	
	// sample/ex05인 경로의 반환 타입이 void(뷰 경로 지정해주지 않음)
	// -> jsp파일 경로가 sample/ex05.jsp
	@GetMapping("/ex05")
	public void ex05() {
		log.info("ex05");
	}
	
	
	
	//@ResponseBody 자바 객체를 json타입으로 변환시켜서 클라이언트에 응답 ->  jackson Databind 사용
	@GetMapping("/ex06") 
	@ResponseBody 
	public SampleDTO ex06() {
		SampleDTO sampleDTO = new SampleDTO();
		
		sampleDTO.setName("aaaa");
		sampleDTO.setAge(100);
		return sampleDTO;
	}
	
	
	//@requestBody // JSON 값을 java객체로 변환해서 dto에 전달
	@GetMapping("/ex066")
	public String ex066(@RequestBody SampleDTO dto) {
		log.info("-------ex066");
		log.info(dto.getName());
		log.info(dto.getAge());
		log.info(dto);
		
		return "ex066";
	}
	
	
	
	// json + 상태코드값(200, 300, 404, 500)
	@GetMapping("/ex07")
	public ResponseEntity<String> ex07() {
		log.info("ex07..........");
		
		//{"name" : "홍길동"}
		String msg = "{\"name\" : \"홍길동\"}";
		
		HttpHeaders headers = new HttpHeaders();
		headers.add("content-Type", "application/json; charset=utf-8");
		
		return new ResponseEntity<String>(msg, headers, HttpStatus.ACCEPTED); 
	}
	

	//java 객체를 gson을 이용해서 json타입으로 변환한 다음 전송
	@GetMapping("/ex08")
	public ResponseEntity<String> ex08() {
		log.info("ex08..........");
		
		//{"name" : "홍길동"}
		String msg = "{\"name\" : \"홍길동\"}";
		
		SampleDTO dto = new SampleDTO();
		dto.setName("홍길동");
		dto.setAge(49);
		
		//Gson으로 간단하게 변환
		Gson gson = new Gson();
		String json = gson.toJson(dto);
		
		
		HttpHeaders headers = new HttpHeaders();
		headers.add("content-Type", "application/json; charset=utf-8");
		
		return new ResponseEntity<String>(msg, headers, HttpStatus.ACCEPTED); 
	}
	
	@GetMapping("/exUpload")
	public void exUpload() {
		log.info("/exUpload");
	}
	
	@PostMapping("/exUploadPost")
	public void exUploadPost(ArrayList<MultipartFile> files) {
		files.forEach(file -> {
			log.info("-----------------------------");
			log.info("name : " + file.getOriginalFilename());
			log.info("size : " + file.getSize());
		});
	}
	

}
