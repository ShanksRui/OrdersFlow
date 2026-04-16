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

import com.development.order.model.dto.OrderDTO;
import com.development.order.model.entities.Order;
import com.development.order.services.OrderService;

@RestController
@RequestMapping("/orders")
public class OrderResource {

	private OrderService service;

	public OrderResource(OrderService service) {
		this.service = service;
	}

	@GetMapping
	public ResponseEntity<List<OrderDTO>> findAll() {
		List<OrderDTO> dtos = service.findAll()
				.stream().map(OrderDTO::new).collect(Collectors.toList());
		return ResponseEntity.ok().body(dtos);
	}
	@GetMapping(value = "/{id}")
	public ResponseEntity<OrderDTO> findById(@PathVariable Long id) {
		OrderDTO dto = new OrderDTO(service.findById(id));
		return ResponseEntity.ok().body(dto);
	}

	@GetMapping("/{id}")
	public ResponseEntity<Void> delete(@PathVariable Long id) {
		service.delete(id);
		return ResponseEntity.noContent().build();
	}

	@PatchMapping("/{id}")
	public ResponseEntity<OrderDTO> update(@PathVariable Long id, @RequestBody Order Order) {
		OrderDTO dto = service.update(id, Order);
		return ResponseEntity.ok().body(dto);
	}
}
