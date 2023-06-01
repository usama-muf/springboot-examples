package com.usama.kafkademo.config;

import org.apache.kafka.common.serialization.Serializer;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.usama.kafkademo.entity.MessageRequest;

public class ProductSerializer implements Serializer<MessageRequest> {

	private final ObjectMapper objectMapper = new ObjectMapper();
	
	@Override
	public byte[] serialize(String topic, MessageRequest data) {
		
		try {
			return objectMapper.writeValueAsBytes(data);
		} catch (Exception e) {
			throw new RuntimeException("Error Serializing MessageRequest "+e.getMessage());
		}
		
	}

}
