package com.development.order.model.dto.request;

import com.development.order.model.entities.Client;

public class ClientRequestDTO {

	private String name;
	private Integer cpf;
	private Integer locality;
	
	public ClientRequestDTO() {
		
	}
	public ClientRequestDTO(Client client) {
		setName(client.getName());
		setCpf(client.getCpf());
		setLocality(client.getLocality());
	}
	public String getName() {
		return name;
	}
	public Integer getCpf() {
		return cpf;
	}
	public Integer getLocality() {
		return locality;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setCpf(Integer cpf) {
		this.cpf = cpf;
	}
	public void setLocality(Integer locality) {
		this.locality = locality;
	}
}
