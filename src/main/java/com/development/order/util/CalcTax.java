package com.development.order.util;

import com.development.order.model.entities.PackageProduct;
import com.development.order.model.entities.enums.FreightRange;

public interface CalcTax {

	    static double valueTotal (PackageProduct packageProduct) {
	    FreightRange f	= FreightRange.calculate(packageProduct.getWeightDeclared());
		Double price = f.getPrice();
		Double tax = f.getTax();
		Double priceFrete = packageProduct.getShipping().getPrice();
		return price += (price * tax + priceFrete);	
	}
}
