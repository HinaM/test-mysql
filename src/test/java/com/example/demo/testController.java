package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;

@AutoConfigureMockMvc
@SpringBootTest 
public class testController {

	@Autowired
	private MockMvc mvc;
	
	@Test
	public void testGet() throws Exception {
		mvc.perform(get("/result?user_name=Ruby&user_password=psd")).andExpect(status().isOk());
	}
}
