package com.usama.productservice.service;

import java.util.List;

import com.usama.productservice.entity.Product;

public interface ProductService {
	
	List<Product> getAllProducts();
	Product getProductById(Long id);
	void createProduct(Product product);
	void updateProduct(Long id, Product product);

}
