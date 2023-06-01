package com.microservice.service1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.client.WebClient;

@SpringBootApplication
@EnableDiscoveryClient
@RestController
public class Service1Application {
	
	@GetMapping("/api/s1")
	public String getString() {
		return "This is service 1 running";
	}

	public static void main(String[] args) {
		SpringApplication.run(Service1Application.class, args);
	}
	
	@Bean
	@LoadBalanced
	public WebClient.Builder webBuilder() {
		return WebClient.builder();
	}

	
}
