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

import com.development.order.model.dto.CenterDTO;
import com.development.order.model.entities.Center;
import com.development.order.services.CenterService;

@RestController
@RequestMapping("/centers")
public class CenterResource {
	
	private CenterService service;
	
	public CenterResource(CenterService service) {
		this.service = service;
	}
	
	@GetMapping
	public ResponseEntity<List<CenterDTO>> findAll(){
		List<CenterDTO> dtos = service.findAll()
				.stream().map(CenterDTO::new).collect(Collectors.toList());
		return ResponseEntity.ok().body(dtos);
	}
	@GetMapping("/{id}")
    public ResponseEntity<CenterDTO> findById(@PathVariable Long id){
		CenterDTO dto = new CenterDTO(service.findById(id));
		return ResponseEntity.ok().body(dto);		
	}
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> delete(@PathVariable Long id){
		service.delete(id);
		return ResponseEntity.noContent().build();
	}
	@PatchMapping("/{id}")
	public ResponseEntity<CenterDTO> update(@PathVariable Long id, @RequestBody Center center){
		CenterDTO dto = service.update(center, id);
		return ResponseEntity.ok().body(dto);
	}

}
