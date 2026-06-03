package com.development.order.payments;

import com.development.order.model.entities.PackageProduct;
import com.development.order.util.CalcTax;

public class Pix implements CalcTax{
	
	private final Double tax;
	
	public Pix(Double tax) {
		this.tax = tax;
	}

	@Override
	public Double calc(PackageProduct pkg) {
		Double value  = CalcTax.valueTotal(pkg);
		Double result = value * tax;
		return pkg.getProduct().getPrice() + (value - result);
	}

	
	

}
