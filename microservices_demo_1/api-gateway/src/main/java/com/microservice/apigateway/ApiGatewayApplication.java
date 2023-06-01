package com.microservice.apigateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
//@EnableEurekaServer
//@RestController
public class ApiGatewayApplication {

	public static void main(String[] args) {
		SpringApplication.run(ApiGatewayApplication.class, args);
	}
//	@GetMapping
//	public String test() {
//		return "API Gateway working!!";
//	}
	
//	@GetMapping("/eureka/apps/")
//	public String getEurekaApp() {
//		return "/eureka/apps/";
//	}

}
