package com.development.order.model.entities;

public class Product {

	private String name;
	private Double price;
	private String type;
	private Seller seller;
	


	public Product () {
		
	}
	
	public Product(String name, Double price, String type, Seller seller) {
		this.name = name;
		this.price = price;
		this.type = type;
		this.seller = seller;
	}

	public String getName() {
		return name;
	}

	public Double getPrice() {
		return price;
	}

	public String getType() {
		return type;
	}

	public Seller getSeller() {
		return seller;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public void setType(String type) {
		this.type = type;
	}

	public void setSeller(Seller seller) {
		this.seller = seller;
	}

}
