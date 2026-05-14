package com.development.order.model.dto.response;

import java.time.LocalDate;

import com.development.order.model.entities.PackageProduct;
import com.development.order.model.entities.enums.PackageStatus;

public record PackageProductDTO (

	 Long id,
	 Double weightDeclared,
	 LocalDate dataPrevist,
	 PackageStatus status,
	 ProductDTO product,
	 InfoPackageDTO info
)
{
	public static PackageProductDTO fromDTO (PackageProduct pkg) {
		return new PackageProductDTO(pkg.getId(),
				pkg.getWeightDeclared(),
				pkg.getDataPrevist(),
				pkg.getStatus(),
				ProductDTO.fromDTO(pkg.getProduct()), InfoPackageDTO.fromIds(pkg));
	}

}
