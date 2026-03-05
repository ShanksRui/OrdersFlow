package com.development.order.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.development.order.model.entities.Order;
import com.development.order.repositories.OrderRepository;

@Service
public class OrderService {
	
	private OrderRepository repository;
	
	public OrderService(OrderRepository repository) {
		this.repository = repository;
	}
	
	public void insert(Order order) {
		if(repository.existsById(order.getId())) {
			throw new IllegalArgumentException("already exitst ById in data Base");
		}
		repository.save(order);
	}
	public List<Order> findAll() {
		return repository.findAll();
	}

}
