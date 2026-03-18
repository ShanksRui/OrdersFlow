package com.development.order.resources;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.development.order.model.dto.ShippingDTO;
import com.development.order.services.ShippingService;

@RestController
@RequestMapping("shippings")
public class ShippingResource {

	
private ShippingService service;
	
	public ShippingResource(ShippingService service) {
		this.service = service;
	}
	
	@GetMapping
	public ResponseEntity<List<ShippingDTO>> findAll() {
		List<ShippingDTO> dtos = service.findAll()
				.stream().map(ShippingDTO::new).collect(Collectors.toList());
		return ResponseEntity.ok().body(dtos);
	}
	
}
