package com.development.order.resources;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
	public ResponseEntity<List<Center>> findAll(){
		List<Center> centers = service.findAll();
		return ResponseEntity.ok().body(centers);
	}

}
