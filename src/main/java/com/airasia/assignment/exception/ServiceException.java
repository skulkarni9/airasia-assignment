package com.airasia.assignment.exception;

import org.springframework.http.HttpStatus;

import lombok.Getter;

@Getter
public class ServiceException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	private HttpStatus httpStatus;

	private String msg;

	public ServiceException(HttpStatus httpStatus, String msg) {
		super(msg);
		this.httpStatus = httpStatus;
	}

}
