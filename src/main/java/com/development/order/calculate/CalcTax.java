package com.development.order.calculate;

import com.development.order.model.dto.response.PackageProductDTO;
import com.development.order.model.entities.enums.FreightRange;

public interface CalcTax {

	    static double valueTotal (PackageProductDTO packageProductDTO) {
	    FreightRange f	= FreightRange.calculate(packageProductDTO.getWeightDeclared());
		Double price = f.getPrice();
		Double tax = f.getTax();
		price += (price * tax);
		return price;
	}
	
}
