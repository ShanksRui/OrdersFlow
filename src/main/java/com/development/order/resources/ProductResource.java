package com.development.order.resources;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.development.order.model.dto.ProductDTO;
import com.development.order.services.ProductService;

@RestController
@RequestMapping("/products")
public class ProductResource {

	private ProductService service;
	
	public ProductResource(ProductService service) {
		this.service = service;
	}
	
	@GetMapping
	public ResponseEntity<List<ProductDTO>> findAll() {
		List<ProductDTO> dtos = service.findAll()
				.stream().map(ProductDTO::new).collect(Collectors.toList());
		return ResponseEntity.ok().body(dtos);
	}
	
}