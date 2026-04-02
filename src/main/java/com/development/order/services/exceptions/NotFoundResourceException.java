package com.development.order.services.exceptions;

public class NotFoundResourceException extends RuntimeException{
	private static final long serialVersionUID = 1L;
	
	public NotFoundResourceException(Object id) {
		super("resource not found ID:"+id);
	}
    
}
