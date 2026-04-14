package com.development.order.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.development.order.model.entities.Product;
import com.development.order.repositories.ProductRepository;
import com.development.order.services.exceptions.NotFoundResourceException;

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
	
	public Product findById(Long id) {
		Optional<Product> op = repository.findById(id);
		return op.orElseThrow(() -> new NotFoundResourceException(id));
	}

	public void delete(Long id) {
		if (!repository.existsById(id)) {
			throw new NotFoundResourceException(id);
		}
		repository.deleteById(id);
	}

	public Product update(Long id, Product product) {
		Product entity = findById(id);
		dataUpdate(entity, product);
		return repository.save(entity);
	}

	public void dataUpdate(Product entity, Product product) {
		entity.setName(product.getName());
		entity.setPrice(product.getPrice());
		entity.setSeller(product.getSeller());
		entity.setType(product.getType());

	}
}

