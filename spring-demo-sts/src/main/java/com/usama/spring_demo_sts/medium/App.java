package com.usama.spring_demo_sts.medium;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class App {

	private Service mainService;
	private Service[] services;

//	@Autowired
//	public App(@Qualifier("logger") Service main) {
//		this.mainService = main;
//	}
	
	@Autowired
	public App (Service[] services) {
		this.setServices(services);
	}

	public Service getMainService() {
		return mainService;
	}

	public void setMainService(Service mainService) {
		this.mainService = mainService;
	}

	public Service[] getServices() {
		return services;
	}

	public void setServices(Service[] services) {
		this.services = services;
	}

	
}
