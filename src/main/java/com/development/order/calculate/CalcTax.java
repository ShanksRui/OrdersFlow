package com.development.order.calculate;

import com.development.order.model.dto.response.PackageProductDTO;
import com.development.order.model.entities.enums.FreightRange;

public interface CalcTax {

	    static double valueTotal (PackageProductDTO packageProductDTO) {
		Double price =FreightRange.calculate(packageProductDTO.getWeightDeclared());
		Double tax = FreightRange.whichTax(packageProductDTO.getWeightDeclared());
		price += (price * tax);
		return price;
	}
	
}
