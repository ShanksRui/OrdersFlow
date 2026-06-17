package com.development.order.payments;

import java.math.BigDecimal;

import com.development.order.model.entities.PackageProduct;
import com.development.order.util.CalcTax;

public class Pix implements CalcTax{
	
	private final BigDecimal tax;
	
	public Pix(Double tax) {
		this.tax = BigDecimal.valueOf(tax);
	}

	@Override
	public BigDecimal calc(PackageProduct pkg) {
		BigDecimal value  = CalcTax.valueTotal(pkg);
		BigDecimal result = value.multiply(tax);
		BigDecimal price = pkg.getProduct().getPrice();
		return price.add(value.subtract(result));
	}

	
	

}
