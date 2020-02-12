package com.javalec.ex;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

public class Student3 implements InitializingBean, DisposableBean{
	
	private String name;
	private String age;
	private String gradeNum;
	private String classNum;
	
	public Student3(String name, String age, String gradeNum, String classNum) {
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
	
	//이 규칙을 만든 이유. 컨테이너에서는 객체의 생성 및 사망을 컨트롤하기 때문...
	@Override
	public void destroy() throws Exception { //객체가 죽을 때 호출됨.
		// TODO Auto-generated method stub
		System.out.println("destroy() 호출"); //이걸 IoC 컨테이너(스프링)가 알아서 호출해줌. 왜 호출될까? implements하면 함수 두개가 오버라이딩 되는데 그걸 실행시키는 것임.
		
	}
	
	public Student3() {
		System.out.println("생성자 호출");
	}

	@Override
	public void afterPropertiesSet() throws Exception { //객체 생성시키고 나서 이게 호출됨.
		// TODO Auto-generated method stub
		System.out.println("afterPropertiesSet() 호출");
	}
	
	
}
