package com.development.order.model.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import com.development.order.model.entities.enums.ShippingStatus;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;

@Entity
public class Shipping implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String name;
	private Integer cnpj;
	@OneToMany(mappedBy = "shipping")
	private List<PackageProduct> pkgs = new ArrayList<>();
	private String localdeparture;
	private String localDestination;
	@Enumerated(EnumType.STRING)
	private ShippingStatus status;
	@ManyToOne
	@JoinColumn(name = "center_id")
	private Center center;
	@OneToMany(mappedBy = "shipping", cascade = CascadeType.ALL)
	private List<ShippingStatusHistory> historys = new ArrayList<>();
	private Double price = 19.00;

	public Shipping() {

	}

	public Shipping(Long id, String name,Integer cnpj, String localdeparture, String localDestination, ShippingStatus status,
			Center center) {
		this.id = id;
		this.name = name;
		this.localdeparture = localdeparture;
		this.localDestination = localDestination;
		this.status = status;
		this.center = center;
		this.setCnpj(cnpj);
	}

	public Center getCenter() {
		return center;
	}

	public void setCenter(Center center) {
		this.center = center;
	}

	public void addPkg(PackageProduct pkg) {
		if (pkg.getCenter() != this.center) {
			throw new IllegalArgumentException("centers different");
		}
		pkgs.add(pkg);
	}

	public String getLocaldeparture() {
		return localdeparture;
	}

	public String getLocalDestinity() {
		return localDestination;
	}

	public void setLocaldeparture(String localdeparture) {
		this.localdeparture = localdeparture;
	}

	public void setLocalDestinity(String localDestination) {
		this.localDestination = localDestination;
	}

	public Long getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public List<PackageProduct> getPkgs() {
		return pkgs;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setName(String name) {
		this.name = name;
	}

	public ShippingStatus getStatus() {
		return status;
	}

	public void setStatus(ShippingStatus status) {
		this.status = status;
	}

	public List<ShippingStatusHistory> getHistory() {
		return historys;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
	      this.price = price;
	}

	public void addHistoryStatus(ShippingStatusHistory history) {
		if (getStatus() == null) {
			throw new IllegalStateException("shipping status must be defined before registering history");
		}
		history.setStatus(getStatus());
		history.setShipping(this);
		historys.add(history);
	}
	
	public Integer getCnpj() {
		return cnpj;
	}

	public void setCnpj(Integer cnpj) {
		if(cnpj != null && cnpj <= 8) {
			this.cnpj = cnpj;
		}
		throw new IllegalArgumentException("cnpj invalid");
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
		Shipping other = (Shipping) obj;
		return Objects.equals(id, other.id);
	}
}
