package com.development.order.model.entities;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import com.development.order.calculate.CalcTax;
import com.development.order.model.entities.enums.FreightRange;
import com.development.order.model.entities.enums.PackageStatus;
import com.development.order.services.exceptions.NotFoundResourceException;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;

@Entity
public class PackageProduct implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@ManyToOne
	@JoinColumn(name = "seller_id")
	private Seller seller;
	@ManyToOne
	@JoinColumn(name = "product_id")
	private Product product;
	@ManyToOne
	@JoinColumn(name = "center_id")
	private Center center;
	@ManyToOne
	@JoinColumn(name = "shipping_id")
	private Shipping shipping;
	@ManyToOne
	@JoinColumn(name = "order_id")
	private Order order;
	@OneToMany(mappedBy = "packageProduct", cascade = CascadeType.ALL)
	private List<PackageStatusHistory> historys = new ArrayList<>();

	private LocalDate dataPrevist;
	private PackageStatus status;
	private Double weightDeclared;

	public PackageProduct() {
	}

	public PackageProduct(Long id, Double weightD, LocalDate dataPrevist, Product product, Center center,
			PackageStatus status) {
		this.id = id;
		setSeller(product);
		this.weightDeclared = weightD;
		this.product = product;
		this.status = status;
		this.center = center;
		this.dataPrevist = dataPrevist;
	}

	public void addHistoryStatus(PackageStatusHistory psh) {
		if (getStatus() == null) {
			throw new IllegalStateException("shipping status must be defined before registering history");
		}
		psh.setStatus(status);
		psh.setPackageProduct(this);
		historys.add(psh);
	}

	public Shipping getShipping() {
		return shipping;
	}

	public Order getOrder() {
		return order;
	}

	public void setSeller(Seller seller) {
		this.seller = seller;
	}

	public void setOrder(Order order) {
		this.order = order;
	}

	public void setShipping(Shipping shipping) {
		this.shipping = shipping;
	}

	public Center getCenter() {
		return center;
	}

	public void setCenter(Center center) {
		this.center = center;
	}

	public Double getWeightDeclared() {
		return weightDeclared;
	}
	
	public Long getId() {
		return id;
	}

	public Seller getSeller() {
		return seller;
	}

	public Product getProduct() {
		return product;
	}

	public PackageStatus getStatus() {
		return status;
	}

	public void setWeightDeclared(Double weightDeclared) {
		this.weightDeclared = weightDeclared;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setSeller(Product product) {
		if (product == null)
			throw new NotFoundResourceException("product cannot be null");
		this.product = product;
		this.seller = product.getSeller();
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public void setStatus(PackageStatus status) {
		this.status = status;
	}

	public LocalDate getDataPrevist() {
		return dataPrevist;
	}

	public void setDataPrevist(LocalDate dataPrevist) {
		this.dataPrevist = dataPrevist;
	}
	
  
	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		PackageProduct other = (PackageProduct) obj;
		return Objects.equals(id, other.id);
	}

}
