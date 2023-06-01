package com.usama.spring_demo_sts.medium;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {

	public static void main(String[] args) {
		
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		App app = (App) context.getBean("app");
		Database db = (Database) context.getBean("database");
		System.out.println(db.name());		
		
		((ClassPathXmlApplicationContext) context).close();

	}

}
