package com.example.demo;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;


@SpringBootTest
public class SQL_connectTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	}
	
	@Autowired
	private JdbcTemplate jdbcTemplate;

	
	public int getCountOfUser() {
		return jdbcTemplate.queryForObject("select count(*) from user_account", Integer.class);
		
    }
	
	///測試資料庫連線
	@Test
	public void testDBConnent() {
		///System.out.println(assertThat(jdbcTemplate).isNotNull());
		///assertThat(getCountOfUser()).isLessThan(100);
		///System.out.println(getCountOfUser());
		if (assertThat(jdbcTemplate).isNotNull() != null) {
			System.out.println("資料庫已連線");
		}else {
			System.out.println("資料庫未連線");
		}
	}
	
    ///
	@Disabled
	@Test
	public void testgetCountOfUser() {
		///System.out.println("共有 "+getCountOfUser()+" 筆資料");
		if (assertThat(getCountOfUser()).isLessThan(100) != null) {
			System.out.println("資料小於100筆，共有 "+getCountOfUser()+" 筆資料");
		}else {
			System.out.println("資料大於100筆，共有 "+getCountOfUser()+" 筆資料");
		}
	}
	
	@Disabled
	@Test
	public void testInsert() {
		
		String user_name = "TestInsert";
		String user_password= "psd";
		
		String sql_update= "INSERT into user_account (user_name,user_password) VALUES (?,?)";
		int insert = jdbcTemplate.update(sql_update,new Object[] {user_name,user_password});
		
		if (insert == 1) {
			System.out.println("帳號:" + user_name + " 有寫入，密碼是: " + user_password);
		}else {
			System.out.println("沒有寫入");
		}
	}
}
