package com.development.order.model.dto;

import java.time.LocalDate;

import com.development.order.model.entities.PackageProduct;
import com.development.order.model.entities.enums.Status;

public class PackageProductDTO {

	private Long id;
	private InfoPackageDTO info;
	private LocalDate dataPrevist;
	private Status status;
	private boolean WeightResultValidaton;
	private Double weightDeclared;

	public PackageProductDTO() {

	}

	public PackageProductDTO(PackageProduct pkg) {
		this.id = pkg.getId();
		this.dataPrevist = pkg.getDataPrevist();
		this.status = pkg.getStatus();
		this.WeightResultValidaton = pkg.getWeightResultValidaton();
		this.weightDeclared = pkg.getWeightDeclared();
		info = new InfoPackageDTO(pkg);
	}

	public Long getId() {
		return id;
	}
	public LocalDate getDataPrevist() {
		return dataPrevist;
	}

	public Status getStatus() {
		return status;
	}

	public boolean isWeightResultValidaton() {
		return WeightResultValidaton;
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

	public void setStatus(Status status) {
		this.status = status;
	}

	public void setWeightResultValidaton(boolean weightResultValidaton) {
		WeightResultValidaton = weightResultValidaton;
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
