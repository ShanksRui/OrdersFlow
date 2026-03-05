package com.development.order.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.development.order.model.entities.Order;

public interface OrderRepository extends JpaRepository<Order,Long> {

}
