package com.development.order.services;

import java.util.List;
import java.util.Optional;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import com.development.order.model.dto.request.ProductRequestDTO;
import com.development.order.model.dto.response.ProductDTO;
import com.development.order.model.entities.Product;
import com.development.order.repositories.ProductRepository;
import com.development.order.services.exceptions.CodeExistingException;
import com.development.order.services.exceptions.NotFoundResourceException;
import com.development.order.util.GeneratorCode;

@Service
public class ProductService {

	private ProductRepository repository;
	private SellerService service;

	public ProductService(ProductRepository repository, SellerService service) {
		this.repository = repository;
		this.service = service;
	}

	public Product insert(ProductRequestDTO product) {
		Product p = new Product();
		p.setName(product.name());
		p.setPrice(product.price());
		p.setType(product.type());
		p.setSeller(service.findById(product.sellerID()));
		for (int i = 0; i < 5; i++) {
			String code = GeneratorCode.generatorFromCode();
			
			if (code == null || code.isBlank()) {
	            throw new IllegalStateException("generated code is null");
	        }
			
			p.setCode(code);
			
		
			try {
				return repository.save(p);
			} catch (DataIntegrityViolationException e) {
	            System.out.println(e.getMessage());
	            
	            if (!e.getMessage().contains("unique")) {
	                throw e;
	            }
	            System.out.println("generating new code!");
			}		
		}
		throw new CodeExistingException("error in generating for code unique");
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
		return ProductDTO.fromDTO(entity);
	}

	public void dataUpdate(Product entity, Product product) {
		entity.setName(product.getName());
		entity.setPrice(product.getPrice());
		entity.setSeller(product.getSeller());
		entity.setType(product.getType());
	}

}
