package com.usama.restdemo.exception;

@SuppressWarnings("serial")
public class EmployeeNotFoundException  extends RuntimeException{

	public EmployeeNotFoundException(Long id) {
		super("Could not found employee "+id);
		
	}
	

}
