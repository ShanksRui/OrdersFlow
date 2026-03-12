package com.development.order.resources;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.development.order.model.dto.SellerDTO;
import com.development.order.services.SellerService;

@RestController
@RequestMapping("/sellers")
public class SellerResource {

	private SellerService service;
	
	public SellerResource(SellerService service) {
		this.service = service;
	}
	
	@GetMapping
	public ResponseEntity<List<SellerDTO>> findAll(){
		List<SellerDTO> dtos = service.findAll()
				.stream().map(SellerDTO::new).collect(Collectors.toList());
		return ResponseEntity.ok().body(dtos);
	}
}