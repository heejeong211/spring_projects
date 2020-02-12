package com.javalec.ex;

public class Circle {
	
	private double r;
	private Circle circle;
	
	public double getArea() {
		return Math.PI * r * r;
	}
	
	public Circle getCircle() {
		return circle;
	}

	public void setCircle(Circle circle) {
		this.circle = circle;
	}

	public double getR() {
		return r;
	}

	public void setR(double r) {
		this.r = r;
	}
	
	

}
