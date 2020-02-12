package com.javalec.ex;

public class Grade {
	
	private int a;
	private int b;
	private int c;
	private int d;
	
	public void grade(int num) {
		if(num>=a) {
			System.out.println("수");
		} else if(num>=b) {
			System.out.println("우");
		} else if(num>=c) {
			System.out.println("미");
		} else if(num>d) {
			System.out.println("양");
		} else {
			System.out.println("가");
		}
	}
	
	
	public int getA() {
		return a;
	}
	public void setA(int a) {
		this.a = a;
	}
	public int getB() {
		return b;
	}
	public void setB(int b) {
		this.b = b;
	}
	public int getC() {
		return c;
	}
	public void setC(int c) {
		this.c = c;
	}
	public int getD() {
		return d;
	}
	public void setD(int d) {
		this.d = d;
	}
	
	
}
