package com.capg.exception;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
@RestControllerAdvice
public class CentralExceptionHandler {
	
	@ExceptionHandler(CustomerNotFoundException.class)
	public ResponseEntity<String> customerExceptionHandler(CustomerNotFoundException excp){
		
		return new ResponseEntity<String>(excp.getMessage(), HttpStatus.NOT_FOUND) ;	
	}
	
	@ExceptionHandler(OrderNotFoundException.class)
	public ResponseEntity<String> orderExceptionHandler(OrderNotFoundException excp){
		
		return new ResponseEntity<String>(excp.getMessage(), HttpStatus.NOT_FOUND) ;	
	}
	
	
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<List<String>> methodArgumentNotValidExceptionHandler(MethodArgumentNotValidException e){
		
		
		System.out.println("**** INSIDE HANDLER ****");
		return new ResponseEntity<List<String>>(e.getFieldErrors().stream().map(FieldError::getDefaultMessage).collect(Collectors.toList()), HttpStatus.BAD_REQUEST);
}

}
