package com.usama.productservicequery.kafka.config;

import org.apache.kafka.common.serialization.Deserializer;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.usama.productservicequery.query.api.entity.ProductRequest;

public class ProductDeserializer implements Deserializer<ProductRequest> {

	private Logger logger = LogManager.getLogger(this.getClass());

	private final ObjectMapper objectMapper = new ObjectMapper();

	@Override
	public ProductRequest deserialize(String topic, byte[] data) {

		System.out.println(topic);
		try {
			return objectMapper.readValue(data, ProductRequest.class);
		} catch (Exception e) {
			logger.error(e.getMessage());
			throw new RuntimeException("Deserializer not working : " + e.getMessage());
		}

	}

//	private Class<T> type;
//
//	ProductDeserializer(Class type) {
//		this.type = type;
//	}
//
//	@Override
//	public Object deserialize(String topic, byte[] data) {
//
//		ObjectMapper mapper = new ObjectMapper();
//		T obj = null;
//
//		try {
//			obj = mapper.readValue(data, type);
//		} catch (Exception e) {
//			logger.error(e.getMessage());
//		}
//
//		return obj;
//	}

}
