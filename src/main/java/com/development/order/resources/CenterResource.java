package com.development.order.resources;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.development.order.model.dto.request.CenterRequestDTO;
import com.development.order.model.dto.response.CenterDTO;
import com.development.order.model.entities.Center;
import com.development.order.services.CenterService;

@RestController
@RequestMapping("/centers")
public class CenterResource {

	private CenterService service;

	public CenterResource(CenterService service) {
		this.service = service;
	}

	@PostMapping
	public ResponseEntity<CenterDTO> insert(@RequestBody CenterRequestDTO center) {
		Center c = service.insert(center);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				.buildAndExpand(c.getId()).toUri();
		return ResponseEntity.created(uri).body(CenterDTO.fromDTO(c));
	}

	@GetMapping
	public ResponseEntity<List<CenterDTO>> findAll() {
		List<CenterDTO> dtos = service.findAll().stream().map(CenterDTO::fromDTO).collect(Collectors.toList());
		return ResponseEntity.ok().body(dtos);
	}

	@GetMapping("/{id}")
	public ResponseEntity<CenterDTO> findById(@PathVariable Long id) {
		CenterDTO dto = CenterDTO.fromDTO(service.findById(id));
		return ResponseEntity.ok().body(dto);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> delete(@PathVariable Long id) {
		service.delete(id);
		return ResponseEntity.noContent().build();
	}

	@PatchMapping("/{id}")
	public ResponseEntity<CenterDTO> update(@PathVariable Long id, @RequestBody Center center) {
		CenterDTO dto = service.update(center, id);
		return ResponseEntity.ok().body(dto);
	}

}
