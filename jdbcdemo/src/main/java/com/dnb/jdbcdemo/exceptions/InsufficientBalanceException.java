package com.dnb.jdbcdemo.exceptions;

public class InsufficientBalanceException extends Exception {
	
	public InsufficientBalanceException(String msg) {
		super(msg);
		// TODO Auto-generated constructor stub
	}
    @Override
	public String toString() {
		return super.toString()+super.getMessage();
	}
	

}
