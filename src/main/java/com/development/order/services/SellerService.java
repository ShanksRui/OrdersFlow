package com.development.order.services;

import org.springframework.stereotype.Service;

import com.development.order.repositories.SellerRepository;

@Service
public class SellerService {

private SellerRepository repository;
	
	public SellerService(SellerRepository repository) {
		this.repository = repository;
	}
}
