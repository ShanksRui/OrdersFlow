package com.development.order.services;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.development.order.model.entities.Shipping;
import com.development.order.model.entities.ShippingStatusHistory;
import com.development.order.repositories.ShippingRepository;
import com.development.order.services.exceptions.NotFoundResourceException;

@Service
public class ShippingService {

	private ShippingRepository repository;

	public ShippingService(ShippingRepository repository) {
		this.repository = repository;
	}

	public List<Shipping> findAll() {
		return repository.findAll();
	}

	public Shipping findById(Long id) {
		Optional<Shipping> op = repository.findById(id);
		return op.orElseThrow(() -> new NotFoundResourceException(id));
	}

	public void delete(Long id) {
		if (!repository.existsById(id)) {
			throw new NotFoundResourceException(id);
		}
		repository.deleteById(id);
	}

	public Shipping update(Long id, Shipping shipping) {
		Shipping entity = findById(id);
		dataUpdate(entity, shipping);
		return repository.save(entity);
	}

	public void dataUpdate(Shipping entity, Shipping shipping) {
		entity.setCenter(shipping.getCenter());
		entity.setName(shipping.getName());
		entity.setStatus(shipping.getStatus());
	}

	public List<ShippingStatusHistory> findHistoryStatus() {
		List<ShippingStatusHistory> shippings = repository.findAll().stream().flatMap(s -> s.getHistory().stream())
				.collect(Collectors.toList());
		return shippings;
	}
}
