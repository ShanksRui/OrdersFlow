package com.development.order.model.entities;

import java.util.Objects;

public class Client {

	private Integer id;
	private String name;
	private Integer cpf;
	private Integer locality;
	
	public Client() {
		
	}
	
	public Client(Integer id, String name, Integer cpf, Integer locality) {
		this.id = id;
		this.name = name;
		this.cpf = cpf;
		this.locality = locality;
	}

	public Integer getId() {
		return id;
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

	public void setId(Integer id) {
		this.id = id;
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

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Client other = (Client) obj;
		return Objects.equals(id, other.id);
	}
}
