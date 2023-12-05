package com.nt.advice;

import java.time.LocalDateTime;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import com.nt.error.ErrorDetails;
import com.nt.error.ProductNotFoundException;


@RestControllerAdvice
public class TouristOperationControllerAdvice {
	
	@ExceptionHandler(ProductNotFoundException.class)
	public ResponseEntity<ErrorDetails> handleProductNotFoundException(ProductNotFoundException ProductExc){
		System.out.println("ProductOperationControllerAdvice.handleProductNotFoundException()");
		ErrorDetails ed=new ErrorDetails(LocalDateTime.now(), ProductExc.getMessage(), "404-Product Not Found");
	 return new ResponseEntity<ErrorDetails>(ed,HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(Exception.class)
	public ResponseEntity<ErrorDetails> handleAllException(Exception e){
		System.out.println("ProductOperationControllerAdvice.handleAllException()");
		ErrorDetails ed=new ErrorDetails(LocalDateTime.now(), e.getMessage(), "500-server error");
	 return new ResponseEntity<ErrorDetails>(ed,HttpStatus.INTERNAL_SERVER_ERROR);
	}

}
