package com.usama.mockito_demo;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;


@ExtendWith(MockitoExtension.class)
public class CalculatorTest {

	private Calculator c;
	
	@BeforeEach
	public void inti() {
		c = new Calculator();
	}
	
	@Mock
	private Calculator calculator;
	
	@Test
	public void testSquare() {
		when(calculator.squreInteger(-3)).thenReturn(9);
		int ans = calculator.squreInteger(-3);
		assertEquals(9, ans);
	}

	@Test
	public void upperBoundaryTest() {
//		Calculator c = new Calculator();
		assertThrows(RuntimeException.class, () -> c.squreInteger(Integer.MAX_VALUE));
	}

	@Test
	public void lowerBoundaryTest() {
//		Calculator c = new Calculator();
		assertThrows(RuntimeException.class, () -> c.squreInteger(Integer.MIN_VALUE));
	}
	
	@Test
	public void squaredIntegerNullValueTest() {
		
//		Calculator c = new Calculator();
		assertThrows(NullPointerException.class, ()-> c.squreInteger(null));
	}
	
	@Test
	public void squaredIntegerNAN() {
		System.out.println(Math.sqrt(-12));
		assertThrows(RuntimeException.class, ()-> c.squreInteger((int) Math.sqrt(-12)));
	}

}
