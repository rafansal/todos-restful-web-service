package com.todos.rest.webservices.todosrestfulwebservice.controllers;

public class Calculator {

	/**
	* Sum method.
	*/
	public int add(int a, int b) {
	return a + b;
	}
	/**
	* Subtract method.
	*/
	public int subtract(int a, int b) {
	return a - b;
	}

	/**
	* Multiply method.
	*/
	public long multiply(int a, int b) {
	return a * b;
	}

	/**
	* Divide method.
	* Note that this method throws an exception when
	* b is zero.
	*/
	public double divide(int a, int b) {
	double result;
	if (b == 0) {
	throw new IllegalArgumentException("Divisor cannot divide by zero");
	} else {
	result = Double.valueOf(a)/Double.valueOf(b);
	}
	return result;
	}
}
