package com.airasia.assignment.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.airasia.assignment.exception.ServiceException;

@RestControllerAdvice
public class OrderControllerAdvice {

	@ExceptionHandler
	public ResponseEntity<String> handleServiceException(ServiceException se) {
		return new ResponseEntity<String>(se.getMsg(), se.getHttpStatus());
	}

}
