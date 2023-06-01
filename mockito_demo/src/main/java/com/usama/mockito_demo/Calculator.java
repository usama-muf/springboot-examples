package com.usama.mockito_demo;

public class Calculator {
	
	public int add(int a, int b) {
        return a + b;
    }
	
	public int squreInteger(Integer i) {
		i = verifySquareArgument(i);
		return i*i;
	}

	private Integer verifySquareArgument(Integer i) {
		
		if(i>=46430 || i<-46340 || i== (int)Double.NaN) throw new IllegalArgumentException("Value of argument is either low OR high");
		return i;
	}

}
