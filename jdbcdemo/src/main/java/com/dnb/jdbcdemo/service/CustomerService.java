package com.dnb.jdbcdemo.service;

import java.util.List;
import java.util.Optional;

import com.dnb.jdbcdemo.dto.Account;
import com.dnb.jdbcdemo.dto.Customer;
import com.dnb.jdbcdemo.exceptions.IdNotFoundException;
import com.dnb.jdbcdemo.exceptions.InvalidAddressException;
import com.dnb.jdbcdemo.exceptions.InvalidContactNumberException;
import com.dnb.jdbcdemo.exceptions.InvalidCustomerIdException;
import com.dnb.jdbcdemo.exceptions.InvalidGovtIdException;
import com.dnb.jdbcdemo.exceptions.InvalidNameException;

public interface CustomerService{

	public Customer createCustomer(Customer customer);
	public Iterable<Customer> getAllCustomers() throws InvalidNameException, InvalidCustomerIdException, InvalidContactNumberException, InvalidAddressException, InvalidGovtIdException;
	public boolean deleteCustomerById(int customerId) throws InvalidCustomerIdException, InvalidNameException,
			InvalidContactNumberException, InvalidAddressException, InvalidGovtIdException, IdNotFoundException;
	public Optional<Customer> getCustomerById(int customerId) throws IdNotFoundException;
	
}
