package edu.bit.board;

import static org.junit.Assert.*;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import edu.bit.board.HomeController;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(locations={
		"file:src/main/webapp/WEB-INF/spring/root-context.xml",
		"file:src/main/webapp/WEB-INF/spring/appServlet/servlet-context.xml"})

public class HomeControllerTest {

	private MockMvc mockMvc;

	@Before
	public void setUp(){
		this.mockMvc = MockMvcBuilders.standaloneSetup(new HomeController()).build();
	}
		
	@Test
	public void test() throws Exception{
		this.mockMvc.perform(get("/"))
		.andDo(print())                              // .andDO : 
		.andExpect(status().isOk())                 //.andExpect : 
		.andExpect(model().attributeExists("serverTime"))
		.andReturn();                                //.andReturn :
	}


}

