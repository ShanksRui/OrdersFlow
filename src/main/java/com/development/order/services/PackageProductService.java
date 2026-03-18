package com.development.order.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.development.order.model.entities.PackageProduct;
import com.development.order.repositories.PackageProductRepository;

@Service
public class PackageProductService {

	private PackageProductRepository repository;
	
	public PackageProductService(PackageProductRepository repository) {
		this.repository = repository;
	}
	
	public void insert(PackageProduct pkg) {
		if(repository.existsById(pkg.getId())) {
			throw new IllegalArgumentException("already exitst ById in data Base");
		}
		repository.save(pkg);
	}
	public List<PackageProduct> findAll() {
		return repository.findAll();
	}
}
