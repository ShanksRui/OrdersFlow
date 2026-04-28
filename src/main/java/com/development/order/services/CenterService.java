package com.development.order.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.development.order.model.dto.request.CenterRequestDTO;
import com.development.order.model.dto.response.CenterDTO;
import com.development.order.model.entities.Center;
import com.development.order.repositories.CenterRepository;
import com.development.order.services.exceptions.NotFoundResourceException;

@Service
public class CenterService {

	private CenterRepository repository;

	public CenterService(CenterRepository repository) {
		this.repository = repository;
	}

	public Center insert(CenterRequestDTO dto) {
		Center center = new Center();
		center.setName(dto.getName());
		center.setLimitPackages(dto.getLimitPackages());
		return repository.save(center);
	}

	public List<Center> findAll() {
		return repository.findAll();
	}

	public Center findById(Long id) {
		Optional<Center> op = repository.findById(id);
		return op.orElseThrow(() -> new NotFoundResourceException(id));
	}

	public void delete(Long id) {
		if (!repository.existsById(id)) {
			throw new NotFoundResourceException(id);
		}
		repository.deleteById(id);
	}
	
	public CenterDTO update(Center center, Long id) {
		Center entity = findById(id);
		dataUpdate(entity, center);
		repository.save(entity);
		return new CenterDTO(entity);
	}
	
	private void dataUpdate(Center entity,Center center) {
		entity.setLimitPackages(center.getLimitPackages());
	}

	public static Boolean validationWeight(Double weightDeclared, Double weightValited) {
		if (weightDeclared > weightValited) {
			throw new IllegalArgumentException("weight is not at is limited");
		}
		return true;
	}
}
