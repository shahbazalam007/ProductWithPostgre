package com.nt.error;

public class ProductNotFoundException extends RuntimeException {
	
	public ProductNotFoundException() {
		// 0-param constructor
	}
	public ProductNotFoundException(String msg) {
		super(msg);
	}

}
