package com.usama.productservicecommand.command.api.entity;

import java.math.BigDecimal;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

@Entity
public class Product {
	
	@Id
	private String productId;
	private String name;
	private BigDecimal price;
	private Integer quantity;


}
