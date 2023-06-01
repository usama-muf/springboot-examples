package com.usama.spring_demo_sts.qualifier;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class FictionWriter implements Writer {

	@Autowired
//	@Qualifier("nationalAward")
	private Award award;

	@Override
	public void write() {
		System.out.println("Writing Fiction Novels");
	}

	@Override
	public void getAward() {
		award.award();

	}

}
