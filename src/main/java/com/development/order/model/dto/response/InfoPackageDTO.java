package com.development.order.model.dto.response;

import com.development.order.model.entities.PackageProduct;

public record InfoPackageDTO (

	 Long seller,
	 Long product,
	 Long center,
	 Long shipping,
	 Long order	
 ){
	public static InfoPackageDTO fromIds(PackageProduct pkg) {
		return new InfoPackageDTO(
				pkg.getSeller().getId(),
				pkg.getProduct().getId(), 
				pkg.getCenter().getId(),
				pkg.getShipping().getId(),
				pkg.getOrder().getId());
	}
}
