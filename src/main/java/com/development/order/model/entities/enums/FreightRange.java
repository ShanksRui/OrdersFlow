package com.development.order.model.entities.enums;

public enum FreightRange {

	LIGHT(5.0,10.0),
	MEDIUM(10.0,20.0),
	HEAVY(25.0,35.0),
	EXTRA(Double.MAX_VALUE,50.0);
	
	private Double maxHeight;
	private Double price;
	
	FreightRange(Double maxHeight,Double price){
		this.maxHeight = maxHeight;
		this.price = price;
	}
	
	public Double getPrice() {
		return price;
	}
	public Double getMaxWeight() {
		return maxHeight;
	}
}
