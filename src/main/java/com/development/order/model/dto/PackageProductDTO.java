package com.development.order.model.dto;

import java.time.LocalDate;

import com.development.order.model.entities.PackageProduct;
import com.development.order.model.entities.enums.PackageStatus;

public class PackageProductDTO {

	private Long id;
	private InfoPackageDTO info;
	private LocalDate dataPrevist;
	private PackageStatus status;
	private boolean WeightResultValidation;
	private Double weightDeclared;

	public PackageProductDTO() {

	}

	public PackageProductDTO(PackageProduct pkg) {
		this.id = pkg.getId();
		this.dataPrevist = pkg.getDataPrevist();
		this.status = pkg.getStatus();
		this.WeightResultValidation = pkg.getWeightResultValidation();
		this.weightDeclared = pkg.getWeightDeclared();
		info = new InfoPackageDTO(pkg);
	}

	public Long getId() {
		return id;
	}
	public LocalDate getDataPrevist() {
		return dataPrevist;
	}

	public PackageStatus getStatus() {
		return status;
	}

	public boolean isWeightResultValidation() {
		return WeightResultValidation;
	}

	public Double getWeightDeclared() {
		return weightDeclared;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setDataPrevist(LocalDate dataPrevist) {
		this.dataPrevist = dataPrevist;
	}

	public void setStatus(PackageStatus status) {
		this.status = status;
	}

	public void setWeightResultValidation(boolean weightResultValidation) {
		WeightResultValidation = weightResultValidation;
	}

	public void setWeightDeclared(Double weightDeclared) {
		this.weightDeclared = weightDeclared;
	}

	public InfoPackageDTO getInfo() {
		return info;
	}

	public void setInfo(InfoPackageDTO info) {
		this.info = info;
	}
}
