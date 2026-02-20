package com.development.order.model.entities;

import java.io.Serializable;
import java.util.Objects;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
<<<<<<< HEAD
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;

=======
>>>>>>> 9d7c467 (correcoes do merge anterior,implementei novamente as annotations nas entities , criacao da PKcomposta e configurei o test.properties do h2)
@Entity
public class Product implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
<<<<<<< HEAD
	private Integer id;
	
=======
>>>>>>> 9d7c467 (correcoes do merge anterior,implementei novamente as annotations nas entities , criacao da PKcomposta e configurei o test.properties do h2)
	private String name;
	private Double price;
	private String type;
	@ManyToOne
	@JoinColumn(name = "seller_ID")
	private Seller seller;
	@OneToOne(mappedBy = "product")
	private PackageProduct pckProduct;
	


	public Product () {
		
	}
	
	public Product(Integer id,String name, Double price, String type, Seller seller) {
		this.id = id;
		this.name = name;
		this.price = price;
		this.type = type;
		this.seller = seller;
	}
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
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
		Product other = (Product) obj;
		return Objects.equals(id, other.id);
	}

}
