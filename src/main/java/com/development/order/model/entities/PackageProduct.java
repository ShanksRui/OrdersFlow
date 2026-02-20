package com.development.order.model.entities;

import java.io.Serializable;
import java.time.Instant;
import java.util.Objects;

import com.development.order.model.entities.pk.PackagePK;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;

@Entity
public class PackageProduct implements Serializable {

    private static final long serialVersionUID = 1L;

    private Double weightDeclared;
    private Double weightValidated;

    @EmbeddedId
    private PackagePK id = new PackagePK();

    private Instant createdAt;

    @OneToOne
    @JoinColumn(name = "product_id")
    private Product product;

    public PackageProduct() {
    }

    public PackageProduct(Double weightDeclared,
                          Double weightValidated,
                          Integer sellerId,
                          Integer clientId,
                          Instant createdAt,
                          Product product) {

        this.weightDeclared = weightDeclared;
        this.weightValidated = weightValidated;
        this.id.setSellerId(sellerId);
        this.id.setClientId(clientId);
        this.createdAt = createdAt;
        this.product = product;
    }

    public Double getWeightDeclared() {
        return weightDeclared;
    }

    public void setWeightDeclared(Double weightDeclared) {
        this.weightDeclared = weightDeclared;
    }

    public Double getWeightValidated() {
        return weightValidated;
    }

    public void setWeightValidated(Double weightValidated) {
        this.weightValidated = weightValidated;
    }

    public Instant getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Instant createdAt) {
        this.createdAt = createdAt;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Integer getSellerId() {
        return id.getSellerId();
    }

    public Integer getClientId() {
        return id.getClientId();
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (!(obj instanceof PackageProduct))
            return false;
        PackageProduct other = (PackageProduct) obj;
        return Objects.equals(id, other.id);
    }
}