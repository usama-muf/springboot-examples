package com.usama.kafkademo.config;

import java.util.HashMap;
import java.util.Map;

import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.common.serialization.StringSerializer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.core.DefaultKafkaProducerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.core.ProducerFactory;

import com.usama.kafkademo.entity.MessageRequest;


@Configuration
public class KafkaProducerConfig {

	@Value("${spring.kafka.bootstrap-service}")
	private String bootstrapString;

//	Configuration that will pass to producer factory

	public Map<String, Object> producerConfig() {
		Map<String, Object> property = new HashMap<>();
		property.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, bootstrapString);
		property.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
		property.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, ProductSerializer.class);

		return property;

	}

//	producer factory is responsible for creating Kafka producer instances
	@Bean
	public ProducerFactory<String, MessageRequest> producerFactory() {
		return new DefaultKafkaProducerFactory<>(producerConfig());
	}
	
	@Bean
	public KafkaTemplate<String,  MessageRequest> kafkaTemplate(ProducerFactory<String, MessageRequest> producerFactory) {
		return new KafkaTemplate<>(producerFactory);
	}
//	@Bean
//	public KafkaTemplate<String, String > kafkaTemplate() {
//		return new KafkaTemplate<>(producerFactory());
//	}
	

}
