package com.dnb.jdbcdemo.repo;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.dnb.jdbcdemo.dto.Customer;

public interface CustomerRepository extends CrudRepository<Customer, Integer> {

	


//	public Customer createCustomer(Customer customer);
//
//	public Optional<Customer> getCustomerById(int customerId);
//
//	public List<Customer> getAllCustomers();

}
