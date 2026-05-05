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

import com.development.order.model.dto.response.ProductDTO;
import com.development.order.model.entities.Product;
import com.development.order.services.ProductService;

@RestController
@RequestMapping("/products")
public class ProductResource {

	private ProductService service;
	
	public ProductResource(ProductService service) {
		this.service = service;
	}
	
	@PostMapping
	public ResponseEntity<ProductDTO> insert(@RequestBody ProductDTO product){
		Product s = service.insert(product);
		
	  URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
			  .buildAndExpand(s.getId()).toUri();
	  return ResponseEntity.created(uri).body(new ProductDTO(s));
	}
	
	@GetMapping
	public ResponseEntity<List<ProductDTO>> findAll() {
		List<ProductDTO> dtos = service.findAll()
				.stream().map(ProductDTO::new).collect(Collectors.toList());
		return ResponseEntity.ok().body(dtos);
	}
	@GetMapping("/{id}")
	public ResponseEntity<ProductDTO> findById(@PathVariable Long id) {
		ProductDTO dto = new ProductDTO(service.findById(id));
		return ResponseEntity.ok().body(dto);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> delete(@PathVariable Long id) {
		service.delete(id);
		return ResponseEntity.noContent().build();
	}

	@PatchMapping("/{id}")
	public ResponseEntity<ProductDTO> update(@PathVariable Long id, @RequestBody Product product) {
		ProductDTO dto = service.update(id,product);
		return ResponseEntity.ok().body(dto);
	}
	
}