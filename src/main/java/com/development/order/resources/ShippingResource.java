package com.development.order.resources;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.development.order.model.dto.response.ShippingDTO;
import com.development.order.model.dto.response.ShippingStatusHistoryDTO;
import com.development.order.model.entities.Shipping;
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
	
	@GetMapping("/history")
	public ResponseEntity<List<ShippingStatusHistoryDTO>> findAllHistory(){
		List<ShippingStatusHistoryDTO> dtos = service.findHistoryStatus()
				.stream().map(ShippingStatusHistoryDTO::new).collect(Collectors.toList());
		return ResponseEntity.ok().body(dtos);
	}
	@GetMapping("/{id}")
	public ResponseEntity<ShippingDTO> findById(@PathVariable Long id) {
		ShippingDTO dto = new ShippingDTO(service.findById(id));
		return ResponseEntity.ok().body(dto);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> delete(@PathVariable Long id) {
		service.delete(id);
		return ResponseEntity.noContent().build();
	}

	@PatchMapping("/{id}")
	public ResponseEntity<ShippingDTO> update(@PathVariable Long id, @RequestBody Shipping shipping) {
		ShippingDTO dto = service.update(id,shipping);
		return ResponseEntity.ok().body(dto);
	}
}
