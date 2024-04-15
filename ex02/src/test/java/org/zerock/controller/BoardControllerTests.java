package org.zerock.controller;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.ui.ModelMap;
import org.springframework.web.context.WebApplicationContext;
import org.zerock.service.BoardService;

import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"file:src/main/webapp/WEB-INF/spring/root-context.xml", "file:src/main/webapp/WEB-INF/spring/appServlet/servlet-context.xml"})
@Log4j
@WebAppConfiguration
public class BoardControllerTests {
	
	@Autowired
	private BoardService service;
	
	@Autowired
	private WebApplicationContext ctx;
	private MockMvc mockMvc;

	private ModelMap modelMap;
	
	@Before
	public void setup() {
		this.mockMvc = MockMvcBuilders.webAppContextSetup(ctx).build();
	}
	
	
	@Test
	public void testList() throws Exception {
		ModelMap modelMap = mockMvc.perform(
				MockMvcRequestBuilders.get("/board/list"))
				.andReturn()
				.getModelAndView()
				.getModelMap();
			log.info(modelMap);	
	}
	
	@Test
	public void testGet() throws Exception {
		ModelMap modelMap = mockMvc.perform(MockMvcRequestBuilders.get("/board/get")
									.param("bno", "5")) 
		.andReturn()
		.getModelAndView()
		.getModelMap();
		log.info(modelMap);
	}
	
	//post()를 이용하면 POST방식으로 데이터를 전달할 수 있고, param()을 이용해서 전달해야 하는 파라미터들을 지정
		@Test
		public void testRegister() throws Exception {
			String resultPage = mockMvc.perform(MockMvcRequestBuilders.post("/board/register")
					.param("title", "테스트 새글 제목")
					.param("content", "테스트 새글 내용")
					.param("writer", "user00")
					).andReturn().getModelAndView().getViewName();
			log.info(resultPage);
		}
	
		@Test
	public void testListPagging() throws Exception {
		ModelMap modelMap = mockMvc.perform(MockMvcRequestBuilders.get("/board/list")
				.param("pageNum", "2")
				.param("amount", "10"))
				.andReturn().getModelAndView().getModelMap();
		
			log.info(modelMap);
	}

}
