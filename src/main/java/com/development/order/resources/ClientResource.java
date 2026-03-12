package com.development.order.resources;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.development.order.model.dto.ClientDTO;
import com.development.order.model.entities.Client;
import com.development.order.services.ClientService;

@RestController
@RequestMapping("/clients")
public class ClientResource {

	private ClientService service;
	
	public ClientResource(ClientService service) {
		this.service = service;
	}
	
	@GetMapping
	public ResponseEntity<List<ClientDTO>> findall(){
		List<ClientDTO> dtos = service.findAll().stream()
				.map(ClientDTO::new)
				.collect(Collectors.toList());
		return ResponseEntity.ok().body(dtos);
	}
}
