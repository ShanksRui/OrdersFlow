package com.development.order.model.entities;

import java.util.Objects;

import jakarta.persistence.Embeddable;

@Embeddable
public class PackageIds {

	private Integer SellerId;
	private Integer ClientId;
	
	
	public Integer getSellerId() {
		return SellerId;
	}
	public void setSellerId(Integer sellerId) {
		SellerId = sellerId;
	}
	public Integer getClientId() {
		return ClientId;
	}
	public void setClientId(Integer clientId) {
		ClientId = clientId;
	}
	@Override
	public int hashCode() {
		return Objects.hash(ClientId, SellerId);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		PackageIds other = (PackageIds) obj;
		return Objects.equals(ClientId, other.ClientId) && Objects.equals(SellerId, other.SellerId);
	}	
}
