package com.development.order.model.dto.request;

import com.development.order.model.dto.response.SellerDTO;
import com.development.order.model.entities.Product;
import com.development.order.model.entities.Seller;

public class ProductRequestDTO {

	private String name;
	private Double price;
	private String type;
	private SellerDTO seller;
	
	public ProductRequestDTO() {
		
	}
	
	public ProductRequestDTO(Product product) {
		this.name = product.getName();
		this.price = product.getPrice();
		this.type = product.getType();
	
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

	public SellerDTO getSeller() {
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
		this.seller = new SellerDTO(seller);
	}
}
