package com.development.order.model.dto.request;

import java.time.LocalDate;

import com.development.order.model.entities.enums.PackageStatus;

public record PackageProductRequestDTO (

	 InfoPackageRequestDTO info,
	 LocalDate dataPrevist,
	 PackageStatus status,
	 Double weightDeclared
	 
 )
{
	
  }



	
