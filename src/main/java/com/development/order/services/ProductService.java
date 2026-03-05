package com.development.order.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.development.order.model.entities.Center;
import com.development.order.model.entities.Product;
import com.development.order.repositories.ProductRepository;

@Service
public class ProductService {

private ProductRepository repository;
	
	public ProductService(ProductRepository repository) {
		this.repository = repository;
	}
	
	public void insert(Product product) {
		if(repository.existsById(product.getId())) {
			throw new IllegalArgumentException("already exitst ById in data Base");
		}
		repository.save(product);
	}
	public List<Product> findAll() {
		return repository.findAll();
	}
}
