package edu.bit.ex;

public class Student {
	
	private String name; // null 초기화 값을 주지 않으면 디폴트로
	private int id; // 0
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
}
