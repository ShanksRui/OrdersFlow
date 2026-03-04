package com.development.order.model.entities;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import com.development.order.model.entities.enums.Status;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
@Entity
public class Shipping implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String name;
	@OneToMany(mappedBy = "shipping")
	private List<PackageProduct> pkgs = new ArrayList<>();
	private String localdeparture;
	private String localDestinity;

	public Shipping() {

	}

	public Shipping(Long id, String name, String localdeparture,
			String localDestinity, Status status) {
		this.id = id;
		this.name = name;
		this.localdeparture = localdeparture;
		this.localDestinity = localDestinity;
	}


	public String getLocaldeparture() {
		return localdeparture;
	}

	public String getLocalDestinity() {
		return localDestinity;
	}

	public void setLocaldeparture(String localdeparture) {
		this.localdeparture = localdeparture;
	}

	public void setLocalDestinity(String localDestinity) {
		this.localDestinity = localDestinity;
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
