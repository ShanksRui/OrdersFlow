package com.development.order.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.development.order.model.dto.response.PackageProductDTO;
import com.development.order.model.entities.PackageProduct;
import com.development.order.repositories.PackageProductRepository;
import com.development.order.services.exceptions.NotFoundResourceException;

@Service
public class PackageProductService {

	private PackageProductRepository repository;
	
	public PackageProductService(PackageProductRepository repository) {
		this.repository = repository;
	}
	
	public void insert(PackageProduct pkg) {
		if(repository.existsById(pkg.getId())) {
			throw new IllegalArgumentException("already exitst ById in data Base");
		}
		repository.save(pkg);
	}
	public List<PackageProduct> findAll() {
		return repository.findAll();
	}
	public PackageProduct findById(Long id) {
		Optional<PackageProduct> op = repository.findById(id);
		return op.orElseThrow(() -> new NotFoundResourceException(id));
	}

	public void delete(Long id) {
		if (!repository.existsById(id)) {
			throw new NotFoundResourceException(id);
		}
		repository.deleteById(id);
	}
	public PackageProductDTO update(Long id,PackageProduct pkg) {
		PackageProduct entity = findById(id);
		dataUpdate(entity, pkg);
		return  PackageProductDTO.fromDTO(entity);
	}
	public void dataUpdate(PackageProduct entity,PackageProduct pkg) {
		entity.setDataPrevist(pkg.getDataPrevist());
		entity.setShipping(pkg.getShipping());
	}
}
