package com.development.order.model.dto.response;

import java.time.LocalDate;

import com.development.order.model.entities.PackageProduct;
import com.development.order.model.entities.enums.PackageStatus;
import com.development.order.util.CalcTax;

public record PackageProductDTO (

	 Long id,
	 Double weightDeclared,
	 LocalDate dataPrevist,
	 PackageStatus status,
	 String Code,
	 Double totalFrete,
	 ProductDTO product,
	 InfoPackageDTO info
	 
)
{
	public static PackageProductDTO fromDTO (PackageProduct pkg) {
		return new PackageProductDTO(pkg.getId(),
				pkg.getWeightDeclared(),
				pkg.getDataPrevist(),
				pkg.getStatus(),
				pkg.getCode(),
				CalcTax.valueTotal(pkg),
				ProductDTO.fromDTO(pkg.getProduct()), InfoPackageDTO.fromIds(pkg));
	}

}
