package com.development.order.model.entities;

import java.io.Serializable;
import java.util.Objects;

import com.development.order.model.entities.enums.Status;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;

@Entity
public class PackageProduct implements Serializable {

	private static final long serialVersionUID = 1L;

	private Double weightDeclared;
	private Double weightValidated;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@ManyToOne
	@JoinColumn(name = "client_id")
	private Client client;
	@ManyToOne
	@JoinColumn(name = "seller_id")
	private Seller seller;
	@ManyToOne
	@JoinColumn(name = "product_id")
	private Product product;
	@ManyToOne
	@JoinColumn(name = "center_id")
	private Center center;
	
	private Status status;

	public PackageProduct() {
	}

	public PackageProduct(Double weightDeclared, Double weightValidated, Long id, Client client,
			Product product, Status status) {
		this.weightDeclared = weightDeclared;
		this.weightValidated = weightValidated;
		this.id = id;
		this.client = client;
		setSeller(product);
		this.product = product;
		this.status = status;
	}
	
	public PackageProduct(Long id, Client client, Product product,Center center, Status status) {
		this.id = id;
		this.client = client;
		setSeller(product);
		this.product = product;
		this.status = status;
		this.center = center;
	}
	
	public Center getCenter() {
		return center;
	}
	public void setCenter(Center center) {
		this.center = center;
	}

	public Double getWeightDeclared() {
		return weightDeclared;
	}

	public Double getWeightValidated() {
		return weightValidated;
	}

	public Long getId() {
		return id;
	}

	public Client getClient() {
		return client;
	}

	public Seller getSeller() {
		return seller;
	}

	public Product getProduct() {
		return product;
	}

	public Status getStatus() {
		return status;
	}

	public void setWeightDeclared(Double weightDeclared) {
		this.weightDeclared = weightDeclared;
	}

	public void setWeightValidated(Double weightValidated) {
		this.weightValidated = weightValidated;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	public void setSeller(Product product) {
		this.seller = product.getSeller();
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public void setStatus(Status status) {
		this.status = status;
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
