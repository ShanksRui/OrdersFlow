package com.development.order.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.development.order.model.entities.Client;
import com.development.order.repositories.ClientRepository;

@Service
public class ClientService {

	private ClientRepository repository;
	
	public ClientService(ClientRepository repository) {
		this.repository = repository;
	}
	
	public void insert(Client client) {
		if(repository.existsById(client.getId())) {
			throw new IllegalArgumentException("already exitst ById in data Base");
		}
		repository.save(client);
	}
	public List<Client> findAll() {
		return repository.findAll();
	}
}
