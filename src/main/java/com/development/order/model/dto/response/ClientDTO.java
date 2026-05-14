package com.development.order.model.dto.response;

import com.development.order.model.entities.Client;

public record ClientDTO (

	 Long id,
	 String name,
	 Integer locality
)	
{
	public static ClientDTO fromDTO(Client client) {
		return new ClientDTO(client.getId(), client.getName(), client.getLocality());
	}
}
