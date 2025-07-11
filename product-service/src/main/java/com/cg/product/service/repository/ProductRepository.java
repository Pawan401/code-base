package com.cg.product.service.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cg.product.service.entity.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {
}
