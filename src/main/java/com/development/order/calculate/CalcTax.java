package com.development.order.calculate;

import com.development.order.model.dto.response.PackageProductDTO;
import com.development.order.model.entities.enums.FreightRange;

public interface CalcTax {

	    static double valueTotal (PackageProductDTO packageProductDTO) {
	    FreightRange f	= FreightRange.calculate(packageProductDTO.weightDeclared());
		Double price = f.getPrice();
		Double tax = f.getTax();
		return price += (price * tax);	
	}
}
