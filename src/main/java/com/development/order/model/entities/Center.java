package com.development.order.model.entities;

import java.io.Serializable;
import java.util.Objects;

import com.development.order.model.entities.enums.Status;

public class Center implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private Integer id;
	private Integer quantityPackages;
	private boolean released;
	private Status status;

	public Center() {

	}

	public Center(Integer id, Integer quantityPackages, boolean released, Status status) {
		this.id = id;
		this.quantityPackages = quantityPackages;
		this.released = released;
		this.status = status;
	}

	public Integer getId() {
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

	public void setId(Integer id) {
		this.id = id;
	}

	public void setQuantityPackages(Integer quantityPackages) {
		this.quantityPackages = quantityPackages;
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
