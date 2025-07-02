package com.cg.order_service.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.client.WebClient;

import com.cg.order_service.client.ProductClient;
import com.cg.order_service.entity.Order;
import com.cg.order_service.model.ProductOrderDto;
import com.cg.order_service.service.OrderService;
import com.cg.product.service.entity.Product;

@RestController
@RequestMapping("/order")
public class OrderController {
	
	@Autowired
	private OrderService orderService;
	@Autowired
	private ProductClient productClient;
	@Autowired
    private WebClient webClient;

	@PostMapping("/orderCreate")
	public Order createOrder(@RequestBody Order order) {
		return orderService.addOrder(order);
		
	}
	
	@GetMapping("/{orderId}")
	public ProductOrderDto getOrderWithProduct(@PathVariable int orderId) {
		return orderService.getOrderWithProduct(orderId);
		
	}
	
	@GetMapping("/search")
	public String getOrderWithProducts(@RequestParam Optional<String> orderId) {
		 if (orderId !=null) {
		        return "Searching for order ID: " + orderId;
		    } else {
		        return "Showing all orders (no ID provided)";
		    }

	}
	
	@GetMapping("/productId/{id}")
	public ResponseEntity<Product> getProductDetails(@PathVariable int id){
		System.out.println("Hello i am here:"+id);
		Product product = productClient.getById(id);
		return new ResponseEntity<>(product,HttpStatus.OK);
	}
	
	@GetMapping("/prodId/{id}")
	public ResponseEntity<Product> getProductDetailsUsingWebclient(@PathVariable int id){
		Product product = webClient.get()
			    .uri("/products/{id}", id)
			    .retrieve()
			    .bodyToMono(Product.class)
			    .block();
		return new ResponseEntity<>(product,HttpStatus.OK);
	}
}
