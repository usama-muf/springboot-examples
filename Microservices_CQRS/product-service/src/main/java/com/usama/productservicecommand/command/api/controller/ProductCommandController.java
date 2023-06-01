package com.usama.productservicecommand.command.api.controller;

import java.util.UUID;

import org.axonframework.commandhandling.gateway.CommandGateway;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.usama.productservicecommand.command.api.commands.CreateProductCommands;
import com.usama.productservicecommand.command.api.commands.UpdateProductCommand;
import com.usama.productservicecommand.command.api.model.ProductRestModel;

@RestController
@RequestMapping("/product")
public class ProductCommandController {

//	Part of Axon framework
	private final CommandGateway commandGateway;

	public ProductCommandController(CommandGateway commandGateway) {
		this.commandGateway = commandGateway;
	}

	@PostMapping
	public String addProduct(@RequestBody ProductRestModel restModel) {
		
		CreateProductCommands createProductCommands = CreateProductCommands.builder()
				.productId(UUID.randomUUID().toString())
				.name(restModel.getName())
				.price(restModel.getPrice())
				.quantity(restModel.getQuantity())
				.build();
		
	 	String result =  commandGateway.sendAndWait(createProductCommands);
		
		return result;
	}
	
	@PutMapping("/{productId}")
	public String updateProduct(@PathVariable String productId, @RequestBody ProductRestModel productRestModel) {
		
		UpdateProductCommand updateProductCommand = UpdateProductCommand
				.builder()
				.productId(productId)
				.name(productRestModel.getName())
				.price(productRestModel.getPrice())
				.quantity(productRestModel.getQuantity())
				.build();
		
		String result = commandGateway.sendAndWait(updateProductCommand);
		
		return result;
	}
}