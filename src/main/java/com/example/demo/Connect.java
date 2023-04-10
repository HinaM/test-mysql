/*
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
	    
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@GetMapping("/get-users")
	public int getUserList(String testName){
		
		
		String sql = "SELECT * FROM user_account";
		List<Map<String, Object>> list =  jdbcTemplate.queryForList(sql);
		
		int size=list.size();
		return size;
		
		
	}
	
}
*/
package com.example.demo;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;


@RestController
public class Connect {

	@Autowired
    private JdbcTemplate jdbcTemplate;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
	}
	
	@GetMapping("/index")
	public String helloIndex(){
		return "index";
	}
	
	//添加SQL驗證帳號

	@GetMapping("result")
	public int home(@RequestParam(required = false) String user_name,@RequestParam(required = false) String user_password) {
		
		String sql = "select * from user_account where user_name = ? and user_password = ?";
		///String sql = "select * from user_account";
		///List<Map<String, Object>> list =  jdbcTemplate.queryForList(sql);
		List<Map<String, Object>> list =  jdbcTemplate.queryForList(sql,new Object[] {user_name,user_password});
		
		int size = list.size();
		/*
		if (size > 0) {
			
			ModelAndView model = new ModelAndView("hello");
			model.addObject("name", user_name);
			model.addObject("psd", user_password);
			return model;
			
			
		}else {
			
			ModelAndView model = new ModelAndView("error");
			return model;
		
		}
		*/
		return size;
		
	}
}
