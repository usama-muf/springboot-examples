package com.usama.productservicecommand.command.api.commands;

import java.math.BigDecimal;

import org.axonframework.modelling.command.TargetAggregateIdentifier;

import lombok.Builder;
import lombok.Data;

@Data
@Builder

//should store the payload that we are going to use inside an object
public class CreateProductCommands {

	/*
	 * use to mark productId as identifier which should be unique for every product
	 * and it is matched with Aggrigate's productId
	 */
	@TargetAggregateIdentifier
	private String productId;
	private String name;
	private BigDecimal price;
	private Integer quantity;

}
