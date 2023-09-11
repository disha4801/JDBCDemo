package com.dnb.jdbcdemo.exceptions;

public class InvalidGovtIdException extends Exception {
	
	public InvalidGovtIdException (String msg) {
		super(msg);
	}

	@Override
	public String toString() {
		return super.toString() + super.getMessage();
	}

}
