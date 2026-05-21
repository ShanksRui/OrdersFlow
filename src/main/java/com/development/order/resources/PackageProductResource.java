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

import com.development.order.model.dto.request.PackageProductRequestDTO;
import com.development.order.model.dto.response.PackageProductDTO;
import com.development.order.model.entities.PackageProduct;
import com.development.order.services.PackageProductService;

@RestController
@RequestMapping("/packages")
public class PackageProductResource {

	private PackageProductService service;
	
	public PackageProductResource(PackageProductService service) {
		this.service = service;
	}
	@PostMapping
	public ResponseEntity<PackageProductDTO> insert(@RequestBody PackageProductRequestDTO dto) {
		PackageProduct pkg = service.insert(dto);
				 URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				  .buildAndExpand(pkg.getId()).toUri();
		  return ResponseEntity.created(uri).body(PackageProductDTO.fromDTO(pkg));
	}
	
	@GetMapping
	public ResponseEntity<List<PackageProductDTO>> findAll() {
		List<PackageProductDTO> dtos = service.findAll()
				.stream().map(PackageProductDTO::fromDTO).collect(Collectors.toList());
		return ResponseEntity.ok().body(dtos);
	}
	@GetMapping("/{id}")
	public ResponseEntity<PackageProductDTO> findById(@PathVariable Long id) {
		PackageProductDTO dto =  PackageProductDTO.fromDTO(service.findById(id));
		return ResponseEntity.ok().body(dto);
	}

	@DeleteMapping("/{id}")
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
