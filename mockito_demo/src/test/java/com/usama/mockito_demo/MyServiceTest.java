package com.usama.mockito_demo;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

//@ExtendWith(MockitoExtension.class)
public class MyServiceTest {
	
	@Mock
	MyDependency myDependency;
	
	@Mock
	private MyService myService;
	
	@BeforeEach
	public void setUp() {
//		myDependency = mock(MyDependency.class);
//		myService = mock(MyService.class);
		
		MockitoAnnotations.openMocks(this);
	}
	

	
	@Test
	public void processRequestTest() {
		when(myDependency.doSomething("hi")).thenReturn("Returning Hi");
		
		MyService myService = new MyService(myDependency);
		String result = myService.processRequest("hi");
		
		
		assertEquals("Returning Hi", result);
	}
	@Test
	public void processRequestNullTest() {
		when(myDependency.doSomething(null)).thenReturn("Error: request is null");
		assertEquals("Error: request is null", myDependency.doSomething(null));
	}

}
