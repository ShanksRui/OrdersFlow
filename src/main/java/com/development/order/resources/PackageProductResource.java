package com.development.order.resources;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.development.order.model.dto.PackageProductDTO;
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
}
