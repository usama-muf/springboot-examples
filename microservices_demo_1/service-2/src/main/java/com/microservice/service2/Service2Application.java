package com.microservice.service2;

import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@RestController
@RequestMapping("/s2")
public class Service2Application {

	
//	@Autowired
//	public RestTemplate restTemplate;
	
	public static void main(String[] args) {
		SpringApplication.run(Service2Application.class, args);
	}
	
	
	@GetMapping("/test")
	public String getService2() {
		return "Running test Service 2 ";
	}

	
	@GetMapping("/text")
	public String getText() {
		System.out.println("Inside getText method service-2  And getting Reply from service-1 \n");
		
//		WebClient ans = webClient().baseUrl("http://SERVICE-1/s1/test").build();
		List<String> ans = restTemplate().getForObject("http://service-1/s1/test", List.class);
		return "Inside service-2 : \n Here is the reply from service-1:  "+ans;
	}
	
//	@GetMapping("/product") 
//	public 
	
	@Bean
	@LoadBalanced
	public RestTemplate restTemplate() {
		return new RestTemplate();
	}
	

//	@Bean
//	@LoadBalanced
//	public WebClient.Builder webClient() {
//		return WebClient.builder();
//	}
}
