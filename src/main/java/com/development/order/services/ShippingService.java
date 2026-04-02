package com.development.order.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.development.order.model.entities.Shipping;
import com.development.order.model.entities.ShippingStatusHistory;
import com.development.order.repositories.ShippingRepository;

@Service
public class ShippingService {

	private ShippingRepository repository;

	public ShippingService(ShippingRepository repository) {
		this.repository = repository;
	}

	public List<Shipping> findAll() {
		return repository.findAll();
	}

	public List<ShippingStatusHistory> findHistoryStatus() {
		List<ShippingStatusHistory> shippings = repository.findAll().stream().flatMap(s -> s.getHistory().stream())
				.collect(Collectors.toList());
		return shippings;
	}
}
