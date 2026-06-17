package com.development.order.payments;

import java.math.BigDecimal;

import com.development.order.model.entities.PackageProduct;
import com.development.order.util.CalcTax;

public class Card implements CalcTax {

	private final BigDecimal tax;

	public Card(Double tax) {
		this.tax = BigDecimal.valueOf(tax);
	}

	@Override
	public BigDecimal calc(PackageProduct pkg) {
		BigDecimal value  = CalcTax.valueTotal(pkg);
		BigDecimal calc = value.multiply(tax); 
		BigDecimal price = pkg.getProduct().getPrice();
		return price.add(value.add(calc));
	}

}
