package com.development.order.services;

import org.springframework.stereotype.Service;

import com.development.order.repositories.ClientRepository;

@Service
public class ClientService {

	private ClientRepository repository;
	
	public ClientService(ClientRepository repository) {
		this.repository = repository;
	}
}
