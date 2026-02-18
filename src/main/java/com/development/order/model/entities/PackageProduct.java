package com.development.order.model.entities;

import java.time.Instant;
import java.util.Objects;

public class PackageProduct {
	
	private Integer id;
	private Double weitghtDeclared;
	private Double weightValidated;
	private Integer sellerId;
	private Integer clientID;
	private Instant createdAt;
	
	public PackageProduct() {
		
	}
	
	public PackageProduct(Integer id, Double weitghtDeclared, Double weightValidated, Integer sellerId,
			Integer clientID, Instant createdAt) {
		this.id = id;
		this.weitghtDeclared = weitghtDeclared;
		this.weightValidated = weightValidated;
		this.sellerId = sellerId;
		this.clientID = clientID;
		this.createdAt = createdAt;
	}

	public Integer getId() {
		return id;
	}

	public Double getWeitghtDeclared() {
		return weitghtDeclared;
	}

	public Double getWeightValidated() {
		return weightValidated;
	}

	public Integer getSellerId() {
		return sellerId;
	}

	public Integer getClientID() {
		return clientID;
	}

	public Instant getCreatedAt() {
		return createdAt;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public void setWeitghtDeclared(Double weitghtDeclared) {
		this.weitghtDeclared = weitghtDeclared;
	}

	public void setWeightValidated(Double weightValidated) {
		this.weightValidated = weightValidated;
	}

	public void setSellerId(Integer sellerId) {
		this.sellerId = sellerId;
	}

	public void setClientID(Integer clientID) {
		this.clientID = clientID;
	}

	public void setCreatedAt(Instant createdAt) {
		this.createdAt = createdAt;
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
