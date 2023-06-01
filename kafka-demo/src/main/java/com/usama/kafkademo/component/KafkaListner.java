package com.usama.kafkademo.component;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class KafkaListner {

	@KafkaListener(topics = "kafkademotopic", groupId = "kafkademogroup")
	void listner(String data) {
		System.out.println("Listner Receiving : "+data+" 👌🏼");
		
		
	}
}
