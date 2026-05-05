package com.development.order.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.development.order.model.dto.response.SellerDTO;
import com.development.order.model.entities.Seller;
import com.development.order.repositories.SellerRepository;
import com.development.order.services.exceptions.NotFoundResourceException;

@Service
public class SellerService {

	private SellerRepository repository;

	public SellerService(SellerRepository repository) {
		this.repository = repository;
	}

	public Seller insert(SellerDTO seller) {
		if (repository.existsById(seller.getId())) {
			throw new IllegalArgumentException("already exitst ById in data Base");
		}
		Seller s = new Seller();
		s.setName(seller.getName());
		s.setCnpj(seller.getCnpj());
		return repository.save(s);
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

	public SellerDTO update(Long id, Seller seller) {
		Seller entity = findById(id);
		dataUpdate(entity, seller);
		repository.save(entity);
		return new SellerDTO(entity);
	}

	public void dataUpdate(Seller entity, Seller seller) {
		entity.setName(seller.getName());
		entity.setCnpj(seller.getCnpj());

	}
}
