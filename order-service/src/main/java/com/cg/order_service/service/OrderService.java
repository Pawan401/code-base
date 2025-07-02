package com.cg.order_service.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.cg.order_service.entity.Order;
import com.cg.order_service.model.ProductOrderDto;
import com.cg.order_service.repository.OrderRepository;
import com.cg.product.service.entity.Product;

@Service
public class OrderService {

	@Autowired
	private OrderRepository orderRepository;

	@Autowired
	private RestTemplate restTemplate;

	public Order addOrder(Order order) {
		return orderRepository.save(order);
	}

	public ProductOrderDto getOrderWithProduct(int orderId) {

		Order order = orderRepository.findById(orderId).get();

		int productId = order.getProductId();
		Product product = restTemplate.getForObject("http://localhost:8181/product/" + productId, Product.class);
		ProductOrderDto prodOrderDto = new ProductOrderDto();
		prodOrderDto.setProduct(product);
		prodOrderDto.setOrder(order);
		return prodOrderDto;

	}

}
