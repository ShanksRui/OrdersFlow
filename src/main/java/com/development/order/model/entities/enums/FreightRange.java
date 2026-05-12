package com.development.order.model.entities.enums;

public enum FreightRange {

	LIGHT(5.0, 10.0, 0.1), 
	MEDIUM(10.0, 20.0, 0.15), 
	HEAVY(20.0, 35.0, 0.2), 
	EXTRA(Double.MAX_VALUE, 50.0, 0.2);

	private Double maxHeight;
	private Double price;
	private Double tax;

	FreightRange(Double maxWeight, Double price, Double tax) {
		this.maxHeight = maxWeight;
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

	public static FreightRange calculate(Double weight) {
		for (FreightRange f : FreightRange.values())
			if (weight <= f.getMaxWeight()) {
				return f;
			}
		return EXTRA;
	}

}
