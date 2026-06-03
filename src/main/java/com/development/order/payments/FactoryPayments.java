package com.development.order.payments;

import com.development.order.services.exceptions.PaymentMethodInvalidExeception;
import com.development.order.util.CalcTax;

public class FactoryPayments {

	public static CalcTax PaymentMethod (String method) {
		if(method.isBlank() || method == null ) {
			throw new IllegalArgumentException("method invalid");
		}
		try {
		if(method.toLowerCase() == "pix") {
			return new Pix(0.15);
		}else if (method.toLowerCase() == "card") {
			return new Card(0.3);
		}
		}catch(IllegalArgumentException e) {
			throw new PaymentMethodInvalidExeception("methods payments invalid!");
		}
		return null;
	}

}

