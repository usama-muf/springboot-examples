package com.usama.spring_demo_sts;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Engineer implements Employee{
	
	private Address address;
	
	Engineer(){}
	
//	public Engineer(Address address) {
//		address.setCity("Lucknow");
//		address.setId(12);
////		this.address = address;
//	}
	
	@Autowired
	public void setAddress(Address address) {
		this.address = address;
	}

	@Override
	public void doWork() {
		System.out.println("Enginnering Things engineer dowork called");
		address.doWork();
	}
	
	public void init() {
		System.out.println("Automatically Init Method Called");
	}
	public void destroy() {
		System.out.println("Authomatically Destroy Method Called");
	}

}
