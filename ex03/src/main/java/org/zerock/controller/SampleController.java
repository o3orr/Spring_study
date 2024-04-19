package org.zerock.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.zerock.domain.SampleVO;

import lombok.extern.log4j.Log4j;

//@Controller
@RestController // @Controller + @ResponseBody
@Log4j
@RequestMapping("/sample")
public class SampleController {
	
	@GetMapping(value = "getText", produces = "text/plain; charset=utf-8")
	@ResponseBody //jsp페이지가 아니라 값만 전달받고 싶음
	public String getText() {
		log.info("MIME TYPE : " + MediaType.TEXT_PLAIN_VALUE);
		
		return "안녕하세요";
	}
	
	
	@GetMapping(value = "/getSample", produces = MediaType.APPLICATION_JSON_VALUE)
	public SampleVO getSample() { //자바 객체가 xml형태로 넘어감
		//그냥 요청하면 xml, .json붙이면 json 방식으로
		return new SampleVO(111, "스타", "로드");
	}
	
	
	
	@GetMapping(value = "/getSample2")
	public SampleVO getSample2() { 
		return new SampleVO(111, "스타2", "로드2");
	}
	
	
	
	@GetMapping(value = "/getList", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<SampleVO> getList() { 
		
//		List<SampleVO> list = new ArrayList<SampleVO>();
//		
//		for(int i=1; i<10; i++) {
//			SampleVO vo = new SampleVO(i, i+"Frist", i+ "List");
//			list.add(vo);
//		}
//		
//		return list;
//		밑에랑 똑같음
		
		return IntStream.range(1, 10).mapToObj(i -> new SampleVO(i, i+ "Frist", i+ "List"))
				.collect(Collectors.toList());
	}
	
	
	
	@GetMapping(value = "/getMap", produces = MediaType.APPLICATION_JSON_VALUE)
	public Map<String, SampleVO> getMap() {
		Map<String, SampleVO> map = new HashMap<String, SampleVO>();
		
		map.put("First", new SampleVO(111, "그루트", "주니어"));
		
		return map;
	}
	
	@GetMapping(value = "/getMap2", produces = MediaType.APPLICATION_JSON_VALUE)
	public Map<String, String> getMap2() {
		Map<String, String> map = Map.of("name", "park", "age", "20");
		
		return map;
	}
	
	
	
	
	@GetMapping(value = "/check", params = {"height", "weight"}, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<SampleVO> check(Double height, Double weight) {// 상태코드
		SampleVO vo = new SampleVO(0, "" + height, ""+ weight); //""붙이면 문자열로 인식
		
		ResponseEntity<SampleVO> result = null;
		
		if(height < 150) {
			result = ResponseEntity.status(HttpStatus.BAD_GATEWAY).body(vo);
		} else {
			result = ResponseEntity.status(HttpStatus.OK).body(vo);
		}
		
		return result;
	}
	
	//localhost:8181/product/조운/50
	//
	@GetMapping(value = "/product/{name}/{age}" , produces = MediaType.APPLICATION_JSON_VALUE)
	public String[] getPath(
			@PathVariable("name") String name, //조운
			@PathVariable("age") Integer age   //50
			) {
		return new String[] {"name; " + name, "age : " + age};
	}

	
	
	@PostMapping(value = "/ticket", produces = MediaType.APPLICATION_JSON_VALUE)
	public SampleVO convert(@RequestBody SampleVO vo) {
		log.info("=============>>" + vo);
		return vo;
	}

}
