package com.development.order.model.dto.response;

import java.math.BigDecimal;

import com.development.order.model.entities.Shipping;
import com.development.order.model.entities.enums.ShippingStatus;

public record ShippingDTO (

	 Long id,
	 String name,
	 String localdeparture,
	 String localDestinity,
	 BigDecimal priceFrete,
	 ShippingStatus status,
	 CenterDTO center
)
{
	public static  ShippingDTO fromDTO(Shipping shipping) {
		return new ShippingDTO(shipping.getId(),
				shipping.getName(),
				shipping.getLocaldeparture(),
				shipping.getLocalDestinity(),
				shipping.getPrice(),
				shipping.getStatus(),
				CenterDTO.fromDTO(shipping.getCenter()));
	}
}
