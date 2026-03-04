package com.development.order.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.development.order.model.entities.Center;
import com.development.order.repositories.CenterRepository;

@Service
public class CenterService {

	private CenterRepository repository;
	
	public CenterService(CenterRepository repository) {
		this.repository = repository;
	}
	
	public void insert(Center center) {
		if(repository.existsById(center.getId())) {
			throw new IllegalArgumentException("already exitst ById in data Base");
		}
		repository.save(center);
	}
   public List<Center> findAll() {
	   return repository.findAll();
   }
}
