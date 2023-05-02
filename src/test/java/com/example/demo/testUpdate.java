package com.example.demo;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;


@SpringBootTest
public class testUpdate {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	
	@Test
	public void testforUpdate(){
		
		int test_id = 27;
		String test_name="User";
		String test_password="Psd";
		
		String sql_update = "Update user_accountId set user_name=?, user_password=? where id =?";
		
		int updateTest = jdbcTemplate.update(sql_update ,new Object[] {test_name,test_password,test_id});
		
		assertThat(updateTest).isEqualTo(1);
		
	}
}
