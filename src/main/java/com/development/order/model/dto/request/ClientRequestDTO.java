package com.development.order.model.dto.request;

public class ClientRequestDTO {

	private String name;
	private Integer cpf;
	private Integer locality;
	
	public ClientRequestDTO() {
		
	}
	public ClientRequestDTO(String name,Integer cpf, Integer locality) {
		this.name = name;
		this.cpf = cpf;
		this.locality = locality;
		
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
