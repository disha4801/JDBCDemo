package com.dnb.jdbcdemo.advice;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.dnb.jdbcdemo.exceptions.IdNotFoundException;
import com.dnb.jdbcdemo.exceptions.InvalidAccountIdException;
import com.dnb.jdbcdemo.exceptions.InvalidContactNumberException;

@ControllerAdvice
public class AppAdvice {
	
	@ExceptionHandler(InvalidAccountIdException.class)
	public ResponseEntity<?> invalidAccountIdExceptionHandler(InvalidAccountIdException e){
		Map<String, String>map=new HashMap<>();
		map.put("message", "accountId not found");
		map.put("HttpStatus", HttpStatus.NOT_FOUND+"");
		return new ResponseEntity(map,HttpStatus.NOT_FOUND);
	}
	@ExceptionHandler(InvalidContactNumberException.class)
	public ResponseEntity<?> invalidContactNumberExceptionHandler(InvalidContactNumberException e){
		Map<String, String>map=new HashMap<>();
		map.put("message", "contactNumber not found");
		map.put("HttpStatus", HttpStatus.NOT_FOUND+"");
		return new ResponseEntity(map,HttpStatus.NOT_FOUND);
	}
	@ExceptionHandler(IdNotFoundException.class)
	public ResponseEntity<?> IdNotFoundExceptionHandler(IdNotFoundException e){
		Map<String, String>map=new HashMap<>();
		map.put("message", "customerId not found");
		map.put("HttpStatus", HttpStatus.NOT_FOUND+"");
		return new ResponseEntity(map,HttpStatus.NOT_FOUND);
	}
}


