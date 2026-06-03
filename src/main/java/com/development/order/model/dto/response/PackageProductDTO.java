package com.development.order.model.dto.response;

import java.math.BigDecimal;
import java.time.LocalDate;

import com.development.order.model.entities.PackageProduct;
import com.development.order.model.entities.enums.PackageStatus;
import com.development.order.payments.FactoryPayments;
import com.development.order.util.CalcTax;

public record PackageProductDTO (

	 Long id,
	 Double weightDeclared,
	 LocalDate dataPrevist,
	 PackageStatus status,
	 String Code,
	 BigDecimal valueTotal,
	 BigDecimal totalFrete,
	 String methodPayment,
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
				pkg.getValueTotal(),
				CalcTax.valueTotal(pkg),
				pkg.getOrder().getMethodPayment(),
				ProductDTO.fromDTO(pkg.getProduct()), InfoPackageDTO.fromIds(pkg));
	}

}
