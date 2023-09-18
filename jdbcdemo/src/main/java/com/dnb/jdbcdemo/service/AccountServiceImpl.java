package com.dnb.jdbcdemo.service;


import java.util.List;

import java.util.Optional;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dnb.jdbcdemo.dto.Account;
import com.dnb.jdbcdemo.dto.Customer;
import com.dnb.jdbcdemo.exceptions.IdNotFoundException;
import com.dnb.jdbcdemo.repo.AccountRepository;
import com.dnb.jdbcdemo.repo.CustomerRepository;

import javax.naming.InvalidNameException;
import com.dnb.jdbcdemo.exceptions.InvalidAccountIdException;
import com.dnb.jdbcdemo.exceptions.InvalidAddressException;
import com.dnb.jdbcdemo.exceptions.InvalidContactNumberException;
import com.dnb.jdbcdemo.exceptions.InvalidCustomerIdException;
import com.dnb.jdbcdemo.exceptions.InvalidDateException;
import com.dnb.jdbcdemo.exceptions.InvalidGovtIdException;

@Service("accountServiceImpl")
public class AccountServiceImpl implements AccountService {

	@Autowired
	private AccountRepository accountRepository;
	@Autowired
	private CustomerRepository customerRepository;

	@Override
	public Account createAccount(Account account) throws IdNotFoundException, InvalidNameException,
			InvalidCustomerIdException, InvalidContactNumberException, InvalidAddressException, InvalidGovtIdException {
		Optional<Customer> customer=customerRepository.findById(account.getCustomer().getCustomerId());
 		if(customer.isPresent()) {
 			account.setCustomer(customer.get());
			System.out.println(customer.get()+"values");
			return accountRepository.save(account);
		}
	else
			customer.orElseThrow(()->new IdNotFoundException("customer id Not valid"));
		return null;
}

	@Override
	public Optional<Account> getAccountById(String accountId){// throws InvalidNameException, InvalidDateException,
//			InvalidAccountIdException, InvalidAccountTypeException, InvalidBalanceException,
//			InvalidContactNumberException, InvalidAddressException, InvalidAccountStatusException {
		// TODO Auto-generated method stub
		return accountRepository.findById(accountId);
	}

	@Override
	public Iterable<Account> getAllAccounts() throws InvalidNameException, InvalidDateException,
			InvalidAccountIdException, 
			InvalidContactNumberException, InvalidAddressException{
		// TODO Auto-generated method stub
		return accountRepository.findAll();
	}

	@Override
	public boolean deleteAccountById(String accountId) throws IdNotFoundException {
		// TODO Auto-generated method stub
		if (accountRepository.existsById(accountId)) {
			accountRepository.deleteById(accountId);
			if (accountRepository.existsById(accountId)) {
				return false;
			}
			return true;
		} else {
			throw new IdNotFoundException("AccountId not found");
		}
	}

	@Override
	public boolean accountExistsById(String accountId) {
		// TODO Auto-generated method stub
		if (accountRepository.existsById(accountId)) return true;
		else return false;
	}

//	@Override
//	public Optional<Account> getAccountByContactNumber(String contactNumber) {
//		// TODO Auto-generated method stub
//		return accountRepository.findByContactNumber(contactNumber);
//	}

	@Override
	public List<Account> getAllAccountsByContactNumber(String contactNumber) {
		// TODO Auto-generated method stub
		return accountRepository.findByContactNumber(contactNumber);
	}
}

//@Service("accountServiceImpl")
//public class AccountServiceImpl implements AccountService {
//	
//	@Autowired
//	private AccountRepository accountRepository;
//	@Override
//	public Account createAccount(Account account) throws IdNotFoundException {
//		// TODO Auto-generated method stub
//		return accountRepository.save(account);
//		
//	}
//
//	@Override
//	public Optional<Account> getAccountById(String accountId) {
//		// TODO Auto-generated method stub
//		return accountRepository.findById(accountId);
//	}
//
//	@Override
//	public Iterable<Account> getAllAccounts() {
//		// TODO Auto-generated method stub
//		return accountRepository.findAll();
//		
//	}
//	
//	@Override
//	public boolean deleteAccountById(String AccountId) throws IdNotFoundException {
//		// TODO Auto-generated method stub
//		if( accountRepository.existsById(AccountId)) {
//			accountRepository.deleteById(AccountId);
//			if(accountRepository.existsById(AccountId)) {
//				return false;
//			}
//			return true;
//			
//		}
//		else {
//			throw new IdNotFoundException("Id not found");
//		}
//	}


 

//	private static AccountService accountService = null;
//
//	@Autowired
//	AccountRepository accountRepository;
//	@Autowired
//	private CustomerRepository customerRepository;
//
//
//	@Override
//	public Account createAccount(Account account) throws IdNotFoundException{
//		//AccountRepository accountRepository = AccountRepositoryImpl.getInstance();
//		Optional<Customer>optional=customerRepository.getCustomerById(account.getCustomer().getCustomerId());
//		if(optional.isPresent())
//			return accountRepository.createAccount(account);
//		else
//		{
//			throw new IdNotFoundException("customerId not found");
//		}
//	}
//
// 
//
//	@Override
//	public Optional<Account> getAccountById(String accountId) {
//		//AccountRepository accountRepository = AccountRepositoryImpl.getInstance();
//		return accountRepository.getAccountById(accountId);
//	}
//
// 
//
//	@Override
//	public List<Account> getAllAccounts() {
//		// TODO Auto-generated method stub
//		//AccountRepository accountRepository=AccountRepositoryImpl.getInstance();
//		return accountRepository.getAllAccounts();
//	}

