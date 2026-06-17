package com.development.order.util;

import java.math.BigDecimal;

import com.development.order.model.entities.PackageProduct;
import com.development.order.model.entities.enums.FreightRange;

public interface CalcTax {
	
	    static BigDecimal valueTotal (PackageProduct packageProduct) {
	    FreightRange f	= FreightRange.calculate(packageProduct.getWeightDeclared());
		BigDecimal price = BigDecimal.valueOf(f.getPrice());
		BigDecimal tax = BigDecimal.valueOf(f.getTax());
		BigDecimal priceFrete = packageProduct.getShipping().getPrice();
		return price.add(price.multiply(tax).add(priceFrete));
	}
	    BigDecimal calc(PackageProduct pkg);
}
