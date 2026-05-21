package com.development.order.model.dto.request;

import java.time.LocalDate;

public record PackageProductRequestDTO (

	 InfoPackageRequestDTO info,
	 LocalDate dataPrevist,
	 Double weightDeclared
	 
 )
{
	
  }



	
