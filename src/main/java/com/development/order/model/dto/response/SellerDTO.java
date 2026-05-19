package com.development.order.model.dto.response;

import com.development.order.model.entities.Seller;

public record SellerDTO (

	 Long id,
	 String name,
	 Integer cnpj
)
{
	public static SellerDTO fromDTO(Seller seller) {
		return new SellerDTO(
				seller.getId(),
				seller.getName(),
				seller.getCnpj());
}
}

