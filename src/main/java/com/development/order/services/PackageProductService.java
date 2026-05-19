package com.development.order.services;

import java.util.List;
import java.util.Optional;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import com.development.order.model.dto.request.PackageProductRequestDTO;
import com.development.order.model.dto.response.PackageProductDTO;
import com.development.order.model.entities.PackageProduct;
import com.development.order.model.entities.enums.PackageStatus;
import com.development.order.repositories.PackageProductRepository;
import com.development.order.services.exceptions.CodeExistingException;
import com.development.order.services.exceptions.NotFoundResourceException;
import com.development.order.util.GeneratorCode;

@Service
public class PackageProductService {

	private PackageProductRepository repository;
	private OrderService oService;
	private ShippingService sService;
	private CenterService cService;
	private ProductService pService;
	
	public PackageProductService(PackageProductRepository repository,
			OrderService oService,ShippingService sService,
			CenterService cService,
			ProductService pService) {
		this.repository = repository;
		this.oService = oService;
		this.sService = sService;
		this.cService = cService;
		this.pService = pService;
	}
	
	public PackageProduct insert(PackageProductRequestDTO dto) {
		PackageProduct pkg = new PackageProduct();
		pkg.setWeightDeclared(dto.weightDeclared());
		pkg.setDataPrevist(dto.dataPrevist());
		pkg.setStatus(PackageStatus.TRACKING_GENERATED);
		pkg.setOrder(oService.findById(dto.info().order()));
		pkg.setProduct(pService.findById(dto.info().product()));
		pkg.setCenter(cService.findById(dto.info().center()));
		pkg.setShipping(sService.findById(dto.info().shipping()));
		pkg.setSeller(pkg.getProduct());
		
		for (int i = 0; i < 5; i++) {
			String code = GeneratorCode.generatorFromCode();
			String tCode = GeneratorCode.generatorFromCode();
			
			if (code == null || code.isBlank() & tCode == null || tCode.isBlank() ) {
	            throw new IllegalStateException("generated code is null");
	        }
			
			pkg.setCode(code);
			pkg.setTrackingCode(tCode);
				
			try {
				return repository.save(pkg);
			} catch (DataIntegrityViolationException e) {
	            System.out.println(e.getMessage());
	            
	            if (!e.getMessage().contains("unique")) {
	                throw e;
	            }
	            System.out.println("generating new code!");
			}		
		}
		throw new CodeExistingException("error in generating for code unique");
	}
	public List<PackageProduct> findAll() {
		return repository.findAll();
	}
	public PackageProduct findById(Long id) {
		Optional<PackageProduct> op = repository.findById(id);
		return op.orElseThrow(() -> new NotFoundResourceException(id));
	}

	public void delete(Long id) {
		if (!repository.existsById(id)) {
			throw new NotFoundResourceException(id);
		}
		repository.deleteById(id);
	}
	public PackageProductDTO update(Long id,PackageProduct pkg) {
		PackageProduct entity = findById(id);
		dataUpdate(entity, pkg);
		return  PackageProductDTO.fromDTO(entity);
	}
	public void dataUpdate(PackageProduct entity,PackageProduct pkg) {
		entity.setDataPrevist(pkg.getDataPrevist());
		entity.setShipping(pkg.getShipping());
	}
}
