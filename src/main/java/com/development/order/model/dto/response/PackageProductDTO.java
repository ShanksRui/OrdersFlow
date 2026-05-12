package com.development.order.model.dto.response;

import java.time.LocalDate;

import com.development.order.calculate.CalcTax;
import com.development.order.model.entities.PackageProduct;
import com.development.order.model.entities.enums.PackageStatus;

public class PackageProductDTO {

	private Long id;
	private ProductDTO product;
	private InfoPackageDTO info;
	private LocalDate dataPrevist;
	private PackageStatus status;
	private Double weightDeclared;

	public PackageProductDTO() {

	}

	public PackageProductDTO(PackageProduct pkg) {
		this.id = pkg.getId();
		this.dataPrevist = pkg.getDataPrevist();
		this.status = pkg.getStatus();
		this.weightDeclared = pkg.getWeightDeclared();
		info = new InfoPackageDTO(pkg);
		this.product = new ProductDTO(pkg.getProduct());
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

	public void setWeightDeclared(Double weightDeclared) {
		this.weightDeclared = weightDeclared;
	}

	public InfoPackageDTO getInfo() {
		return info;
	}

	public void setInfo(InfoPackageDTO info) {
		this.info = info;
	}
	public Double getPriceTotal() {
		return CalcTax.valueTotal(this);
	}
}
