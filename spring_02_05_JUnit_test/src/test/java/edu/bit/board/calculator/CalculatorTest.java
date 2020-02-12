package edu.bit.board.calculator;

import static org.junit.Assert.*;

import org.junit.Test;

public class CalculatorTest {

	//assertArrayEquals(a, b);
	//- 배열 A와 B가 일치함을 확인한다.
	
	//assertEquals(a, b);
	//- 객체 A와 B가 같은 객체임을 확인한다.
	
	//assertTure(a);
	//- 조건 A가 참인지 확인한다.
	
	//assertSame(a, b);
	//- 두 객체 주소값이 같은지 확인한다.
	
	@Test
	public void testSum() {
		Calculator cal = new Calculator();
		int result = cal.sum(10, 20);
		assertEquals(20, result, 10);
	}
	
	@Test
	public void testSub() {
		//assertEquals(a, b, c);
		//- 객체 A와 B가 일치함을 확인한다.
		//- a: 예상값 , b: 결과값 , c: 오차범위 
		Calculator cal = new Calculator();
		int result = cal.sub(10, 20);
		assertEquals(-10, result, 10);
	}

}
