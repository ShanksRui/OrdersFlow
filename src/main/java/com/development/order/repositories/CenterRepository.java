package com.development.order.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.development.order.model.entities.Center;

public interface CenterRepository extends JpaRepository<Center, Long>{

}
