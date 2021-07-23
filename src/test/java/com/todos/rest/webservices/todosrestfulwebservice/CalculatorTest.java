package com.todos.rest.webservices.todosrestfulwebservice;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import com.todos.rest.webservices.todosrestfulwebservice.controllers.Calculator;
@SpringBootTest
class CalculatorTest {

	Calculator objCalcUnderTest = new Calculator();

	@BeforeClass
	public void before() {
		System.out.println("before Method Begins");
		System.out.println("before Method ends");
	}
	
	@Test
	public void testAdd() {
		System.out.println("testAdd Method Begins");
		int a = 15;
		int b = 20;
		int expectedResult = 35;
		// Act
		long result = objCalcUnderTest.add(a, b);
		// Assert
		Assert.assertEquals(expectedResult, result);
		System.out.println("testAdd Method Ends");
	}

	@Test
	public void testSubtract() {
		System.out.println("testSubtract Method Begins");
		int a = 25;
		int b = 20;
		int expectedResult = 5;
		long result = objCalcUnderTest.subtract(a, b);
		Assert.assertEquals(expectedResult, result);
		System.out.println("testSubtract Method Ends");
	}

	@Test
	public void testMultiply() {
		System.out.println("testMultiply Method Begins");
		int a = 10;
		int b = 25;
		long expectedResult = 250;
		long result = objCalcUnderTest.multiply(a, b);
		Assert.assertEquals(expectedResult, result);
		System.out.println("testMultiply Method Ends");
	}

	@Test
	public void testDivide() {
		System.out.println("testDivide Method Begins");
		int a = 56;
		int b = 10;
		double expectedResult = 5.6;
		double result = objCalcUnderTest.divide(a, b);
		Assert.assertEquals(expectedResult, result, 0.00005);
		System.out.println("testDivide Method Ends");
	}
}
