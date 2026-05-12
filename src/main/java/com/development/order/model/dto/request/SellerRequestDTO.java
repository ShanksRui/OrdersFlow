package com.development.order.model.dto.request;

public class SellerRequestDTO {

	private String name;
	private Integer cnpj;
	
	public SellerRequestDTO() {
		
	}
	
	public SellerRequestDTO(String name, Integer cnpj) {
		this.name = name;
		this.cnpj = cnpj;
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
