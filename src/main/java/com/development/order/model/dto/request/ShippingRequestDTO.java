package com.development.order.model.dto.request;

public record ShippingRequestDTO (

	 String name,
	 String localdeparture,
	 String localDestinity,
	 String cnpj,
	 Double priceFrete,	
	 Long centerID
)
{
	
}
