package com.api.gateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication(scanBasePackages ="com.api.gateway.controller")
@EnableDiscoveryClient
public class ServiceApiGatewayApplication {

	public static void main(String[] args) {
		SpringApplication.run(ServiceApiGatewayApplication.class, args);
	}

}
