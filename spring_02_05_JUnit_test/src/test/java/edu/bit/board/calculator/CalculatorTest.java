package edu.bit.board.calculator;

import static org.junit.Assert.*;

import org.junit.Test;

public class CalculatorTest {

	//assertArrayEquals(a, b);
	//- �迭 A�� B�� ��ġ���� Ȯ���Ѵ�.
	
	//assertEquals(a, b);
	//- ��ü A�� B�� ���� ��ü���� Ȯ���Ѵ�.
	
	//assertTure(a);
	//- ���� A�� ������ Ȯ���Ѵ�.
	
	//assertSame(a, b);
	//- �� ��ü �ּҰ��� ������ Ȯ���Ѵ�.
	
	@Test
	public void testSum() {
		Calculator cal = new Calculator();
		int result = cal.sum(10, 20);
		assertEquals(20, result, 10);
	}
	
	@Test
	public void testSub() {
		//assertEquals(a, b, c);
		//- ��ü A�� B�� ��ġ���� Ȯ���Ѵ�.
		//- a: ���� , b: ����� , c: �������� 
		Calculator cal = new Calculator();
		int result = cal.sub(10, 20);
		assertEquals(-10, result, 10);
	}

}
