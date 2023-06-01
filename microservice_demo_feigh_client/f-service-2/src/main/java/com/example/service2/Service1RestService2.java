package com.example.service2;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(value ="SERVICE-1", url = "http://localhost:9000/s1")
public interface Service1RestService2 {

	@GetMapping("/data")
    String fetchData();
	
}
