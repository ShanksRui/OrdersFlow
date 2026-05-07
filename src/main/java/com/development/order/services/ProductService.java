package com.development.order.services;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.stereotype.Service;

import com.development.order.model.dto.response.ProductDTO;
import com.development.order.model.entities.Product;
import com.development.order.repositories.ProductRepository;
import com.development.order.services.exceptions.NotFoundResourceException;

@Service
public class ProductService {

	private ProductRepository repository;

	public ProductService(ProductRepository repository) {
		this.repository = repository;
	}

	public Product insert(ProductDTO product) {
		if (repository.existsById(product.getId())) {
			throw new IllegalArgumentException("already exitst ById in data Base");
		}
		Product p = new Product();
		p.setName(product.getName());
		p.setPrice(product.getPrice());
		p.setType(product.getType());
		p.setCode(generatorFromCode());

		return repository.save(p);
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

	public ProductDTO update(Long id, Product product) {
		Product entity = findById(id);
		dataUpdate(entity, product);
		repository.save(entity);
		return new ProductDTO(entity);
	}

	public void dataUpdate(Product entity, Product product) {
		entity.setName(product.getName());
		entity.setPrice(product.getPrice());
		entity.setSeller(product.getSeller());
		entity.setType(product.getType());
	}

	public static String generatorFromCode() {
		return UUID.randomUUID().toString().replace("-", "").substring(0, 8).toUpperCase();
	}
}
