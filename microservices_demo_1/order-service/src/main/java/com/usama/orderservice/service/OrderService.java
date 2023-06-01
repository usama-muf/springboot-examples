package com.usama.orderservice.service;

import java.util.List;

import com.usama.orderservice.entity.Order;

public interface OrderService {
	
	List<Order> getAllOrder();
	Order getOrderById(Long id);
	void createOrder(Order order);

}
