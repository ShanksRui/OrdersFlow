package com.development.order.model.dto;

import java.time.Instant;

import com.development.order.model.entities.Client;
import com.development.order.model.entities.Order;

public class OrderDTO {

	private Long id;
	private Instant mommentBuy;
	private ClientDTO client;
	
	public OrderDTO() {
		
	}
	public OrderDTO(Order order) {
		this.id = order.getId();
		this.mommentBuy = order.getMommentBuy();
		setClient(order.getClient());
	}
	
	public Long getId() {
		return id;
	}
	public Instant getMommentBuy() {
		return mommentBuy;
	}
	public ClientDTO getClient() {
		return client;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public void setMommentBuy(Instant mommentBuy) {
		this.mommentBuy = mommentBuy;
	}
	public void setClient(Client client) {
		this.client = new ClientDTO(client);
	}
	
}
