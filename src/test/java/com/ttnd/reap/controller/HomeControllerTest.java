package com.ttnd.reap.controller;

import static org.springframework.test.web.servlet.setup.MockMvcBuilders.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import org.junit.Test;
import org.springframework.test.web.servlet.MockMvc;

public class HomeControllerTest {

	@Test
	public void testHome() throws Exception{
		HomeController controller=new HomeController();
		MockMvc mockMvc=standaloneSetup(controller).build();
		mockMvc.perform(get("/")).andExpect(view().name("home"));
		
	}

}
