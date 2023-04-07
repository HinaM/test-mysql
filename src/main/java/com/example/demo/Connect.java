package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;


@RestController
@RequestMapping("/user")
public class Connect {
	
	@GetMapping("/get-users")
	public String helloIndex(){
		return "index";
	}
	/*    
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@GetMapping("/get-users")
	public List<Map<String, Object>> getUserList(String testName){
		
		String sql = "select * from user_account";
		
		List<Map<String, Object>> list =  jdbcTemplate.queryForList(sql);
		
		return list;
		
		
	}
	*/
	
}

