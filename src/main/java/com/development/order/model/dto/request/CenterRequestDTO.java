package com.development.order.model.dto.request;

import com.development.order.model.entities.Center;

public class CenterRequestDTO {

	private String name;
	private Integer limitPackages;

	public CenterRequestDTO() {

	}

	public CenterRequestDTO(Center center) {
		this.name = center.getName();
		this.limitPackages = center.getLimitPackages();
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
}
