package org.zerock.controller;

import java.io.InputStream;
import java.lang.reflect.Array;
import java.util.ArrayList;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.zerock.domain.SampleDTO;
import org.zerock.domain.TodoDTO;

import com.google.gson.Gson;

import lombok.extern.log4j.Log4j;

@Controller
@RequestMapping("/sample/*")
@Log4j
public class SampleController {

	@RequestMapping("")
	public void basic() {
		log.info("basic.........");
	}

	// 경로 똑같은데 get 요청오면 이 메서드 호출
	@RequestMapping(value = "/basic", method = RequestMethod.GET)
	public void basicGetPost() {
		log.info("basic get .................");
	}

	@RequestMapping(value = "/basic", method = RequestMethod.POST)
	public void basicGetPost2() {
		log.info("basic post.................");
	}

	@GetMapping("/basic2")
	public void basicGet2() {
		log.info("basic get2");
	}

	@PostMapping("/basic2")
	public void basicPost2() {
		log.info("basic post2");
	}

	@GetMapping("/ex01")
	public String ex01(SampleDTO dto) {
		log.info(dto);
		return "ex01";
	}

	@PostMapping("/ex01")
	public String ex01_(SampleDTO dto) {
		log.info(dto);
		return "ex01";
	}

	
	
	@GetMapping("/ex02")
	public String ex02(@RequestParam("name") String name, @RequestParam("age") int age) {
		log.info(name);
		log.info(age);
		return "ex02";
	}
	
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
	
	
	@GetMapping("/ex04")
	public String ex04(SampleDTO dto, int page, Model model) {
		log.info(dto);
		log.info(page);
		
		model.addAttribute("sample", dto);
		model.addAttribute("page", page);
		
		return "/sample/ex04";
	}
	
	@GetMapping("/ex05")
	public void ex05() {
		log.info("ex05");
	}
	
	
	@GetMapping("/ex06")
	@ResponseBody
	public SampleDTO ex06() {
		SampleDTO sampleDTO = new SampleDTO();
		
		sampleDTO.setName("aaa");
		sampleDTO.setAge(100);
		return sampleDTO;
	}
	
	
	
	@GetMapping("/ex08")
	public ResponseEntity<String> ex08() {
		log.info("ex08");
		
		SampleDTO dto = new SampleDTO();
		dto.setName("홍길동");
		dto.setAge(49);
		
		Gson gson = new Gson();
		String json = gson.toJson(dto);
		
		HttpHeaders headers = new HttpHeaders();
		headers.add("content-Type", "application/json; charset=utf-8");
		
		return new ResponseEntity<String>(json, headers, HttpStatus.ACCEPTED);
	}
	
	@GetMapping("/exUpload")
	public void exUpload() {
		log.info("/exUpload");
	}
	
	@PostMapping("/exUploadPost")
	public void exUploadPost(ArrayList<MultipartFile> files) {
		files.forEach(file -> {
			log.info("------------------------------------");
			log.info("name : " + file.getOriginalFilename());
			log.info("size : " + file.getSize());
		});
	}

}
