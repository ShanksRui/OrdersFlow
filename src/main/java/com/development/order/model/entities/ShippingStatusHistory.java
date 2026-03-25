package com.development.order.model.entities;

import java.io.Serializable;
import java.time.Instant;
import java.util.Objects;

import com.development.order.model.entities.enums.ShippingStatus;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
@Entity
public class ShippingStatusHistory implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Enumerated(EnumType.STRING)
	private ShippingStatus status;
	private Instant dataTime;
	
	@ManyToOne
	@JoinColumn(name = "shipping_id")
	private Shipping shipping;
	
	public ShippingStatusHistory() {
		
	}
	
	public ShippingStatusHistory(Long id, ShippingStatus status, Instant dataTime, Shipping shipping) {
		this.id = id;
		this.status = status;
		this.dataTime = dataTime;
		this.shipping = shipping;
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

	public void setId(Long id) {
		this.id = id;
	}

	public void setStatus(ShippingStatus status) {
		this.status = status;
	}

	public void setDataTime(Instant dataTime) {
		this.dataTime = dataTime;
	}
	
	public Shipping getShipping() {
		return shipping;
	}

	public void setShipping(Shipping shipping) {
		this.shipping = shipping;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ShippingStatusHistory other = (ShippingStatusHistory) obj;
		return Objects.equals(id, other.id);
	}
}
