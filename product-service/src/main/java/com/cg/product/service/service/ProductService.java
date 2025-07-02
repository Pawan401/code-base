package com.cg.product.service.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.product.service.entity.Product;
import com.cg.product.service.repository.ProductRepository;

import jakarta.transaction.Transactional;

@Service
public class ProductService {
	@Autowired
	private ProductRepository repo;

	public List<Product> getAllProduct() {
		return repo.findAll();
	}

	public Product getByProductId(int id) {
		return repo.findById(id).orElse(null);
	}

	@Transactional
	public void save(Product product) {
		 repo.save(product);
	}

	@Transactional
	public void deleteById(int id) {
		repo.deleteById(id);
	}

	public Optional<Product> findById(int id) {
		return repo.findById(id);
	}
}
