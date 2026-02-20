package com.development.order.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.development.order.model.entities.Client;

public interface ClientRepository extends JpaRepository<Client, Integer> {

}
