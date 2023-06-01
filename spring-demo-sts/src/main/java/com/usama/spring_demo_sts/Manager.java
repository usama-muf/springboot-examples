package com.usama.spring_demo_sts;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Component;

@Component
public class Manager implements Employee {
	
	

	@Override
	public void doWork() {
		System.out.println("Managing Things");
		
	}

	@PreDestroy
	public void predestroy() {
		// TODO Auto-generated method stub
		System.out.println("Desposibale Bean");
		
	}

	@PostConstruct
	public void afterPropertiesSet() {
		// TODO Auto-generated method stub
		System.out.println("Init bean");
	}
	
	

}
