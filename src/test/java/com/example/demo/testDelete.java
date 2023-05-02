package com.example.demo;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;


@SpringBootTest
public class testDelete {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	
	@Test
	public void testforDelete(){
		
		int test_id = 30;
		String sql_delete = "DELETE FROM user_account WHERE id=?";
		
		int deleteTest = jdbcTemplate.update(sql_delete ,test_id);
		
		assertThat(deleteTest).isEqualTo(1);
		
	}
}
