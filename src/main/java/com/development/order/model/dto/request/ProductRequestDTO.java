package com.development.order.model.dto.request;

import com.development.order.model.dto.response.SellerDTO;
import com.development.order.model.entities.Seller;

public class ProductRequestDTO {

	private String name;
	private Double price;
	private String type;
	private Long sellerID;

	public ProductRequestDTO() {

	}

	public ProductRequestDTO(String name, Double price, String type, Long sellerID) {
		this.name = name;
		this.price = price;
		this.type = type;
		this.setSellerID(sellerID);
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

	public void setName(String name) {
		this.name = name;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Long getSellerID() {
		return sellerID;
	}

	public void setSellerID(Long sellerID) {
		this.sellerID = sellerID;
	}
}
