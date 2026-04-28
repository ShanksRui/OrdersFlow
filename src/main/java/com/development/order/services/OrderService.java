package com.development.order.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.development.order.model.dto.response.OrderDTO;
import com.development.order.model.entities.Order;
import com.development.order.repositories.OrderRepository;
import com.development.order.services.exceptions.NotFoundResourceException;

@Service
public class OrderService {

	private OrderRepository repository;

	public OrderService(OrderRepository repository) {
		this.repository = repository;
	}

	public void insert(Order order) {
		if (repository.existsById(order.getId())) {
			throw new IllegalArgumentException("already exitst ById in data Base");
		}
		repository.save(order);
	}

	public List<Order> findAll() {
		return repository.findAll();
	}

	public Order findById(Long id) {
		Optional<Order> op = repository.findById(id);
		return op.orElseThrow(() -> new NotFoundResourceException(id));
	}

	public void delete(Long id) {
		if (!repository.existsById(id)) {
			throw new NotFoundResourceException(id);
		}
		repository.deleteById(id);
	}

	public OrderDTO update(Long id, Order order) {
		Order entity = findById(id);
		dataUpdate(entity, order);
		repository.save(entity);
		return new OrderDTO(entity);
	}

	public void dataUpdate(Order entity, Order order) {
		entity.setClient(order.getClient());
		entity.setMommentBuy(order.getMommentBuy());

	}
}
