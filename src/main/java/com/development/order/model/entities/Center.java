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
public class Center implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private Integer quantityPackages;
	private boolean released;
	private Status status;
	@OneToMany(mappedBy = "center")
	private List<PackageProduct> pkgs = new ArrayList<>();

	public Center() {

	}

	public Center(Long id, boolean released, Status status) {
		this.id = id;
		this.released = released;
		this.status = status;
	}
	public List<PackageProduct> getPkgs(){
		return pkgs;
	}

	public Long getId() {
		return id;
	}

	public Integer getQuantityPackages() {
		return quantityPackages;
	}

	public boolean isReleased() {
		return released;
	}

	public Status getStatus() {
		return status;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setQuantityPackages() {
		this.quantityPackages = pkgs.size();
	}

	public void setReleased(boolean released) {
		this.released = released;
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
		Center other = (Center) obj;
		return Objects.equals(id, other.id);
	}

}
