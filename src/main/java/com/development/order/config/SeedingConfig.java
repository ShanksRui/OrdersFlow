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
import com.development.order.model.entities.PackageStatusHistory;
import com.development.order.model.entities.Product;
import com.development.order.model.entities.Seller;
import com.development.order.model.entities.Shipping;
import com.development.order.model.entities.ShippingStatusHistory;
import com.development.order.model.entities.enums.PackageStatus;
import com.development.order.model.entities.enums.ShippingStatus;
import com.development.order.repositories.CenterRepository;
import com.development.order.repositories.ClientRepository;
import com.development.order.repositories.OrderRepository;
import com.development.order.repositories.PackageProductRepository;
import com.development.order.repositories.ProductRepository;
import com.development.order.repositories.SellerRepository;
import com.development.order.repositories.ShippingRepository;
import com.development.order.services.OrderService;
import com.development.order.services.ProductService;
import com.development.order.util.GeneratorCode;

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
		p1.setCode(GeneratorCode.generatorFromCode());
		p2.setCode(GeneratorCode.generatorFromCode());
		p3.setCode(GeneratorCode.generatorFromCode());
		p4.setCode(GeneratorCode.generatorFromCode());
		pRepository.saveAll(Arrays.asList(p1,p2,p3,p4));
		s1.getProducts().addAll(Arrays.asList(p2,p4));
		s2.getProducts().addAll(Arrays.asList(p1,p3));
		
		Client c1 = new Client(null, "luiz", 245663276, 323239241);
		Client c2 = new Client(null, "pamella", 625353242, 43532345);
		cRepository.saveAll(Arrays.asList(c1,c2));
		
		Center center1 = new Center(null,"Station",32124211,800);
		Shipping ship = new Shipping(null, "Bags",44124214, "Brasilia","Sao-Paulo", ShippingStatus.CREATED,center1);
		ship.addHistoryStatus(new ShippingStatusHistory(null, Instant.now()));
		ctRepository.save(center1);
		shipRepository.save(ship);
		PackageProduct pkg1 = new PackageProduct(null,6.4,LocalDate.of(2026, 10, 12),p4,center1, PackageStatus.CREATED_BY_SELLER);
		PackageProduct pkg2 = new PackageProduct(null,24.0,LocalDate.of(2026, 9, 03),p1,center1, PackageStatus.CREATED_BY_SELLER);
		pkg1.addHistoryStatus(new PackageStatusHistory(null, Instant.now()));
		center1.getPkgs().addAll(Arrays.asList(pkg1,pkg2));
		center1.setQuantityPackages();
		ctRepository.save(center1);
		pkg1.setShipping(ship);
		pkg2.setShipping(ship);
		
		pkgRepository.saveAll(Arrays.asList(pkg1,pkg2));
		ship.getPkgs().addAll(Arrays.asList(pkg1,pkg2));
		shipRepository.save(ship);
		
		Order o1 = new Order(null,c2);
		Order o2 = new Order(null,c1);
		o1.setCode(GeneratorCode.generatorFromCode());
		o2.setCode(GeneratorCode.generatorFromCode());
		o1.addPackage(pkg2);
		o2.addPackage(pkg1);
		oRepository.saveAll(Arrays.asList(o1,o2));
		pkgRepository.saveAll(Arrays.asList(pkg1,pkg2));

		
	}

}
