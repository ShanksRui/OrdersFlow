package com.development.order.model.dto.response;

import com.development.order.model.entities.PackageProduct;

public record InfoPackageDTO {

	private Long client;
	private Long seller;
	private Long product;
	private Long center;
	private Long shipping;
	private Long order;
	
	
	public InfoPackageDTO(PackageProduct pkg) {
		this.seller = pkg.getSeller().getId();
		this.product = pkg.getProduct().getId();
		this.center = pkg.getCenter().getId();
		this.shipping = pkg.getShipping().getId();
		this.order = pkg.getOrder().getId();
	}
}
