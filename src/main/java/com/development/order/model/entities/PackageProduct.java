package com.development.order.model.entities;

import java.io.Serializable;
import java.time.Instant;
import java.util.Objects;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;

@Entity
public class PackageProduct implements Serializable{

	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private PackageIds id;
	
	private Instant createdAt;
	@OneToOne
	@JoinColumn(name = "product_id")
	private Product product;
	
	private Double weightValidated;
	
	
	public PackageProduct() {
		
	}
	
	public PackageProduct(Double weitghtDeclared, Double weightValidated, Integer sellerId,
			Integer clientID, Instant createdAt, Product product) {
		this.weightValidated = weightValidated;
		this.id.setSellerId(sellerId);
		this.id.setClientId(clientID);
		this.createdAt = createdAt;
		this.product = product;
	}

	public Double getWeightValidated() {
		return weightValidated;
	}

	public Instant getCreatedAt() {
		return createdAt;
	}

	public void setWeitghtDeclared(Double weitghtDeclared) {
	}

	public void setWeightValidated(Double weightValidated) {
		this.weightValidated = weightValidated;
	}

	public void setCreatedAt(Instant createdAt) {
		this.createdAt = createdAt;
	}
	
	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
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
		PackageProduct other = (PackageProduct) obj;
		return Objects.equals(id, other.id);
	}
}
