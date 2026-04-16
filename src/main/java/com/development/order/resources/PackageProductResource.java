package com.development.order.resources;


import java.util.List;
import java.util.stream.Collectors;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.development.order.model.dto.PackageProductDTO;
import com.development.order.model.entities.PackageProduct;
import com.development.order.services.PackageProductService;

@RestController
@RequestMapping("/packages")
public class PackageProductResource {

	private PackageProductService service;
	
	public PackageProductResource(PackageProductService service) {
		this.service = service;
	}
	
	@GetMapping
	public ResponseEntity<List<PackageProductDTO>> findAll() {
		List<PackageProductDTO> dtos = service.findAll()
				.stream().map(PackageProductDTO::new).collect(Collectors.toList());
		return ResponseEntity.ok().body(dtos);
	}
	@GetMapping(value = "/{id}")
	public ResponseEntity<PackageProductDTO> findById(@PathVariable Long id) {
		PackageProductDTO dto = new PackageProductDTO(service.findById(id));
		return ResponseEntity.ok().body(dto);
	}

	@GetMapping("/{id}")
	public ResponseEntity<Void> delete(@PathVariable Long id) {
		service.delete(id);
		return ResponseEntity.noContent().build();
	}

	@PatchMapping("/{id}")
	public ResponseEntity<PackageProductDTO> update(@PathVariable Long id, @RequestBody PackageProduct PackageProduct) {
		PackageProductDTO dto = service.update(id, PackageProduct);
		return ResponseEntity.ok().body(dto);
	}
}
