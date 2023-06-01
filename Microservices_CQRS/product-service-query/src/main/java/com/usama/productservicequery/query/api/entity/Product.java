package com.usama.productservicequery.query.api.entity;

import java.math.BigDecimal;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
//@Entity
//@Table
@Document("product_items")
public class Product {
	
	@Id
//	@PrimaryKey
	private String productId;
	private String name;
	private BigDecimal price;
	private Integer quantity;


}
