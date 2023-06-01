package com.example.service2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@EnableFeignClients
@RestController
@RequestMapping("/s2")
public class Service2Application {

	@Autowired
	Service1RestService2 service1RestService2;
	
	
	public static void main(String[] args) {
		SpringApplication.run(Service2Application.class, args);
	}
	
	@GetMapping("/fetch")
    public String fetchDataFromProvider() {
        return service1RestService2.fetchData();
    }

}
