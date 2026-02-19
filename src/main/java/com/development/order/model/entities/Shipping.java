package com.development.order.model.entities;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;

import com.development.order.model.entities.enums.Status;

public class Shipping implements Serializable{

	private Integer id;
	private String name;
	private PackageProduct pckProduct;
	private LocalDate dataPrevist;
	private Status status;

	public Shipping() {

	}

	public Shipping(Integer id, String name, PackageProduct pckProduct, LocalDate dataPrevist, Status status) {
		this.id = id;
		this.name = name;
		this.pckProduct = pckProduct;
		this.dataPrevist = dataPrevist;
		this.status = status;
	}

	public Integer getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public PackageProduct getPckProduct() {
		return pckProduct;
	}

	public LocalDate getDataPrevist() {
		return dataPrevist;
	}

	public Status getStatus() {
		return status;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setPckProduct(PackageProduct pckProduct) {
		this.pckProduct = pckProduct;
	}

	public void setDataPrevist(LocalDate dataPrevist) {
		this.dataPrevist = dataPrevist;
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
		Shipping other = (Shipping) obj;
		return Objects.equals(id, other.id);
	}

}
