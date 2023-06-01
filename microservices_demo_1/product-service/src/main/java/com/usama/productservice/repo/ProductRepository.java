package com.usama.productservice.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.usama.productservice.entity.Product;

public interface ProductRepository extends JpaRepository<Product, Long>{

}
