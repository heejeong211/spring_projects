package com.javalec.ex;

import javax.annotation.*;

public class OtherStudent {
	
	private String name;
	private String age;
	private String gradeNum;
	private String classNum;
	
	public OtherStudent() {
		
	}
	
	public OtherStudent(String name, String age, String gradeNum, String classNum) {
		this.name = name;
		this.age = age;
		this.gradeNum = gradeNum;
		this.classNum = classNum;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAge() {
		return age;
	}
	public void setAge(String age) {
		this.age = age;
	}
	public String getGradeNum() {
		return gradeNum;
	}
	public void setGradeNum(String gradeNum) {
		this.gradeNum = gradeNum;
	}
	public String getClassNum() {
		return classNum;
	}
	public void setClassNum(String classNum) {
		this.classNum = classNum;
	}

	
	@PostConstruct
	public void initMethod() {
		System.out.println("initMethod() 호출");
	}
	
	@PreDestroy // implements를 하나 애노테이션을 하나 똑같음 거임. 하지만 이건 안찍힘. 왜냐하면 최신버전이라. 이 애노테이션은 옛날버전임.
	public void destoryMethod() {
		System.out.println("destoryMethod() 호출");
	}
	
}
