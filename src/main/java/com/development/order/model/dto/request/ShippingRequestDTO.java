package com.development.order.model.dto.request;

public class ShippingRequestDTO {

	private String name;
	private String localdeparture;
	private String localDestinity;
	private Long centerID;

	public ShippingRequestDTO(String name, String localDeparture, String localDestinity, Long id) {
		this.name = name;
		this.localdeparture = localDeparture;
		this.localDestinity = localDestinity;
		this.centerID = id;

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

	public void setName(String name) {
		this.name = name;
	}

	public void setLocaldeparture(String localdeparture) {
		this.localdeparture = localdeparture;
	}

	public void setLocalDestinity(String localDestinity) {
		this.localDestinity = localDestinity;
	}

	public Long getCenterID() {
		return centerID;
	}

	public void setCenterID(Long centerID) {
		this.centerID = centerID;
	}

}
