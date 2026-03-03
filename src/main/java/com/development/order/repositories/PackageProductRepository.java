package com.development.order.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.development.order.model.entities.PackageProduct;

public interface PackageProductRepository extends JpaRepository<PackageProduct, Long>{

}
