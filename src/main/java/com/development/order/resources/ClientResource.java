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

import com.development.order.model.dto.request.ClientRequestDTO;
import com.development.order.model.dto.response.ClientDTO;
import com.development.order.model.entities.Client;
import com.development.order.services.ClientService;

@RestController
@RequestMapping("/clients")
public class ClientResource {

	private ClientService service;

	public ClientResource(ClientService service) {
		this.service = service;
	}
	
	@PostMapping
	public ResponseEntity<ClientDTO> insert(@RequestBody ClientRequestDTO client){
		Client c = service.insert(client);
		
	  URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
			  .buildAndExpand(c.getId()).toUri();
	  return ResponseEntity.created(uri).body(new ClientDTO(c));
	}

	@GetMapping
	public ResponseEntity<List<ClientDTO>> findall() {
		List<ClientDTO> dtos = service.findAll().stream().map(ClientDTO::new).collect(Collectors.toList());
		return ResponseEntity.ok().body(dtos);
	}

	@GetMapping("/{id}")
	public ResponseEntity<ClientDTO> findById(@PathVariable Long id) {
		ClientDTO dto = new ClientDTO(service.findByID(id));
		return ResponseEntity.ok().body(dto);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> delete(@PathVariable Long id) {
		service.delete(id);
		return ResponseEntity.noContent().build();
	}

	@PatchMapping("/{id}")
	public ResponseEntity<ClientDTO> update(@PathVariable Long id, @RequestBody Client client) {
		ClientDTO dto = service.update(client, id);
		return ResponseEntity.ok().body(dto);
	}
}
