package com.development.order.model.dto.request;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

import com.development.order.model.dto.response.PackageProductDTO;

public class OrderRequestDTO {

	private Instant mommentBuy;
	private Long clientID;

	private List<PackageProductDTO> pkgs = new ArrayList<>();

	public OrderRequestDTO() {

	}

	public OrderRequestDTO(Long id) {
		this.setClientID(id);
		this.mommentBuy = Instant.now();
	}

	public Instant getMommentBuy() {
		return mommentBuy;
	}

	public void setMommentBuy(Instant mommentBuy) {
		this.mommentBuy = mommentBuy;
	}

	public Long getClientID() {
		return clientID;
	}

	private void setClientID(Long id) {
		this.clientID = id;

	}

}
