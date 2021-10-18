package com.mycompany.storemanager.rest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ProductGlobalExceptionHandler {

	// exception handler needs to handle thrown exceptions
	@ExceptionHandler
	public ResponseEntity<ProductRestInputErrorMessage> handleException(
					ProductNotFoundInDbException exc){
		// our custom error message
		ProductRestInputErrorMessage errorMessage = new ProductRestInputErrorMessage();
		errorMessage.setHttpStatus(HttpStatus.NOT_FOUND.value());
		errorMessage.setErrorMessage(exc.getMessage());
		errorMessage.setTimeStamp(System.currentTimeMillis());
		// return resposneEntity
		return new ResponseEntity<>(errorMessage,HttpStatus.NOT_FOUND) ;
	}
	
	// exception handler needs to handle all other thrown exceptions
	@ExceptionHandler
	public ResponseEntity<ProductRestInputErrorMessage> handleException(
					Exception exc){
		// our custom error message
		ProductRestInputErrorMessage errorMessage = new ProductRestInputErrorMessage();
		errorMessage.setHttpStatus(HttpStatus.BAD_REQUEST.value());
		errorMessage.setErrorMessage(exc.getMessage());
		errorMessage.setTimeStamp(System.currentTimeMillis());
		// return resposneEntity
		return new ResponseEntity<>(errorMessage,HttpStatus.BAD_REQUEST) ;
	}
	
}
