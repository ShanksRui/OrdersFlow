package com.development.order.model.entities.enums;

public enum FreightRange {

	LIGHT(5.0, 10.0, 0.1), 
	MEDIUM(10.0, 20.0, 0.15), 
	HEAVY(25.0, 35.0, 0.2), 
	EXTRA(Double.MAX_VALUE, 50.0, 0.2);

	private Double maxHeight;
	private Double price;
	private Double tax;

	FreightRange(Double maxHeight, Double price, Double tax) {
		this.maxHeight = maxHeight;
		this.price = price;
		this.tax = tax;
	}

	public Double getPrice() {
		return price;
	}

	public Double getMaxWeight() {
		return maxHeight;
	}

	public Double getTax() {
		return tax;
	}

	public static Double calculate(Double weight) {
		for (FreightRange f : FreightRange.values())
			if (weight <= f.getMaxWeight()) {
				return f.getPrice();
			}
		return 0.0;
	}

	public static Double whichTax(Double w) {
		for (FreightRange f : FreightRange.values())
			if (w <= f.getMaxWeight()) {
				return f.getTax();
			}
		return 0.0;
	}
}
