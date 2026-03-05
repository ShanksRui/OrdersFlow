package com.development.order.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.development.order.model.entities.Center;
import com.development.order.model.entities.Seller;
import com.development.order.repositories.SellerRepository;

@Service
public class SellerService {

private SellerRepository repository;
	
	public SellerService(SellerRepository repository) {
		this.repository = repository;
	}
	
	public void insert(Seller seller) {
		if(repository.existsById(seller.getId())) {
			throw new IllegalArgumentException("already exitst ById in data Base");
		}
		repository.save(seller);
	}
	public List<Seller> findAll() {
		return repository.findAll();
	}
}
