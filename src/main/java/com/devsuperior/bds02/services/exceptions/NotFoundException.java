package com.devsuperior.bds02.services.exceptions;

import org.springframework.http.HttpStatus;

public class NotFoundException extends RuntimeException {
	private static final long serialVersionUID = 1L;
	
	private HttpStatus status;
	
	public NotFoundException(String message) {
		super(message);
	}
	
	public NotFoundException(HttpStatus status, String message) {
		super(message);
		this.status = status;
	}

}
