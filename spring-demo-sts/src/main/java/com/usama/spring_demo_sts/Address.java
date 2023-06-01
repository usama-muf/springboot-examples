package com.usama.spring_demo_sts;

import org.springframework.stereotype.Component;

@Component
public class Address implements Employee {
	private int id;
	private String city;
	
	
	
	public Address() {
		System.out.println("Address Instanciated");
	}
	public void doWork() {
		System.out.println("Calling do work of address");
		
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	
	
	
	
	
}


