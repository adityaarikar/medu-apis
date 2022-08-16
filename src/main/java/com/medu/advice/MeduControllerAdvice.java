package com.medu.advice;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.medu.exception.ResourceNotFoundException;

@ControllerAdvice
public class MeduControllerAdvice {

	@ExceptionHandler(DataIntegrityViolationException.class)
	public ResponseEntity<String> handleDublicateEntries(DataIntegrityViolationException dataIntegrityViolationException){
		return new ResponseEntity<String>("Input field is already entered",HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(ResourceNotFoundException.class)
	public ResponseEntity<String> handleIdNotExist(ResourceNotFoundException resourceNotFoundException){
		return new ResponseEntity<String>("Subject does not exixt",HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(IllegalArgumentException.class)
	public ResponseEntity<String> handleEmptyInputException(IllegalArgumentException illiArgumentException){
		return new ResponseEntity<String>("Input cannot be empty",HttpStatus.BAD_REQUEST);
	}

}
