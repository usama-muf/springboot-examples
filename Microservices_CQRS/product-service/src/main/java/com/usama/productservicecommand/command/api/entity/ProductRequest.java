package com.usama.productservicecommand.command.api.entity;

import lombok.Builder;
import lombok.Data;

@Data
@Builder

public class ProductRequest {

	private String mappingType;
	private Product product;
}
