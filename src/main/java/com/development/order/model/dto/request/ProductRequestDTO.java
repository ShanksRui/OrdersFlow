package com.development.order.model.dto.request;

public record ProductRequestDTO (

	 String name,
	 Double price,
	 String type,
	 Long sellerID
)
{
	
}
