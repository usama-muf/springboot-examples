package com.usama.orderservice.entity;

import java.util.List;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class OrderRequest {

	private List<Product> products;
}
