package com.development.order.model.entities;

import java.io.Serializable;
import java.time.Instant;

import com.development.order.model.entities.enums.PackageStatus;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class PackageStatusHistory  implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Enumerated(EnumType.STRING)
	private PackageStatus status;
	private Instant dataTime;
	@ManyToOne
	@JoinColumn(name = "packageProduct_id")
	private PackageProduct packageProduct;
	
	public PackageStatusHistory() {
		
	}
	
	public PackageStatusHistory(Long id, Instant dataTime) {
		this.id = id;
		this.dataTime = dataTime;
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

	public PackageProduct getPackageProduct() {
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

	public void setPackageProduct(PackageProduct packageProduct) {
		this.packageProduct = packageProduct;
	}
}
