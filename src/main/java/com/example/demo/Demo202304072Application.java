package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.PropertySource;
import org.springframework.jdbc.core.JdbcTemplate;

@SpringBootApplication
@PropertySource("classpath:application.properties")
public class Demo202304072Application {

	static JdbcTemplate jdbcTemplate;
	
	public static void main(String[] args) {
		SpringApplication.run(Demo202304072Application.class, args);
		
		
		System.out.println("test "+ jdbcTemplate);
		
	}

	@Autowired
	public static void setJdbcTemplate( JdbcTemplate setJdbc ) {
		
		jdbcTemplate = setJdbc;
	}
	
}
