package com.usama.orderservice.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.usama.orderservice.entity.Order;

public interface OrderRepository extends JpaRepository<Order, Long>{

}
