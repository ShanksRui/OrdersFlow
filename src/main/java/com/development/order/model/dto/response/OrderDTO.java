package com.development.order.model.dto.response;

import java.time.Instant;

import com.development.order.model.entities.Order;

public record OrderDTO (

		 Long id,
		 Instant mommentBuy,
		 ClientDTO client
	)	
{	
		public static OrderDTO fromDTO(Order order) {
			return new OrderDTO(
					order.getId(), 
					order.getMommentBuy(),
					ClientDTO.fromDTO(order.getClient()));
		}
}

		