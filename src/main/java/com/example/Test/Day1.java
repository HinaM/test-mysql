package com.example.Test;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import static org.assertj.core.api.Assertions.assertThat;
import org.assertj.core.api.SoftAssertions;


public class Day1 {
	/*
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
 	
	@Test
    public void TestOutput1() {
        System.out.println("Test Output 1");
    }
	
	@Test
    public void TestOutput2() {
        System.out.println("Test Output 2");
    }
	*/
	/*
	///執行順序
	@BeforeClass
    public static void beforeClass() {
        System.out.println("before class");
    }
    @Before
    public void before() {
        System.out.println("before");
    }

    @After
    public void after() {
        System.out.println("after");
    }

    @AfterClass
    public static void afterClass() {
        System.out.println("after class");
    }

    @Test
    public void CaseOne() {
        System.out.println("test case 1");
    }

    @Test
    public void CaseTwo() {
        System.out.println("test case 2");
    }
	*/
	
	
	///AssertJ
	public class Calculator {

	    public int add(int number1, int number2) {
	        return number1 + number2;
	    }
	}
	
	@Ignore
	@Test
    public void add_5_and_10_return_15() {
        // 1. Arrange
        Calculator calculator = new Calculator();
        int number1 = 5;
        int number2 = 10;
        int excepted = 15;

        // 2. Act
        int actual = calculator.add(number1, number2);

        // 3. Assert
        assertThat(actual).isEqualTo(excepted);
    }
	
	
	///Hard Assertions-->只會執行到5<4
	@Ignore
	@Test
    public void testHardAssertion() {
        int actual1 = 5;

        String actual2 = "10";

        assertThat(actual1).isLessThan(4);

        assertThat(actual2).isEqualTo("11");
    }
	
	@Ignore
	@Test
    public void testSoftAssertion() {

        int actual1 = 5;
        String actual2 = "10";

        SoftAssertions softAssertions = new SoftAssertions();

        softAssertions.assertThat(actual1).isLessThan(4);

        softAssertions.assertThat(actual2).isEqualTo("11");

        softAssertions.assertAll();
    }
	
}
