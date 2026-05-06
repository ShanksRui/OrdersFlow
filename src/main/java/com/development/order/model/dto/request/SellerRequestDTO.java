package com.development.order.model.dto.request;

import com.development.order.model.entities.Seller;

public class SellerRequestDTO {

	private String name;
	private Integer cnpj;
	
	public SellerRequestDTO() {
		
	}
	
	public SellerRequestDTO(Seller seller) {
		this.name = seller.getName();
		this.cnpj = seller.getCnpj();
	}

	public String getName() {
		return name;
	}

	public Integer getCnpj() {
		return cnpj;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setCnpj(Integer cnpj) {
		this.cnpj = cnpj;
	}
}
