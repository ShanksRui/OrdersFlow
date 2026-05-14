package com.development.order.model.dto.response;

import com.development.order.model.entities.Center;

public record CenterDTO (

	 Long id,
	 String name,
	 Integer quantityPackages,
	 Integer limitPackages
) {	
	public static CenterDTO fromDTO(Center center) {
		return new CenterDTO(center.getId(), center.getName(),
				center.getQuantityPackages(), center.getLimitPackages());
	}}