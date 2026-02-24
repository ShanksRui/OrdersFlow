package com.development.order.model.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import com.development.order.model.entities.enums.Status;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class Seller implements Serializable {

	private static final long serialVersionUID = 1L;

	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String name;
	private Integer cnpj;
	
	
	@OneToMany(mappedBy = "seller")
    private List<Product> products = new ArrayList<>();
	private Status status;

	public Seller() {

	}

	public Seller(Integer id, String name, Integer cnpj, Status status) {
		this.id = id;
		this.name = name;
		this.cnpj = cnpj;
		this.status = status;
	}
	
	public Seller(Integer id, String name, Integer cnpj) {
		super();
		this.id = id;
		this.name = name;
		this.cnpj = cnpj;
	}
	
	

	public List<Product> getProducts() {
		return products;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	public Integer getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public Integer getCnpj() {
		return cnpj;
	}

	

	public void setId(Integer id) {
		this.id = id;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setCnpj(Integer cnpj) {
		this.cnpj = cnpj;
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
		Seller other = (Seller) obj;
		return Objects.equals(id, other.id);
	}

}
