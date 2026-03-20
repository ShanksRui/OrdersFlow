package com.development.order.model.entities;

import java.io.Serializable;
import java.time.Instant;
import java.util.Objects;

import com.development.order.model.entities.enums.ShippingStatus;

import jakarta.persistence.Entity;
@Entity
public class ShippingStatusHistory implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private Long id;
	private ShippingStatus status;
	private Instant dataTime;
	private Long packageProduct;
	
	public ShippingStatusHistory() {
		
	}
	
	public ShippingStatusHistory(Long id, ShippingStatus status, Instant dataTime, Long packageProduct) {
		this.id = id;
		this.status = status;
		this.dataTime = dataTime;
		this.packageProduct = packageProduct;
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

	public Long getPackageProduct() {
		return packageProduct;
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

	public void setPackageProduct(Long packageProduct) {
		this.packageProduct = packageProduct;
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
