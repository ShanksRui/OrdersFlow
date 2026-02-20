package com.development.order.services;

import org.springframework.stereotype.Service;

import com.development.order.repositories.ShippingRepository;

@Service
public class ShippingService {

private ShippingRepository repository;
	
	public ShippingService(ShippingRepository repository) {
		this.repository = repository;
	}
}
