package com.usama.productservicecommand.command.api.event;

import java.math.BigDecimal;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class ProductUpdatedEvent {

	private String productId;
	private String name;
	private BigDecimal price;
	private Integer quantity;
}
