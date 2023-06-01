package com.usama.productservicequery.query.api.projection;

import java.util.List;
import java.util.stream.Collectors;

import org.axonframework.queryhandling.QueryHandler;
import org.springframework.stereotype.Component;

import com.usama.productservicequery.query.api.entity.Product;
import com.usama.productservicequery.query.api.model.ProductRestModel;
import com.usama.productservicequery.query.api.querys.GetProductByNameQuery;
import com.usama.productservicequery.query.api.querys.GetProductsQuery;
import com.usama.productservicequery.query.api.repository.ProductRepository;

@Component
public class ProductProjection {

	private final ProductRepository productRepository;

	public ProductProjection(ProductRepository productRepository) {
		this.productRepository = productRepository;
	}

	@QueryHandler
	public List<ProductRestModel> handle(GetProductsQuery getProductQuery) {

		List<Product> products = productRepository.findAll();
		List<ProductRestModel> productRestModels = products.stream().map(product -> ProductRestModel.builder()
				.name(product.getName()).price(product.getPrice()).quantity(product.getQuantity()).build())
				.collect(Collectors.toList());
		return productRestModels;
	}

	@QueryHandler
	public ProductRestModel handle(GetProductByNameQuery getProductByNameQuery) {

		Product product = productRepository.findByName(getProductByNameQuery.getName());

		ProductRestModel productRestModel = ProductRestModel
				.builder().name(product.getName()).price(product.getPrice())
				.quantity(product.getQuantity()).build();

		return productRestModel;

	}

}
