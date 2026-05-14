package com.development.order.model.dto.response;

import com.development.order.model.entities.Product;

public record ProductDTO (

	 Long id,
     String code,
	 String name,
	 Double price,
	 String type,
	 SellerDTO seller
)
{	

	public static ProductDTO fromDTO(Product product) {
		return new ProductDTO(
				product.getId(), 
				product.getCode(),
				product.getName(), 
				product.getPrice(), 
				product.getType(), 
				SellerDTO.fromDTO(product.getSeller()));
	
   }
}
