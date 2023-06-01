package com.usama.kafkademo.controller;

import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.usama.kafkademo.entity.Message;
import com.usama.kafkademo.entity.MessageRequest;

@RestController
public class KafkaController {

	private KafkaTemplate<String, MessageRequest> kafkaTemplate;

	public KafkaController(KafkaTemplate<String, MessageRequest> kafkaTemplate) {
		this.kafkaTemplate = kafkaTemplate;
	}

	@PostMapping("/api/message")
	public void message(@RequestBody Message message) {

//		System.out.println(message);
		MessageRequest messageRequest = MessageRequest
				.builder()
				.mappingType("POST")
				.message(message)
				.build();
		kafkaTemplate.send("kafkademotopic", messageRequest);

	}
}
