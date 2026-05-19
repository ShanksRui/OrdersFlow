package com.development.order.model.dto.response;

import java.time.Instant;

import com.development.order.model.entities.Order;

public record OrderDTO (

		 Long id,
		 Instant mommentBuy,
		 String code,
		 ClientDTO client
		
	)	
{	
		public static OrderDTO fromDTO(Order order) {
			return new OrderDTO(
					order.getId(), 
					order.getMommentBuy(),
					order.getCode(),
					ClientDTO.fromDTO(order.getClient()));
					

		}
}

		