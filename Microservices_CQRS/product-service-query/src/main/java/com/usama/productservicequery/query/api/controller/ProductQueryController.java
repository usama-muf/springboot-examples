package com.usama.productservicequery.query.api.controller;

import java.util.List;

import org.axonframework.messaging.responsetypes.ResponseType;
import org.axonframework.messaging.responsetypes.ResponseTypes;
import org.axonframework.queryhandling.QueryGateway;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.usama.productservicequery.query.api.model.ProductRestModel;
import com.usama.productservicequery.query.api.querys.GetProductByNameQuery;
import com.usama.productservicequery.query.api.querys.GetProductsQuery;

@RestController
@RequestMapping("/product")
public class ProductQueryController {

	private QueryGateway queryGateway;

	public ProductQueryController(QueryGateway queryGateway) {
		this.queryGateway = queryGateway;
	}

	@GetMapping
	public List<ProductRestModel> getAllProducts() {
		GetProductsQuery getProductQuery = new GetProductsQuery();
		
		List<ProductRestModel> productRestModels = queryGateway.query(getProductQuery, ResponseTypes.multipleInstancesOf(ProductRestModel.class)).join();
		return productRestModels;
	}
	
	@GetMapping("/{name}")
	public ProductRestModel getProductByName(@PathVariable String name) {
		
		GetProductByNameQuery getProductByNameQuery = new GetProductByNameQuery(name);
		ProductRestModel productRestModel = queryGateway.query(getProductByNameQuery, ResponseTypes.instanceOf(ProductRestModel.class)).join();
		
		return productRestModel;
	}
}
