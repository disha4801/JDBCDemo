package com.dnb.jdbcdemo.exceptions;

public class InvalidAddressException extends Exception {
	
     public InvalidAddressException(String msg) {
		super(msg);
	}

	@Override
	public String toString() {
		return super.toString() + super.getMessage();
	}

}
