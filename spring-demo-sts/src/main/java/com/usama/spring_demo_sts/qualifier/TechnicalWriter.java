package com.usama.spring_demo_sts.qualifier;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class TechnicalWriter implements Writer {

	@Autowired
//	@Qualifier("nationaAward")
	private Award award;

	@Override
	public void write() {
		System.out.println("Writing Technical Novels");
	}

	@Override
	public void getAward() {
		award.award();
	}

}
