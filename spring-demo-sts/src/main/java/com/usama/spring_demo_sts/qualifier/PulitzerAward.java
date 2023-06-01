package com.usama.spring_demo_sts.qualifier;

import org.springframework.stereotype.Component;

@Component
public class PulitzerAward implements Award {

	@Override
	public void award() {
		System.out.println("You got pulitzer award");
	}

}
