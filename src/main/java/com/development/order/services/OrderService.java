package com.development.order.services;

import java.util.List;
import java.util.Optional;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import com.development.order.model.dto.request.OrderRequestDTO;
import com.development.order.model.dto.response.OrderDTO;
import com.development.order.model.entities.Order;
import com.development.order.payments.FactoryPayments;
import com.development.order.repositories.OrderRepository;
import com.development.order.services.exceptions.CodeExistingException;
import com.development.order.services.exceptions.NotFoundResourceException;
import com.development.order.util.CalcTax;
import com.development.order.util.GeneratorCode;

@Service
public class OrderService {

	private OrderRepository repository;
	private ClientService service;

	public OrderService(OrderRepository repository,ClientService service) {
		this.repository = repository;
		this.service = service;
	}

		public Order insert(OrderRequestDTO dto) {
			Order order = new Order();
			order.setClient(service.findByID(dto.clientID()));
			order.setMommentBuy(dto.mommentBuy());
			order.setMethodPayment(dto.methodPayment());
			for (int i = 0; i < 5; i++) {
				String code = GeneratorCode.generatorFromCode();
				
				if (code == null || code.isBlank()) {
		            throw new IllegalStateException("generated code is null");
		        }
				
				order.setCode(code);
				
			
				try {
					return repository.save(order);
				} catch (DataIntegrityViolationException e) {
		            System.out.println(e.getMessage());
		            
		            if (!e.getMessage().contains("unique")) {
		                throw e;
		            }
		            System.out.println("generating new code!");
				}		
			}
			throw new CodeExistingException("error in generating for code unique");
		}

	public List<Order> findAll() {
		return repository.findAll();
	}

	public Order findById(Long id) {
		Optional<Order> op = repository.findById(id);
		return op.orElseThrow(() -> new NotFoundResourceException(id));
	}

	public void delete(Long id) {
		if (!repository.existsById(id)) {
			throw new NotFoundResourceException(id);
		}
		repository.deleteById(id);
	}

	public OrderDTO update(Long id, Order order) {
		Order entity = findById(id);
		dataUpdate(entity, order);
		repository.save(entity);
		return OrderDTO.fromDTO(entity);
	}

	public void dataUpdate(Order entity, Order order) {
		entity.setClient(order.getClient());
		entity.setMommentBuy(order.getMommentBuy());

	}
}
