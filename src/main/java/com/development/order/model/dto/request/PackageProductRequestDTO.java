package com.development.order.model.dto.request;

import java.time.LocalDate;

import com.development.order.model.entities.enums.PackageStatus;

public class PackageProductRequestDTO {

	private InfoPackageRequestDTO info;
	private LocalDate dataPrevist;
	private PackageStatus status;
	private Double weightDeclared;

	public PackageProductRequestDTO() {

	}

	public PackageProductRequestDTO(Double weight, LocalDate dataPrevist) {
		this.dataPrevist = dataPrevist;
		this.weightDeclared = weight;
		this.status = PackageStatus.CREATED_BY_SELLER;
	}

	public InfoPackageRequestDTO getInfo() {
		return info;
	}

	public LocalDate getDataPrevist() {
		return dataPrevist;
	}

	public PackageStatus getStatus() {
		return status;
	}

	public Double getWeightDeclared() {
		return weightDeclared;
	}

	public void setInfo(InfoPackageRequestDTO info) {
		this.info = info;
	}

	public void setDataPrevist(LocalDate dataPrevist) {
		this.dataPrevist = dataPrevist;
	}

	public void setStatus(PackageStatus status) {
		this.status = status;
	}

	public void setWeightDeclared(Double weightDeclared) {
		this.weightDeclared = weightDeclared;
	}
}
