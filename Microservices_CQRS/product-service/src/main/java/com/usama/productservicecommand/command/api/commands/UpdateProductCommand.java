package com.usama.productservicecommand.command.api.commands;

import java.math.BigDecimal;

import org.axonframework.modelling.command.TargetAggregateIdentifier;

import lombok.Builder;
import lombok.Data;
import lombok.ToString;

@Data
@Builder
@ToString
public class UpdateProductCommand {
	
	@TargetAggregateIdentifier
	private String productId;
	private String name;
	private BigDecimal price;
	private Integer quantity;


}
