package com.development.order.model.dto.request;

import java.math.BigDecimal;

import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Digits;

public record ProductRequestDTO (

	 String name,
	 @DecimalMin("0.01")
	 @Digits(integer = 8,fraction = 2)
	 BigDecimal price,
	 String type,
	 Long sellerID
)
{
	
}
