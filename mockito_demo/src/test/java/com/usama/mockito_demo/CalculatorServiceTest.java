package com.usama.mockito_demo;

import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;


@ExtendWith(MockitoExtension.class)
public class CalculatorServiceTest {

	@Mock 
	Calculator calculatorMock;
	
	@InjectMocks
	private CalculatorService calculatorServiceInjectMock;
	
//	@BeforeEach
//	public void setUp() {
//		MockitoAnnotations.openMocks(this);
//		
//	}
	
	
	@Test
	public void sumTest() {
		when(calculatorServiceInjectMock.addNumbers(1, 3)).thenReturn(4);
//		when(calculatorMock.add(1, 3)).thenReturn(4);
//		CalculatorService calculatorService = new CalculatorService(calculatorMock);
		int result = calculatorServiceInjectMock.addNumbers(1, 3);
		Assertions.assertEquals(4, result);
		
	}
	
}
