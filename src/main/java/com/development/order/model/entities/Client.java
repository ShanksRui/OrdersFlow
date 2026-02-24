package com.development.order.model.entities;

import java.io.Serializable;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "db_Client")
public class Client implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String name;
	private Integer cpf;
	private Integer cep;
	private Instant DataBuy;
	@OneToMany(mappedBy = "client")
	private List<PackageProduct> pkgs = new ArrayList<>();

	public Client() {

	}

	public Client(Integer id, String name, Integer cpf, Integer cep, Instant DataBuy) {
		this.id = id;
		this.name = name;
		this.cpf = cpf;
		this.cep = cep;
		this.DataBuy = DataBuy;
	}

	public List<PackageProduct> getPkgs(){
		return pkgs;
	}
	public Integer getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public Integer getCpf() {
		return cpf;
	}

	public Integer getLocality() {
		return cep;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setCpf(Integer cpf) {
		this.cpf = cpf;
	}

	public void setLocality(Integer cep) {
		this.cep = cep;
	}

	public Instant getDataBuy() {
		return DataBuy;
	}

	public void setDataBuy(Instant dataBuy) {
		DataBuy = dataBuy;
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
		Client other = (Client) obj;
		return Objects.equals(id, other.id);
	}
}
