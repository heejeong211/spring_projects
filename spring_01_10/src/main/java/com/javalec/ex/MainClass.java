package com.javalec.ex;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class MainClass {

	public static void main(String[] args) {
		
		/*
		 * String configLocation = "classpath:appCTX.xml"; 
		 * AbstractApplicationContext ctx = new GenericXmlApplicationContext(configLocation); 
		 * StudentInfo studentInfo = ctx.getBean("studentInfo", StudentInfo.class);
		 * studentInfo.getStudentInfo();
		 * 
		 * Student student2 = ctx.getBean("student2", Student.class);
		 * studentInfo.setStudent(student2); studentInfo.getStudentInfo();
		 */
		
		/*
		 * String configLocation = "classpath:appCTX2.xml"; 
		 * AbstractApplicationContext ctx = new GenericXmlApplicationContext(configLocation); 
		 * Pencil pencil = ctx.getBean("pencil", Pencil.class); //이렇게 들어올 수 있는 이유. 다형성이 적용되었기 때문에
		 * pencil.use();
		 */
		
		/*
		 * //뒤에 Context가 붙여서 IoC컨테이너임. 
		 * AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(AppConfig.class); 
		 * Student2 student1 = ctx.getBean("student1", Student2.class); 
		 * System.out.println("이름 : " + student1.getName()); 
		 * System.out.println("나이 : " + student1.getAge());
		 * System.out.println("취미 : " + student1.getHobbys());
		 * System.out.println("신장 : " + student1.getHeight());
		 * System.out.println("몸무게 : " + student1.getWeight());
		 * 
		 * System.out.println("============================");
		 * 
		 * Student2 student2 = ctx.getBean("student2", Student2.class);
		 * System.out.println("이름 : " + student2.getName()); 
		 * System.out.println("나이 : " + student2.getAge()); 
		 * System.out.println("취미 : " + student2.getHobbys());
		 * System.out.println("신장 : " + student2.getHeight());
		 * System.out.println("몸무게 : " + student2.getWeight());
		 * 
		 * System.out.println("============================");
		 * 
		 * Rectangle rec = ctx.getBean("rectangle", Rectangle.class);
		 * System.out.println("넓이 : " + rec.getArea());
		 */
		
		/*
		 * GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
		 * 
		 * //GenericXmlApplicationContext("classpath:appCTX3.xml"); 이런 식으로 다이렉트로 넣게 되면 이 친구와 이 밑에 친구 필요없음 
		 * ctx.load("classpath:appCTX3.xml"); ctx.refresh();
		 * 
		 * System.out.println("ctx.close() 호출전"); ctx.close();
		 * System.out.println("ctx.close() 호출후");
		 */
		GenericXmlApplicationContext ctx = new GenericXmlApplicationContext("classpath:appCTX4.xml");
		
		Student4 student1 = ctx.getBean("student", Student4.class); //만약 주소 값이 100인 곳에 홍길순과 80이 저장. student1은 주소값을 100가지고 있음.
		System.out.println("이름 : " + student1.getName()); 
		System.out.println("나이 : " + student1.getAge());
		
		System.out.println("============================");
		
		Student4 student2 = ctx.getBean("student", Student4.class); //ctx가 getBean해서 가져온 student2의 주소값은 100임. 그 상테에서 홍길자, 100으로 바꿈.
		student2.setName("홍길자");
		student2.setAge("100");
		System.out.println("이름 : " + student2.getName()); 
		System.out.println("나이 : " + student2.getAge());
		
		System.out.println("============================");
		
		System.out.println("이름 : " + student1.getName()); //이미 100주소값에 저장되있는 객체는 홍길자, 100이라서 이렇게 나옴. => 이렇게 나오는 이유, scope가 singleton이라서
		System.out.println("나이 : " + student1.getAge());
		
		System.out.println("============================");
		
		if(student1.equals(student2)) { // student1과 student2의 주소값이 같냐? 틀리냐?
			System.out.println("student1 == student2");
		} else {
			System.out.println("student1 != student2");
		}
	}
	
}
