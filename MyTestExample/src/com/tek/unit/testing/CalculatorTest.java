package com.tek.unit.testing;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;

import org.junit.Test;

public class CalculatorTest {
	

	@Test
	public void testadd() {
		Calculator calc=new Calculator();
		int result=calc.add(2, 3);
		assertEquals(5,result);
		
				
	}
	@Test
	public void testdivide()
	{
		Calculator calc=new Calculator();
		assertEquals(2, calc.divide(6, 3));
	}
	@Test
	public void test_dividebyzero()
	{
		Calculator calc =new Calculator();
		assertThrows(IllegalArgumentException.class , ()->{
			calc.divide(4, 0);
		});
	}

}
