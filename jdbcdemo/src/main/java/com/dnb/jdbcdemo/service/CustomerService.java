package com.dnb.jdbcdemo.service;

import java.util.List;
import java.util.Optional;

import com.dnb.jdbcdemo.dto.Account;
import com.dnb.jdbcdemo.dto.Customer;

public interface CustomerService{
	
	public Customer createCustomer(Customer customer);
	public Optional<Customer> getCustomerById(int customerId);
	public List<Account> getAllAccounts();
	public List<Customer> getAllCustomers();
	
}
