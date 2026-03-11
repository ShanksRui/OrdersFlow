package com.development.order.model.entities;

import java.io.Serializable;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_order")
public class Order implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private Instant mommentBuy;
	
	@ManyToOne
	@JoinColumn(name = "client_id")
	private Client client;
	
	@OneToMany(mappedBy = "order")
	private List<PackageProduct> pkgs = new ArrayList<>();

	public Order () {
		
	}
	
	public Order(Long id, Instant mommentBuy,Client client) {
		this.id = id;
		this.mommentBuy = mommentBuy;
		this.client = client;
		
	}

	public Long getId() {
		return id;
	}

	public Instant getMommentBuy() {
		return mommentBuy;
	}

	public Client getClient() {
		return client;
	}

	public List<PackageProduct> getPkgs() {
		return pkgs;
	}
	public void addPackage(PackageProduct pkg) {
	     pkgs.add(pkg);
	     pkg.setOrder(this);
	     pkg.setClient(getClient());
	}
	public void setId(Long id) {
		this.id = id;
	}

	public void setMommentBuy(Instant mommentBuy) {
		this.mommentBuy = mommentBuy;
	}

	public void setClient(Client client) {
		 this.client = client;
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
		Order other = (Order) obj;
		return Objects.equals(id, other.id);
	}
}
