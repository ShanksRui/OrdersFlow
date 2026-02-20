package com.development.order.model.entities;

import java.io.Serializable;
import java.time.Instant;
import java.util.Objects;

<<<<<<< HEAD
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;

@Entity
public class PackageProduct implements Serializable{

	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private PackageIds id;
	
=======
import com.development.order.model.entities.enums.Status;
import com.development.order.model.entities.pk.PackagePK;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
@Entity
public class PackageProduct implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	private Double weitghtDeclared;
	private Double weightValidated;
	@EmbeddedId
	private PackagePK id;
>>>>>>> 9d7c467 (correcoes do merge anterior,implementei novamente as annotations nas entities , criacao da PKcomposta e configurei o test.properties do h2)
	private Instant createdAt;
	@OneToOne
	@JoinColumn(name = "product_id")
	private Product product;
	
	private Double weightValidated;
	
	
	public PackageProduct() {
		
	}
	
	public PackageProduct(Double weitghtDeclared, Double weightValidated, Integer sellerId,
			Integer clientID, Instant createdAt, Product product) {
<<<<<<< HEAD
		this.weightValidated = weightValidated;
		this.id.setSellerId(sellerId);
		this.id.setClientId(clientID);
		this.createdAt = createdAt;
		this.product = product;
=======
		this.weitghtDeclared = weitghtDeclared;
		this.weightValidated = weightValidated;
		this.id.setClientId(clientID);
		this.id.setSellerId(sellerId);
		this.createdAt = createdAt;
		this.setProduct(product);
	}

	
	public Double getWeitghtDeclared() {
		return weitghtDeclared;
>>>>>>> 9d7c467 (correcoes do merge anterior,implementei novamente as annotations nas entities , criacao da PKcomposta e configurei o test.properties do h2)
	}

	public Double getWeightValidated() {
		return weightValidated;
	}

<<<<<<< HEAD
=======

>>>>>>> 9d7c467 (correcoes do merge anterior,implementei novamente as annotations nas entities , criacao da PKcomposta e configurei o test.properties do h2)
	public Instant getCreatedAt() {
		return createdAt;
	}

	public void setWeitghtDeclared(Double weitghtDeclared) {
	}

	public void setWeightValidated(Double weightValidated) {
		this.weightValidated = weightValidated;
	}

<<<<<<< HEAD
=======
	public void setSellerId(Integer sellerId) {
		this.id.setSellerId(sellerId);
	}

	public void setClientID(Integer clientID) {
		this.id.setClientId(clientID);
	}

>>>>>>> 9d7c467 (correcoes do merge anterior,implementei novamente as annotations nas entities , criacao da PKcomposta e configurei o test.properties do h2)
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
