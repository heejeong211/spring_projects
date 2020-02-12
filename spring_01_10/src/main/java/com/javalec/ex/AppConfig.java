package com.javalec.ex;

import java.util.ArrayList;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {
	
	@Bean
	public Student2 student1() { // 함수 이름(= id값)으로 치고 들어옴.
		ArrayList<String> hobbys = new ArrayList<String>();
		hobbys.add("수영");
		hobbys.add("요리");
		
		Student2 student = new Student2("홍길동", "20살", hobbys);
		student.setHeight(180);
		student.setWeight(80);
		
		return student;
		
	}
	
	@Bean
	public Student2 student2() {
		ArrayList<String> hobbys = new ArrayList<String>();
		hobbys.add("노래");
		hobbys.add("드라마");
		
		Student2 student = new Student2("동동이", "20살", hobbys);
		student.setHeight(180);
		student.setWeight(80);
		
		return student;
	}
	
	@Bean
	public Rectangle rectangle() {
		
		Rectangle rectangle = new Rectangle(5, 4);
		
		return rectangle;
	}
	
}
