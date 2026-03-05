package com.development.order.config;

import java.time.Instant;
import java.time.LocalDate;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.development.order.model.entities.Center;
import com.development.order.model.entities.Client;
import com.development.order.model.entities.Order;
import com.development.order.model.entities.PackageProduct;
import com.development.order.model.entities.Product;
import com.development.order.model.entities.Seller;
import com.development.order.model.entities.Shipping;
import com.development.order.model.entities.enums.Status;
import com.development.order.repositories.CenterRepository;
import com.development.order.repositories.ClientRepository;
import com.development.order.repositories.OrderRepository;
import com.development.order.repositories.PackageProductRepository;
import com.development.order.repositories.ProductRepository;
import com.development.order.repositories.SellerRepository;
import com.development.order.repositories.ShippingRepository;
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
	@Autowired
	private CenterRepository ctRepository;
	@Autowired
	private ShippingRepository shipRepository;
	@Autowired
	private OrderRepository oRepository;

	
	
	
	@Override
	public void run(String... args) throws Exception {

		
		Seller s1 = new Seller(null, "carlitos", 31392932);
		Seller s2 = new Seller(null, "Hernadez", 421515324);
		sRepository.saveAll(Arrays.asList(s1,s2));
		Product p1 = new Product(null, "Notebook Gamer RTX 4060", 5899.90, "Eletronics", s2);
		Product p2 = new Product(null, "Monitor 27\" 144Hz", 1299.00, "Eletronics", s1);
		Product p3 = new Product(null, "Webcam Full HD", 219.90, "accessories", s2);
		Product p4 = new Product(null, "Mesa 4x4", 219.90, "accessories", s1);
		pRepository.saveAll(Arrays.asList(p1,p2,p3,p4));
		s1.getProducts().addAll(Arrays.asList(p2,p4));
		s2.getProducts().addAll(Arrays.asList(p1,p3));
		Client c1 = new Client(null, "luiz", 245663276, 323239241, Instant.now());
		Client c2 = new Client(null, "pamella", 625353242, 43532345, Instant.now());
		cRepository.saveAll(Arrays.asList(c1,c2));
		Center center1 = new Center(null,800);
		Shipping ship = new Shipping(null, "Bags", "Brasilia","Sao-Paulo", Status.IN_STATE_TRANSPORT);
		ctRepository.save(center1);
		shipRepository.save(ship);
		PackageProduct pkg1 = new PackageProduct(null,LocalDate.of(2026, 10, 12),c1,p4,center1, Status.CREATED_BY_SELLER);
		PackageProduct pkg2 = new PackageProduct(null,LocalDate.of(2026, 9, 03),c2, p1,center1, Status.CREATED_BY_SELLER);
		center1.getPkgs().addAll(Arrays.asList(pkg1,pkg2));
		center1.setQuantityPackages();
		ctRepository.save(center1);
		pkg1.setShipping(ship);
		pkg2.setShipping(ship);
		pkgRepository.saveAll(Arrays.asList(pkg1,pkg2));
		ship.getPkgs().addAll(Arrays.asList(pkg1,pkg2));
		Order o1 = new Order(null, Instant.now(), c2);
		Order o2 = new Order(null, Instant.now(), c1);
		
	}

}
