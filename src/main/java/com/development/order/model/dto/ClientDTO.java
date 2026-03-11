package com.development.order.model.dto;

import com.development.order.model.entities.Client;

public class ClientDTO {

	private Long id;
	private String name;
	private Integer locality;
	
	public ClientDTO() {
		
	};

	public ClientDTO(Client client) {
		this.id = client.getId();
		this.name = client.getName();
		this.locality = client.getLocality();
	}

	public Long getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public Integer getLocality() {
		return locality;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setLocality(Integer locality) {
		this.locality = locality;
	}
}
