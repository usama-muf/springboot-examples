package com.usama.productservicecommand.command.api.model;

import java.math.BigDecimal;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder

// Request from User 
 public class ProductRestModel {
	
	
	private String name;
	private BigDecimal price;
	private Integer quantity;

}
