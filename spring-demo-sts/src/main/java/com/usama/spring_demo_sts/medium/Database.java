package com.usama.spring_demo_sts.medium;

import org.springframework.stereotype.Component;

@Component
public class Database implements Service {

	@Override
	public String name() {
		return "Database MySQL";
	}

	@Override
	public void run() {
		System.out.println("Database is ready");

	}

	@Override
	public void stop() {
		System.out.println("Database is stopped");

	}

}
