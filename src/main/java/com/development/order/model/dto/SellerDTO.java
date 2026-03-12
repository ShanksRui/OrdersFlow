package com.development.order.model.dto;

import com.development.order.model.entities.Seller;

public class SellerDTO {

	private Long id;
	private String name;
	private Integer cnpj;
	
	public SellerDTO() {
		
	}

	public SellerDTO(Seller seller) {
		this.id = seller.getId();
		this.name = seller.getName();
		this.cnpj = seller.getCnpj();

	}

	public Long getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public Integer getCnpj() {
		return cnpj;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setCnpj(Integer cnpj) {
		this.cnpj = cnpj;
	}

}
