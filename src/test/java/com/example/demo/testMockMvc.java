package com.example.demo;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@AutoConfigureMockMvc// <--
@SpringBootTest    
public class testMockMvc {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	@Autowired
    private MockMvc mockMvc;

    @Test
    void hello_ReturnHello() throws Exception {
    	
    	String passedName="Ruby";
    	String passedPsd="psd";
    	
    	String testString = "Test";
    	
    	String responseString = mockMvc.perform(get("/result?user_name=" + passedName + "&user_password=" + passedPsd))
                .andExpect(status().isOk())
                .andDo(print())
                .andReturn().getResponse().getContentAsString();
    	
    	assertThat(responseString).contains(testString);
    }

}
