package com.development.order.model.entities.pk;

import java.io.Serializable ;
import java.util.Objects;

import jakarta.persistence.Embeddable;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;

@Embeddable
public class PackagePK implements Serializable {

	private static final long serialVersionUID = 1L;

	@OneToOne
	@JoinColumn(name = "client_ID")
	private Integer clientId;
	@OneToOne
	@JoinColumn(name = "seller_ID")
	private Integer sellerId;

	public Integer getClientId() {
		return clientId;
	}

	public Integer getSellerId() {
		return sellerId;
	}

	public void setClientId(Integer clientId) {
		this.clientId = clientId;
	}

	public void setSellerId(Integer sellerId) {
		this.sellerId = sellerId;
	}

	@Override
	public int hashCode() {
		return Objects.hash(clientId, sellerId);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		PackagePK other = (PackagePK) obj;
		return Objects.equals(clientId, other.clientId) && Objects.equals(sellerId, other.sellerId);
	}
	
}
