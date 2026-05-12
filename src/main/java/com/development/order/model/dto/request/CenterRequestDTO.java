package com.development.order.model.dto.request;

public class CenterRequestDTO {

	private String name;
	private Integer limitPackages;
	private Integer cnpj;

	public CenterRequestDTO() {

	}

	public CenterRequestDTO(String name,Integer limitPackages,Integer cnpj) {
		this.name = name;
		this.limitPackages = limitPackages;
		this.cnpj = cnpj;
	}

	public String getName() {
		return name;
	}

	public Integer getLimitPackages() {
		return limitPackages;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setLimitPackages(Integer limitPackages) {
		this.limitPackages = limitPackages;
	}

	public Integer getCnpj() {
		return cnpj;
	}

	public void setCnpj(Integer cnpj) {
		this.cnpj = cnpj;
	}
}
