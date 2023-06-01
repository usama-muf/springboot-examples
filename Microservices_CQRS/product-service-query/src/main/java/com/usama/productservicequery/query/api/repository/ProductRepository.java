package com.usama.productservicequery.query.api.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.usama.productservicequery.query.api.entity.Product;

//public interface ProductRepository extends JpaRepository<Product, String>{
public interface ProductRepository extends MongoRepository<Product, String> {

//	@AllowFiltering annotation allows server-side filtering for findByName() method.
//	@AllowFiltering
	Product findByName(String name);

}
