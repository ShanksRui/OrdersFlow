package com.development.order.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;

import com.development.order.model.entities.Client;
import com.development.order.model.entities.Product;
import com.development.order.model.entities.Seller;
import com.development.order.services.ClientService;
import com.development.order.services.ProductService;
import com.development.order.services.SellerService;

public class SeedingConfig implements CommandLineRunner{

    @Autowired
	private ClientService cService;
    @Autowired
    private ProductService pService;
    @Autowired
    private SellerService sService;
	@Override
	
	public void run(String... args) throws Exception {
		
		Product p1 = new Product(null, null, null, null, null);
		Client c1 = new Client(null, null, null, null, null, null);
		Seller s1 = new Seller(null, null, null, null, null);
		 
	}
	
    
    
}
