package com.usama.productservicecommand.command.api.event;

import java.math.BigDecimal;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor

public class ProductCreatedEvent {

	private String productId;
	private String name;
	private BigDecimal price;
	private Integer quantity;

}
