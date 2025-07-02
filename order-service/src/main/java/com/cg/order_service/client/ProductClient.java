package com.cg.order_service.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.cg.product.service.entity.Product;

@FeignClient(name="product-service")
public interface ProductClient {
	
	@GetMapping("/product/{id}")
	public Product getById(@PathVariable int id);

}
