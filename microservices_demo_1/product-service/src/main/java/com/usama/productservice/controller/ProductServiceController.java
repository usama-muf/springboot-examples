package com.usama.productservice.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.usama.productservice.entity.Product;
import com.usama.productservice.service.ProductService;

@RestController
@RequestMapping("/ps")
public class ProductServiceController {

	private final ProductService productService;

	public ProductServiceController(ProductService productService) {
		this.productService = productService;
	}

	@GetMapping("/test")
	public String test() {
		return "Hello from Spring Boot Applicatoin";
	}

	@GetMapping("/product")
	public ResponseEntity<?> getAllProduct() {
		return ResponseEntity.ok(productService.getAllProducts());
	}

	@GetMapping("/product/id")
	public ResponseEntity<?> getAllProduct(@PathVariable Long id) {
		return ResponseEntity.ok(productService.getProductById(id));
	}

	@PostMapping("/product")
	public void createProduct(@RequestBody Product product) {
		productService.createProduct(product);
	}

	@PutMapping("/product/id")
	public void updateProduct(@PathVariable Long id, @RequestBody Product product) {
		productService.updateProduct(id, product);
	}
}
