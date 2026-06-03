package com.development.order.model.dto.response;

import com.development.order.model.entities.PackageProduct;

public record InfoPackageDTO (

	 Long center,
	 Long shipping,
	 Long order	
 ){
	public static InfoPackageDTO fromIds(PackageProduct pkg) {
		return new InfoPackageDTO(
				pkg.getCenter().getId(),
				pkg.getShipping().getId(),
				pkg.getOrder().getId());
	}
}
