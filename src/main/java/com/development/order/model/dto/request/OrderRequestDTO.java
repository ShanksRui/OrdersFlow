package com.development.order.model.dto.request;

import java.time.Instant;

public record OrderRequestDTO (

	 Instant mommentBuy,
	 String methodPayment,
	 Long clientID,
	 Long pkgID
)
{
}
	