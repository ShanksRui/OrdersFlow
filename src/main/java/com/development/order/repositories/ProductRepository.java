package com.development.order.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.development.order.model.entities.Product;

public interface ProductRepository extends JpaRepository<Product, Integer>{

}
