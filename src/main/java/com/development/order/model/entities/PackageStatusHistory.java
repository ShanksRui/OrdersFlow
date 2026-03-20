package com.development.order.model.entities;

import java.io.Serializable;
import java.time.Instant;

import com.development.order.model.entities.enums.PackageStatus;

import jakarta.persistence.Entity;

@Entity
public class PackageStatusHistory  implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private Long id;
	private PackageStatus status;
	private Instant dataTime;
	private Long packageProduct;
	
	public PackageStatusHistory() {
		
	}
	
	public PackageStatusHistory(Long id, PackageStatus status, Instant dataTime, Long packageProduct) {
		this.id = id;
		this.status = status;
		this.dataTime = dataTime;
		this.packageProduct = packageProduct;
	}

	public Long getId() {
		return id;
	}

	public PackageStatus getStatus() {
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

	public void setStatus(PackageStatus status) {
		this.status = status;
	}

	public void setDataTime(Instant dataTime) {
		this.dataTime = dataTime;
	}

	public void setPackageProduct(Long packageProduct) {
		this.packageProduct = packageProduct;
	}
}
