package com.development.order.model.dto;

import java.time.Instant;

import com.development.order.model.entities.ShippingStatusHistory;
import com.development.order.model.entities.enums.ShippingStatus;

public class ShippingStatusHistoryDTO {

	private Long id;
	private ShippingStatus status;
	private Instant dataTime;
	private Long shippingID;
	
	public ShippingStatusHistoryDTO() {
		
	}
	
	public ShippingStatusHistoryDTO(ShippingStatusHistory ssh) {
		this.id = ssh.getId();
		this.status = ssh.getStatus();
		this.dataTime = ssh.getDataTime();
		this.shippingID = ssh.getShipping().getId();
	}

	public Long getId() {
		return id;
	}

	public ShippingStatus getStatus() {
		return status;
	}

	public Instant getDataTime() {
		return dataTime;
	}

	public Long getShippingID() {
		return shippingID;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setStatus(ShippingStatus status) {
		this.status = status;
	}

	public void setDataTime(Instant dataTime) {
		this.dataTime = dataTime;
	}

	public void setShippingID(Long shippingID) {
		this.shippingID = shippingID;
	}
	
}
