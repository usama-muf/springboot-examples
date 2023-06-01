package com.usama.productservicecommand.kafka.config;

import org.apache.kafka.common.serialization.Serializer;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.usama.productservicecommand.command.api.entity.ProductRequest;

public class ProductSerializer implements Serializer<ProductRequest>{

	private final ObjectMapper objectMapper = new ObjectMapper();
	
	@Override
	public byte[] serialize(String topic, ProductRequest data) {
		try {
			return objectMapper.writeValueAsBytes(data);
		} catch (Exception e) {
			throw new RuntimeException("Cannot Seariliaze : "+e.getMessage());
		}
	}
 
}
