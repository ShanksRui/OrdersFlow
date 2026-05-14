package com.development.order.model.dto.response;

import java.time.Instant;

import com.development.order.model.entities.ShippingStatusHistory;
import com.development.order.model.entities.enums.ShippingStatus;

public record ShippingStatusHistoryDTO (

	 Long id,
	 ShippingStatus status,
	 Instant dataTime,
	 Long shippingID
)
{
	public static ShippingStatusHistoryDTO fromDTO(ShippingStatusHistory status) {
		return new ShippingStatusHistoryDTO(
				status.getId(),
				status.getStatus(),
				status.getDataTime(),
				status.getShipping().getId());
	}
}

	