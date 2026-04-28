package com.development.order.model.dto.response;

import com.development.order.model.entities.Center;

public class CenterDTO {

	private Long id;
	private String name;
	private Integer quantityPackages;
	private Integer limitPackages;
	
	public CenterDTO() {
		
	}
	
	public CenterDTO(Center center) {
		this.name = center.getName();
		this.id = center.getId();
		this.quantityPackages = center.getQuantityPackages();
		this.limitPackages = center.getLimitPackages();
	}

	public Long getId() {
		return id;
	}

	public Integer getQuantityPackages() {
		return quantityPackages;
	}

	public Integer getLimitPackages() {
		return limitPackages;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setQuantityPackages(Integer quantityPackages) {
		this.quantityPackages = quantityPackages;
	}

	public void setLimitPackages(Integer limitPackages) {
		this.limitPackages = limitPackages;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
