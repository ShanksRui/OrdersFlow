package com.development.order.model.dto.request;

import java.time.Instant;

public record OrderRequestDTO (

	 Instant mommentBuy,
	 Long clientID,
	 Long pkgID
)
{
}
	