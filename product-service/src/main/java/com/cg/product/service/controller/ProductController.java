package com.cg.product.service.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.product.service.entity.Product;
import com.cg.product.service.service.ProductService;

@RestController
@RequestMapping("/product")
public class ProductController {
	@Autowired
	private ProductService service;
static {
	System.out.println("Starting ------------> : ");
}
	@GetMapping("/products")
	public List<Product> getAllProduct() {
		System.out.println("Ending ------------> : ");
		return service.getAllProduct();
	}

	@GetMapping("/{id}")
	public Product getById(@PathVariable int id) {
		return service.getByProductId(id);
	}

	@PostMapping("/createProduct")
	public ResponseEntity<String> create(@RequestBody Product product) {
		service.save(product);
		return new ResponseEntity<>("Product created successfully", HttpStatus.CREATED);
	}

	@PutMapping("/updateProduct/{id}")
	public ResponseEntity<String> update(@PathVariable int id, @RequestBody Product updatedProduct) {
	    Optional<Product> existingProductOpt = service.findById(id);
	    if (existingProductOpt.isPresent()) {
	        Product existingProduct = existingProductOpt.get();

	        // Update only the fields you want to allow changes to
	        existingProduct.setName(updatedProduct.getName());
	        existingProduct.setPrice(updatedProduct.getPrice());
	        service.save(existingProduct);
	        return ResponseEntity.ok("Product updated successfully");
	    } else {
	        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Product not found");
	    }
	}

	@DeleteMapping("/deleteProduct/{id}")
	public ResponseEntity<String> delete(@PathVariable int id) {
		service.deleteById(id);
		return new ResponseEntity<>("Product deleted successfully", HttpStatus.OK);
	}
}
