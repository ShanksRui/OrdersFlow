package com.development.order.config;

import java.time.Instant;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.development.order.model.entities.Client;
import com.development.order.model.entities.PackageProduct;
import com.development.order.model.entities.Product;
import com.development.order.model.entities.Seller;
import com.development.order.model.entities.enums.Status;
import com.development.order.repositories.ClientRepository;
import com.development.order.repositories.PackageProductRepository;
import com.development.order.repositories.ProductRepository;
import com.development.order.repositories.SellerRepository;
@Configuration
@Profile("test")
public class SeedingConfig implements CommandLineRunner {

	@Autowired
	private ClientRepository cRepository;
	@Autowired
	private ProductRepository pRepository;
	@Autowired
	private SellerRepository sRepository;
	@Autowired
	private PackageProductRepository pkgRepository;

	@Override

	public void run(String... args) throws Exception {

		
		Seller s1 = new Seller(null, "carlitos", 31392932);
		Seller s2 = new Seller(null, "Hernadez", 421515324);
		sRepository.saveAll(Arrays.asList(s1,s2));
		Product p1 = new Product(null, "Notebook Gamer RTX 4060", 5899.90, "Eletrônicos", s2);
		Product p2 = new Product(null, "Monitor 27\" 144Hz", 1299.00, "Eletrônicos", s1);
		Product p3 = new Product(null, "Webcam Full HD", 219.90, "Acessórios", s2);
		Product p4 = new Product(null, "Mesa 4x4", 219.90, "Acessórios", s1);
		pRepository.saveAll(Arrays.asList(p1,p2,p3,p4));
		Client c1 = new Client(null, "luiz", 245663276, 323239241, Instant.now());
		//Client c2 = new Client(null, "pamella", 625353242, 43532345, Instant.now());
		s1.getProducts().addAll(Arrays.asList(p2,p4));
		s2.getProducts().addAll(Arrays.asList(p1,p3));
		cRepository.save(c1);
		PackageProduct pkg1 = new PackageProduct(null,c1, s2, p4, Status.CREATED_BY_SELLER);
		pkgRepository.save(pkg1);
		cRepository.save(c1);
		


	}

}
