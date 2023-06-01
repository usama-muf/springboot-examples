package com.usama.productservicequery.kafka.listner;

import org.apache.kafka.common.requests.ProduceRequest;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import com.usama.productservicequery.query.api.entity.Product;
import com.usama.productservicequery.query.api.entity.ProductRequest;
import com.usama.productservicequery.query.api.repository.ProductRepository;

@Component
public class KafkaListner {

	private final ProductRepository ProductRepository;

	public KafkaListner(ProductRepository productRepository) {
		this.ProductRepository = productRepository;
	}

	@KafkaListener(groupId = "kafkademogroup", topics = "kafkademotopic", containerFactory = "ProductRequestListener")
	public void consume(ProductRequest data) {

		System.out.println(data);
		String mapperType = data.getMappingType().toLowerCase();

		switch (mapperType) {
		case "post": {
			postQuery(data.getProduct());
			break;
		}
		case "update": {
			updateQuery(data.getProduct());
			break;
		}
		case "delete": {
			deleteQuery(data.getProduct());
			break;
		}
		default:
			throw new IllegalArgumentException("Unexpected value: " + mapperType);
		}
	}

	private void deleteQuery(Product product) {
		ProductRepository.delete(product);

	}

	private void updateQuery(Product product) {
		String productId = product.getProductId();
		Product updateProduct = ProductRepository.findById(productId)
				.orElseThrow(() -> new RuntimeException("Prodeuct with id: " + productId + "  Not found"));
		updateProduct.setName(product.getName());
		updateProduct.setPrice(product.getPrice());
		updateProduct.setQuantity(product.getQuantity());

		ProductRepository.save(updateProduct);
	}

	private void postQuery(Product product) {
		ProductRepository.save(product);
	}

}
