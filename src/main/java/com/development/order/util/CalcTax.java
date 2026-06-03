package com.development.order.util;

import java.math.BigDecimal;

import com.development.order.model.entities.PackageProduct;
import com.development.order.model.entities.enums.FreightRange;

public interface CalcTax {
	
	    static BigDecimal valueTotal (PackageProduct packageProduct) {
	    FreightRange f	= FreightRange.calculate(packageProduct.getWeightDeclared());
		Double price = f.getPrice();
		Double tax = f.getTax();
		Double priceFrete = packageProduct.getShipping().getPrice();
		return price += (price * tax + priceFrete);	
	}
	    Double calc(PackageProduct pkg);
}
