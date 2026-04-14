package com.development.order.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.development.order.model.entities.Seller;
import com.development.order.repositories.SellerRepository;
import com.development.order.services.exceptions.NotFoundResourceException;

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
	public Seller findById(Long id) {
		Optional<Seller> op = repository.findById(id);
		return op.orElseThrow(() -> new NotFoundResourceException(id));
	}

	public void delete(Long id) {
		if (!repository.existsById(id)) {
			throw new NotFoundResourceException(id);
		}
		repository.deleteById(id);
	}

	public Seller update(Long id, Seller seller) {
		Seller entity = findById(id);
		dataUpdate(entity, seller);
		return repository.save(entity);
	}

	public void dataUpdate(Seller entity, Seller seller) {
		entity.setName(seller.getName());
		entity.setCnpj(seller.getCnpj());

	}
}

