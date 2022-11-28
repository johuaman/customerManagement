package com.clientes.exceptions;

import lombok.Data;
import org.springframework.http.HttpStatus;

@Data
public class BussniesRulesException extends Exception{
	

	private long id;
	private String code;
	private HttpStatus httpStatus;
	
	public BussniesRulesException(long id, String code, String message, HttpStatus httpStatus) {
		super(message);
		this.id = id;
		this.code = code;
		this.httpStatus = httpStatus;
	}

	public BussniesRulesException(String code, String message, HttpStatus httpStatus) {
		super(message);
		this.code = code;
		this.httpStatus = httpStatus;
	}
	

	
	
}
