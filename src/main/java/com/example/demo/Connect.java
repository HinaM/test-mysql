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
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;
import java.util.Map;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;


@RestController
public class Connect {

	@Autowired
    private JdbcTemplate jdbcTemplate;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
	}
	
	//LOGIN頁面
	@GetMapping("/index")
	public String helloIndex(){
		return "index";
	}
	//REGISTER頁面
	@GetMapping("/register")
	public ModelAndView helloRegister(){
		ModelAndView model = new ModelAndView("register");
		return model;
	}
	
	@GetMapping("/test")
	public Object TestForOne() {
		
		
		String sql_all = "select * from user_account";
		List<Map<String, Object>> List =  jdbcTemplate.queryForList(sql_all);
		Object element1 = List.get(0).get("user_name");
		
        return element1;
        /*
		String hello = "hello";
        System.out.println(hello);
        return hello;
        */
	}
	
	//添加SQL驗證帳號
	@GetMapping("result")
	public ModelAndView home(@RequestParam(required = false) String user_name,@RequestParam(required = false) String user_password) {
		
		String sql = "select * from user_account where BINARY user_name = ? and BINARY user_password = ?";
		List<Map<String, Object>> list =  jdbcTemplate.queryForList(sql,new Object[] {user_name,user_password});
		int size=list.size();
		
		if (size > 0) {
			Object element1 = list.get(0).get("id");
			Object element2 = list.get(0).get("user_name");
			Object element3 = list.get(0).get("user_password");
			Object element4 = list.get(0).get("authority");

			ModelAndView model = new ModelAndView("hello");
			model.addObject("id", element1);
			model.addObject("name", element2);
			model.addObject("psd", element3);
			model.addObject("authority", element4);
			
			String sql_all = "select * from user_account";
			List<Map<String, Object>> List =  jdbcTemplate.queryForList(sql_all);
			model.addObject("userList", List);
			
			return model;
		}
		else {
			ModelAndView model = new ModelAndView("error");
			return model;
		}
		
	}
	
	@GetMapping("update")
	public ModelAndView updateAccount(@RequestParam String user_name,@RequestParam String user_password) {
		
		String sql = "select * from user_account where BINARY user_name = ?";
		List<Map<String, Object>> list =  jdbcTemplate.queryForList(sql,new Object[] {user_name});
		int size=list.size();
		
		if (user_name.isEmpty() || user_password.isEmpty()) {
			ModelAndView model = new ModelAndView("notnull");
			return model;
		}else if(size>0) {
			ModelAndView model = new ModelAndView("used");
			model.addObject("name", user_name);
			return model;
		}else {
			String default_auth = "user";
			String sql_update= "INSERT into user_account (user_name,user_password,authority) VALUES (?,?,?)";
			jdbcTemplate.update(sql_update,new Object[] {user_name,user_password,default_auth});
			ModelAndView model = new ModelAndView("index");
			return model;
		}
		
	}
	
	@GetMapping("/delete")
	public ModelAndView del(@RequestParam(required = false) String id) {
		
		String sql_del= "DELETE FROM user_account WHERE id=?";
		jdbcTemplate.update(sql_del,id);
		ModelAndView model = new ModelAndView("index");
		return model;
		
	}
	
	@GetMapping("/edit")
	public ModelAndView edit(@RequestParam(required = false) String id) {
		
		String sql = "select * from user_account where id = ?";
		List<Map<String, Object>> list =  jdbcTemplate.queryForList(sql,id);
		Object Id = list.get(0).get("id");
		Object Name = list.get(0).get("user_name");
		Object Psd = list.get(0).get("user_password");
		
		ModelAndView model = new ModelAndView("editinfo");
		model.addObject("list", list);
		model.addObject("id", Id);
		model.addObject("name", Name);
		model.addObject("psd", Psd);
		
		return model;
		
	}
	
	@GetMapping("/EditAndUpload/{id}")
	public ModelAndView editAndUpload(@PathVariable long id,@RequestParam String user_name,@RequestParam String user_password) {
		
		
		if (user_name.isEmpty() || user_password.isEmpty()) {
			ModelAndView model = new ModelAndView("notnull");
			return model;
		}else {
			String sql_edit= "Update user_account set user_name=?, user_password=? where id =?";
			jdbcTemplate.update(sql_edit,new Object[] {user_name,user_password,id});
			ModelAndView model = new ModelAndView("redirect:/");
			return model;
		}
		
	}
	
}
