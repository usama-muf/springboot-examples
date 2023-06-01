package com.usama.junit_demo.bank;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Calculate Method Tests")
@ExtendWith(CalculateMethodParameterResolver.class)
public class CalculateMethodTest {

	@Test
	@DisplayName("Divide by Zero")
	public void divideByZeroTest(CalculateMethods calculateMethods) {
		assertThrows(ArithmeticException.class, ()-> calculateMethods.divide(10, 0));
		
	}

}
