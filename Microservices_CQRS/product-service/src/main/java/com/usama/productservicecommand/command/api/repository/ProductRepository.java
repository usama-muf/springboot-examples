package com.usama.productservicecommand.command.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.usama.productservicecommand.command.api.entity.Product;

public interface ProductRepository extends JpaRepository<Product, String> {

}
