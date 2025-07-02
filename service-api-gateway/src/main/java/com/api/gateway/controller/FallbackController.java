package com.api.gateway.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class FallbackController {
    @RequestMapping("/fallback/products")
    public ResponseEntity<String> fallback() {
    	System.out.println(">>> Fallback endpoint hit!");
        return ResponseEntity.ok("Product service is currently unavailable.");
    }
}
