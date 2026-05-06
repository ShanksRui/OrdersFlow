package com.development.order.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.development.order.model.dto.request.ClientRequestDTO;
import com.development.order.model.dto.response.ClientDTO;
import com.development.order.model.entities.Client;
import com.development.order.repositories.ClientRepository;
import com.development.order.services.exceptions.NotFoundResourceException;

@Service
public class ClientService {

	private ClientRepository repository;

	public ClientService(ClientRepository repository) {
		this.repository = repository;
	}
	

	public Client insert(ClientRequestDTO client) {
		if (repository.exexistsBycpf(client.getCpf())) {
			throw new IllegalArgumentException("already exitst ById in data Base");
		}
		Client c = new Client();
		c.setName(client.getName());
		c.setCpf(client.getCpf());
		c.setLocality(client.getLocality());
		return repository.save(c);
	    
	}

	public List<Client> findAll() {
		return repository.findAll();
	}

	public Client findByID(Long id) {
		Optional<Client> op = repository.findById(id);
		return op.orElseThrow(() -> new NotFoundResourceException(id));
	}

	public void delete(Long id) {
		if (!repository.existsById(id)) {
			throw new NotFoundResourceException(id);
		}
		repository.deleteById(id);
	}

	public ClientDTO update(Client client, Long id) {
		Client entity = findByID(id);
		dataUpdate(entity, client);
		repository.save(entity);
		return new ClientDTO(entity);

	}

	private void dataUpdate(Client entity, Client client) {
		entity.setLocality(client.getLocality());
		entity.setName(client.getName());
	}
}
