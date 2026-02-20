package com.development.order.model.entities;

import java.io.Serializable;
import java.time.Instant;
import java.util.Objects;

import jakarta.persistence.Entity;
@Entity
public class Client implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	private Integer id;
	private String name;
	private Integer cpf;
	private Integer locality;
	private Instant DataBuy;
	private Product product;

	
	public Client() {
		
	}
	
	public Client(Integer id, String name, Integer cpf, Integer locality,Instant DataBuy,Product product) {
		this.id = id;
		this.name = name;
		this.cpf = cpf;
		this.locality = locality;
		this.DataBuy = DataBuy;
		this.product = product;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
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
	
	public Instant getDataBuy() {
		return DataBuy;
	}

	public void setDataBuy(Instant dataBuy) {
		DataBuy = dataBuy;
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
