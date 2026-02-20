package com.development.order.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.development.order.model.entities.Shipping;

public interface ShippingRepository extends JpaRepository<Shipping, Integer> {

}
