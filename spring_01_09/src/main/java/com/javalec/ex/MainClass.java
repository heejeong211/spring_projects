package com.javalec.ex;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class MainClass {

	public static void main(String[] args) {
		/*
		 * MyCalculation myCalculator = new MyCalculation();
		 * myCalculator.setCalculation(new Calculation()); // 주입
		 * 
		 * myCalculator.setFirstNum(10); myCalculator.setSecondNum(2);
		 * 
		 * myCalculator.add(); myCalculator.sub(); myCalculator.mul();
		 * myCalculator.div();
		 */

		/*
		 * //스프링 활용 String configLocation = "classpath:appCTX.xml"; //설정파일
		 * AbstractApplicationContext ctx = new
		 * GenericXmlApplicationContext(configLocation); //GenericXmlApplicationContext
		 * = xml을 통해서 읽어오는 IoC 컨테이너(IoC 컨테이너는 이거 말고도 더 있음), 설정파일을 집어 넣고 있음. 다형성 적용
		 * 
		 * MyCalculation myCalculator = ctx.getBean("myCalculator",
		 * MyCalculation.class); //IoC 컨테이너에서 id가 myCalculator인 getBean을 가져오고 있음.
		 * 
		 * myCalculator.add(); myCalculator.sub(); myCalculator.mul();
		 * myCalculator.div();
		 */

		/*
		 * String configLocation = "classpath:appCTX2.xml"; AbstractApplicationContext
		 * ctx = new GenericXmlApplicationContext(configLocation); MyInfo myInfo =
		 * ctx.getBean("myInfo", MyInfo.class); myInfo.getInfo(); ctx.close();
		 */

		/*
		 * String configLocation = "classpath:appCTX3.xml"; AbstractApplicationContext
		 * ctx = new GenericXmlApplicationContext(configLocation); Circle circle =
		 * ctx.getBean("circle", Circle.class); System.out.println(circle.getArea());
		 * ctx.close();
		 */

		
		 String configLocation = "classpath:appCTX4.xml"; 
		 AbstractApplicationContext ctx = new GenericXmlApplicationContext(configLocation); 
		 GradeInfo gradeInfo = ctx.getBean("gradeInfo", GradeInfo.class); 
		 gradeInfo.gradeInfoTest();
		 

	}

}
