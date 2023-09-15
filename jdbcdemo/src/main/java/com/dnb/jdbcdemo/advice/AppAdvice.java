package com.dnb.jdbcdemo.advice;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.hibernate.TypeMismatchException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

import com.dnb.jdbcdemo.exceptions.IdNotFoundException;
import com.dnb.jdbcdemo.exceptions.InvalidAccountIdException;
import com.dnb.jdbcdemo.exceptions.InvalidContactNumberException;

@ControllerAdvice
public class AppAdvice {
	@ResponseStatus(value = HttpStatus.NOT_FOUND, reason = "Invalid id")
	@ExceptionHandler(InvalidAccountIdException.class)
	public void invalidAccountIdExceptionHandler(InvalidAccountIdException e) {
//		Map<String, String>map=new HashMap<>();
//		map.put("message", "accountId not found");
//		map.put("HttpStatus", HttpStatus.NOT_FOUND+"");
//		return new ResponseEntity(map,HttpStatus.NOT_FOUND);
	}

	@ExceptionHandler(InvalidContactNumberException.class)
	public ResponseEntity<?> invalidContactNumberExceptionHandler(InvalidContactNumberException e) {
		Map<String, String> map = new HashMap<>();
		map.put("message", "contactNumber not found");
		map.put("HttpStatus", HttpStatus.NOT_FOUND + "");
		return new ResponseEntity(map, HttpStatus.NOT_FOUND);
	}

	@ExceptionHandler(IdNotFoundException.class)
	public ResponseEntity<?> IdNotFoundExceptionHandler(IdNotFoundException e) {
		Map<String, String> map = new HashMap<>();
		map.put("message", "customerId not found");
		map.put("HttpStatus", HttpStatus.NOT_FOUND + "");
		return new ResponseEntity(map, HttpStatus.NOT_FOUND);
	}

	@ExceptionHandler(HttpRequestMethodNotSupportedException.class)
	public ResponseEntity<Map<String, String>> handleException(HttpRequestMethodNotSupportedException e)

			throws IOException {
		String provided = e.getMethod();
		List<String> supported = List.of(e.getSupportedMethods());
		String error = provided + "is not one of the supported Http Methods (" + String.join(",", supported) + ")";

		Map<String, String> errorResponse = Map.of( // mapping betweeen keys and values
				"error", error, "message", e.getLocalizedMessage(), "status", HttpStatus.METHOD_NOT_ALLOWED.toString());

		return new ResponseEntity<>(errorResponse, HttpStatus.METHOD_NOT_ALLOWED);
	}

	@ExceptionHandler({ MethodArgumentTypeMismatchException.class, TypeMismatchException.class })
	public ResponseEntity<Map<String, String>> handleException(TypeMismatchException e) {
		Map<String, String> errorResponse = Map.of(

				"message", e.getLocalizedMessage(), "status", HttpStatus.BAD_REQUEST.toString());

		return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
	}

}

