package com.usama.spring_demo_sts.medium;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

@Component
@Lazy
public class Logger implements Service {

	@Override
	public String name() {
		return "Logger X";
	}

	@Override
	@PostConstruct
	public void run() {
		System.out.println("Logger is ready");
	}

	@Override
	@PreDestroy
	public void stop() {
		System.out.println("Logger is Stopped");

	}

}
