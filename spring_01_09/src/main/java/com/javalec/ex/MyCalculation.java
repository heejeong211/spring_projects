package com.javalec.ex;

public class MyCalculation {
	
	Calculation calculator;
	private int firstNum;
	private int secondNum;
	
	public MyCalculation() {
		
	}
	
	public Calculation getCalculator() {
		return calculator;
	}

	public void setCalculator(Calculation calculator) {
		this.calculator = calculator;
	}

	public int getFirstNum() {
		return firstNum;
	}

	public void setFirstNum(int firstNum) {
		this.firstNum = firstNum;
	}

	public int getSecondNum() {
		return secondNum;
	}

	public void setSecondNum(int secondNum) {
		this.secondNum = secondNum;
	}

	public void add() {
		calculator.addition(firstNum, secondNum);
	}
	
	public void sub() {
		calculator.subtraction(firstNum, secondNum);
	}
	
	public void mul() {
		calculator.multiplication(firstNum, secondNum);
	}
	
	public void div() {
		calculator.division(firstNum, secondNum);
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
