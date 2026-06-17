package com.development.order.services;

import java.math.RoundingMode;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.development.order.model.dto.request.ShippingRequestDTO;
import com.development.order.model.dto.response.ShippingDTO;
import com.development.order.model.entities.Shipping;
import com.development.order.model.entities.ShippingStatusHistory;
import com.development.order.model.entities.enums.ShippingStatus;
import com.development.order.repositories.ShippingRepository;
import com.development.order.services.exceptions.NotFoundResourceException;

@Service
public class ShippingService {

	private ShippingRepository repository;
	private CenterService service;

	public ShippingService(ShippingRepository repository,CenterService serivce) {
		this.repository = repository;
		this.service = serivce;
	}
    public Shipping insert(ShippingRequestDTO dto) {
    	if (repository.existsBycnpj(dto.cnpj())) {
			throw new IllegalArgumentException("already exitst ById in data Base");
		}
		Shipping sh = new Shipping();
		sh.setCnpj(dto.cnpj());
		sh.setName(dto.name());
		sh.setPrice(dto.priceFrete().setScale(2,RoundingMode.HALF_UP));
		sh.setLocaldeparture(dto.localdeparture());
		sh.setLocalDestinity(dto.localDestinity());
		sh.setStatus(ShippingStatus.CREATED);
		sh.setCenter(service.findById(dto.centerID()));
		return repository.save(sh);
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

	public ShippingDTO update(Long id, Shipping shipping) {
		Shipping entity = findById(id);
		dataUpdate(entity, shipping);
		repository.save(entity);
		return ShippingDTO.fromDTO(entity);
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
