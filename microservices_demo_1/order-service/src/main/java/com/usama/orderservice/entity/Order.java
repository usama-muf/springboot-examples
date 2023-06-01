package com.usama.orderservice.entity;

import java.math.BigInteger;
import java.util.List;

import org.springframework.data.annotation.Id;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Table;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@Entity
@Table(name = "order_table")
public class Order {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String generatedOn;
	private List<Product> products;
	private boolean isDelivered;
	
//	private BigInteger totalAmount;
	
}
