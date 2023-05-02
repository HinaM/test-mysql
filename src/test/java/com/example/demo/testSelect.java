package com.example.demo;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import java.util.Map;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;


@SpringBootTest
public class testSelect {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	
	@Test
	public void testforUpdate(){
		
		String test_name=" ";
		String test_password=" ";
		
		String sql = "SELECT * FROM user_account WHERE user_name=? and user_password=?";
		List<Map<String, Object>> list =  jdbcTemplate.queryForList(sql,new Object[] {test_name,test_password});
		int size=list.size();
		
		assertThat(size).isNotEqualTo(0);
		
	}
}
