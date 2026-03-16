package com.development.order.model.dto;

import com.development.order.model.entities.Product;
import com.development.order.model.entities.Seller;

public class ProductDTO {

	private Long id;
	private String name;
	private Double price;
	private String type;
	private SellerDTO seller;

	public ProductDTO() {

	}

	public ProductDTO(Product product) {
		this.id = product.getId();
		this.name = product.getName();
		this.price = product.getPrice();
		this.type = product.getType();
		setSeller(product.getSeller());
	}

	public Long getId() {
		return id;
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

	public void setId(Long id) {
		this.id = id;
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
