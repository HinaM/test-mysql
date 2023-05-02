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
public class testInsert {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Test
	public void testforInsert() {
		
		String user_name = "TestInsert";
		String user_password = "psd";
		
		String sql_update= "INSERT into user_account (user_name,user_password) VALUES (?,?)";
		int insert = jdbcTemplate.update(sql_update,new Object[] {user_name,user_password});
		
		assertThat(insert).isEqualTo(1);
		
	}
}
