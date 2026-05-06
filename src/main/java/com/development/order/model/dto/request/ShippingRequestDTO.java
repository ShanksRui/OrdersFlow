package com.development.order.model.dto.request;

import com.development.order.model.dto.response.CenterDTO;
import com.development.order.model.entities.Center;
import com.development.order.model.entities.Shipping;

public class ShippingRequestDTO {

	private String name;
	private String localdeparture;
	private String localDestinity;
	private CenterDTO center;
	
	public ShippingRequestDTO(Shipping shipping) {
		this.name = shipping.getName();
		this.localdeparture = shipping.getLocaldeparture();
		this.localDestinity = shipping.getLocalDestinity();
		
	}

	public String getName() {
		return name;
	}

	public String getLocaldeparture() {
		return localdeparture;
	}

	public String getLocalDestinity() {
		return localDestinity;
	}

	public CenterDTO getCenter() {
		return center;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setLocaldeparture(String localdeparture) {
		this.localdeparture = localdeparture;
	}

	public void setLocalDestinity(String localDestinity) {
		this.localDestinity = localDestinity;
	}

	public void setCenter(Center center) {
		this.center = new CenterDTO(center);
	}
	
}
