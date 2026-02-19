package com.development.order.services;

import org.springframework.stereotype.Service;

import com.development.order.repositories.ProductRepository;

@Service
public class ProductService {

private ProductRepository repository;
	
	public ProductService(ProductRepository repository) {
		this.repository = repository;
	}
}
