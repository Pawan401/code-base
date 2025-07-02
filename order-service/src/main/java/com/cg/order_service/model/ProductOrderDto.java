package com.cg.order_service.model;

import com.cg.order_service.entity.Order;
import com.cg.product.service.entity.Product;

public class ProductOrderDto {
	Product product;
	Order order;
	public ProductOrderDto(){}
	public ProductOrderDto(Product product, Order order) {
		super();
		this.product = product;
		this.order = order;
	}
	public Product getProduct() {
		return product;
	}
	public void setProduct(Product product) {
		this.product = product;
	}
	public Order getOrder() {
		return order;
	}
	public void setOrder(Order order) {
		this.order = order;
	}
	
}
