package com.usama.spring_demo_sts.qualifier;

import org.springframework.stereotype.Component;

@Component
public class BookerAward implements Award {

	@Override
	public void award() {
		System.out.println("You got Booker Award");
	}

}
