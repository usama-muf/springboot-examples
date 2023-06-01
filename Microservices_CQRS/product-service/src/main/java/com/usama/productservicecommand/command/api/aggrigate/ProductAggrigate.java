package com.usama.productservicecommand.command.api.aggrigate;

import java.math.BigDecimal;

import org.axonframework.commandhandling.CommandHandler;
import org.axonframework.eventsourcing.EventSourcingHandler;
import org.axonframework.modelling.command.AggregateIdentifier;
import org.axonframework.modelling.command.AggregateLifecycle;
import org.axonframework.spring.stereotype.Aggregate;
import org.springframework.beans.BeanUtils;

import com.usama.productservicecommand.command.api.commands.CreateProductCommands;
import com.usama.productservicecommand.command.api.commands.UpdateProductCommand;
import com.usama.productservicecommand.command.api.event.ProductCreatedEvent;
import com.usama.productservicecommand.command.api.event.ProductUpdatedEvent;

@Aggregate
public class ProductAggrigate {

	@AggregateIdentifier
	private String productId;
	private String name;
	private BigDecimal price;
	private Integer quantity;

	public ProductAggrigate() {

	}

	@CommandHandler
	public ProductAggrigate(CreateProductCommands createProductCommands) {

//		Validate your fields
//		TODO

//		Create the event
		ProductCreatedEvent productCreatedEvent = new ProductCreatedEvent();

		BeanUtils.copyProperties(createProductCommands, productCreatedEvent);

//		publish the event i.e productCreatedEvent
		AggregateLifecycle.apply(productCreatedEvent);
	}

	@EventSourcingHandler
	public void on(ProductCreatedEvent productCreatedEvent) {
//		Update all the fields since we are changing the state 

		this.productId = productCreatedEvent.getProductId();
		this.name = productCreatedEvent.getName();
		this.price = productCreatedEvent.getPrice();
		this.quantity = productCreatedEvent.getQuantity();
	}

	@CommandHandler
	public void handle(UpdateProductCommand updateProductCommand) {
		ProductUpdatedEvent productUpdatedEvent = new ProductUpdatedEvent();
		BeanUtils.copyProperties(updateProductCommand, productUpdatedEvent);
		productUpdatedEvent.setProductId(productId); // Set the productId from the aggregate
		AggregateLifecycle.apply(productUpdatedEvent);
	}

	@EventSourcingHandler
	public void on(ProductUpdatedEvent productUpdatedEvent) {
		this.productId = productUpdatedEvent.getProductId();
		this.name = productUpdatedEvent.getName();
		this.price = productUpdatedEvent.getPrice();
		this.quantity = productUpdatedEvent.getQuantity();
	}

}
