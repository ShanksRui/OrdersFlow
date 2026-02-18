package com.development.order.model.entities;

import java.util.Objects;

public class Seller {

	private Integer id;
	private String name;
	private Integer cnpj;
	private PackageProduct pckProduct;
	
	public Seller() {
		
	}

	public Seller(Integer id, String name, Integer cnpj, PackageProduct pckProduct) {
		this.id = id;
		this.name = name;
		this.cnpj = cnpj;
		this.pckProduct = pckProduct;
	}

	public Integer getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public Integer getCnpj() {
		return cnpj;
	}

	public PackageProduct getPckProduct() {
		return pckProduct;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setCnpj(Integer cnpj) {
		this.cnpj = cnpj;
	}

	public void setPckProduct(PackageProduct pckProduct) {
		this.pckProduct = pckProduct;
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
		Seller other = (Seller) obj;
		return Objects.equals(id, other.id);
	}

}
