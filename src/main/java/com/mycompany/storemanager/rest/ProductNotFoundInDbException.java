package com.mycompany.storemanager.rest;

public class ProductNotFoundInDbException extends RuntimeException {

	public ProductNotFoundInDbException(String message, Throwable cause) {
		super(message, cause);
	}

	public ProductNotFoundInDbException(String message) {
		super(message);
	}

	public ProductNotFoundInDbException(Throwable cause) {
		super(cause);

	}

	
	
}
