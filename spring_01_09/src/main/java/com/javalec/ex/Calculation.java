package com.javalec.ex;

public class Calculation {
	
	public void addition(int f, int s) {
		System.out.println("addition()");
		int result = f + s;
		System.out.println(f + " + " + s + " = " + result);
	}
	
	public void subtraction(int f, int s) {
		System.out.println("subtraction()");
		int result = f - s;
		System.out.println(f + " - " + s + " = " + result);
	}
	
	public void multiplication(int f, int s) {
		System.out.println("multiplication()");
		int result = f * s;
		System.out.println(f + " * " + s + " = " + result);
	}
	
	public void division(int f, int s) {
		System.out.println("division()");
		int result = f / s;
		System.out.println(f + " / " + s + " = " + result);
	}
	
	/*
	 * public int getFirstNum() { return firstNum; }
	 * 
	 * public void setFirstNum(int firstNum) { this.firstNum = firstNum; }
	 * 
	 * public int getSecondNum() { return secondNum; }
	 * 
	 * public void setSecondNum(int secondNum) { this.secondNum = secondNum; }
	 */
	
	
}
