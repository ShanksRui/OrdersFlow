package com.development.order.model.dto.request;

import java.math.BigDecimal;

import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Digits;

public record ShippingRequestDTO (

	 String name,
	 String localdeparture,
	 String localDestinity,
	 String cnpj,
	 @DecimalMin("0.01")
	 @Digits(integer = 8,fraction = 2)
	 BigDecimal priceFrete,	
	 Long centerID
)
{
	
}
