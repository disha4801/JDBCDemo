package com.dnb.jdbcdemo.service;

import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.dnb.jdbcdemo.dto.Customer;
import com.dnb.jdbcdemo.exceptions.IdNotFoundException;
import com.dnb.jdbcdemo.repo.CustomerRepository;
import com.dnb.jdbcdemo.exceptions.InvalidAddressException;
import com.dnb.jdbcdemo.exceptions.InvalidContactNumberException;
import com.dnb.jdbcdemo.exceptions.InvalidCustomerIdException;
import com.dnb.jdbcdemo.exceptions.InvalidGovtIdException;
import com.dnb.jdbcdemo.exceptions.InvalidNameException;

@Service("customerServiceImpl")

public class CustomerServiceImpl implements CustomerService {

	@Autowired

	CustomerRepository customerRepository;

	@Override

	public Customer createCustomer(Customer customer) {

		// TODO Auto-generated method stub

		return customerRepository.save(customer);

	}

	@Override

	public Iterable<Customer> getAllCustomers() throws InvalidNameException, InvalidCustomerIdException,
			InvalidContactNumberException, InvalidAddressException, InvalidGovtIdException {

		// TODO Auto-generated method stub

		return customerRepository.findAll();

	}

	@Override

	public boolean deleteCustomerById(int customerId) throws InvalidCustomerIdException, InvalidNameException,

			InvalidContactNumberException, InvalidAddressException, InvalidGovtIdException, IdNotFoundException {

		// TODO Auto-generated method stub

		if (customerRepository.existsById(customerId)) {

			customerRepository.deleteById(customerId);

			if (customerRepository.existsById(customerId)) {

				return false;

			}

			return true;

		}

		else {

			throw new IdNotFoundException("ID Not Found");

		}

	}

	@Override
	public Optional<Customer> getCustomerById(int customerId) throws IdNotFoundException {
		// TODO Auto-generated method stub
		return customerRepository.findById(customerId);
	}

	@Override
	public boolean existsById(int customerId) {
		// TODO Auto-generated method stub
		if (customerRepository.existsById(customerId)) return true;
		else return false;
	}

}