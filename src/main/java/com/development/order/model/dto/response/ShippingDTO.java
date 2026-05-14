package com.development.order.model.dto.response;

import com.development.order.model.entities.Shipping;

public record ShippingDTO (

	 Long id,
	 String name,
	 String localdeparture,
	 String localDestinity,
	 CenterDTO center
)
{
	public static  ShippingDTO fromDTO(Shipping shipping) {
		return new ShippingDTO(shipping.getId(),
				shipping.getName(),
				shipping.getLocaldeparture(),
				shipping.getLocalDestinity(),
				CenterDTO.fromDTO(shipping.getCenter()));
	}
}
