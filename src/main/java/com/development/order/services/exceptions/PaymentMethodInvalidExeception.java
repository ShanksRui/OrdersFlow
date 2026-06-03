package com.development.order.services.exceptions;

public class PaymentMethodInvalidExeception extends RuntimeException {
	private static final long serialVersionUID = 1L;
	
	 public PaymentMethodInvalidExeception(String msg) {
		super(msg);
	 }
}
