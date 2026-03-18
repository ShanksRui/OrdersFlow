package com.development.order.model.dto;

import com.development.order.model.entities.PackageProduct;

public class InfoPackageDTO {

	private Long client;
	private Long seller;
	private Long product;
	private Long center;
	private Long shipping;
	private Long order;
	
	
	public InfoPackageDTO(PackageProduct pkg) {
		this.client = pkg.getClient().getId();
		this.seller = pkg.getSeller().getId();
		this.product = pkg.getProduct().getId();
		this.center = pkg.getCenter().getId();
		this.shipping = pkg.getShipping().getId();
		this.order = pkg.getOrder().getId();
	}
	public Long getClient() {
		return client;
	}
	public Long getSeller() {
		return seller;
	}
	public Long getProduct() {
		return product;
	}
	public Long getCenter() {
		return center;
	}
	public Long getShipping() {
		return shipping;
	}
	public Long getOrder() {
		return order;
	}
	public void setClient(Long client) {
		this.client = client;
	}
	public void setSeller(Long seller) {
		this.seller = seller;
	}
	public void setProduct(Long product) {
		this.product = product;
	}
	public void setCenter(Long center) {
		this.center = center;
	}
	public void setShipping(Long shipping) {
		this.shipping = shipping;
	}
	public void setOrder(Long order) {
		this.order = order;
	}
}
