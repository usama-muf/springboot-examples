package com.microservice.catalogueservice.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.microservice.catalogueservice.entity.Order;

public interface OrderRepository extends JpaRepository<Order, Integer> {

	List<Order> findByCategory(String category);
}
