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

import com.development.order.model.dto.request.SellerRequestDTO;
import com.development.order.model.dto.response.SellerDTO;
import com.development.order.model.entities.Seller;
import com.development.order.services.SellerService;

@RestController
@RequestMapping("/sellers")
public class SellerResource {

	private SellerService service;
	
	public SellerResource(SellerService service) {
		this.service = service;
	}
	@PostMapping
	public ResponseEntity<SellerDTO> insert(@RequestBody SellerRequestDTO seller){
		Seller s = service.insert(seller);
		
	  URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
			  .buildAndExpand(s.getId()).toUri();
	  return ResponseEntity.created(uri).body(SellerDTO.fromDTO(s));
	}
	
	@GetMapping
	public ResponseEntity<List<SellerDTO>> findAll(){
		List<SellerDTO> dtos = service.findAll()
				.stream().map(SellerDTO::fromDTO).collect(Collectors.toList());
		return ResponseEntity.ok().body(dtos);
	}
	@GetMapping("/{id}")
	public ResponseEntity<SellerDTO> findById(@PathVariable Long id) {
		SellerDTO dto =  SellerDTO.fromDTO(service.findById(id));
		return ResponseEntity.ok().body(dto);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> delete(@PathVariable Long id) {
		service.delete(id);
		return ResponseEntity.noContent().build();
	}

	@PatchMapping("/{id}")
	public ResponseEntity<SellerDTO> update(@PathVariable Long id, @RequestBody Seller seller) {
		SellerDTO dto = service.update(id,seller);
		return ResponseEntity.ok().body(dto);
	}
}