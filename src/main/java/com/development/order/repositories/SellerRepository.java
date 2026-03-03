package com.development.order.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.development.order.model.entities.Seller;

public interface SellerRepository extends JpaRepository<Seller, Long>{

}
