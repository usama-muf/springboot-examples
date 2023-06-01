package com.microservice.service1;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.client.WebClient;

@SpringBootApplication
@RestController
@RequestMapping("/s1")
public class Service1Application {

	
	@GetMapping("/test")
	public List<String> getString() {
		return Stream.of("This is service 1 running :: test service-1", "list 2").collect(Collectors.toList());
	}

//	@GetMapping("/api")
//	public String getContentsFromServci2() {
//		return "from Service 1 : " + componentService1.getInfo();
//	}

	public static void main(String[] args) {
		
		SpringApplication.run(Service1Application.class, args);
	}

	@Bean
	@LoadBalanced
	public WebClient.Builder webBuilder() {
		return WebClient.builder();
	}

}
