package com.dnb.jdbcdemo.service;


import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.dnb.jdbcdemo.dto.Account;
import com.dnb.jdbcdemo.exceptions.IdNotFoundException;
import com.dnb.jdbcdemo.repo.AccountRepository;


 

@Service("accountServiceImpl")
public class AccountServiceImpl implements AccountService {
	
	@Autowired
	private AccountRepository accountRepository;
	@Override
	public Account createAccount(Account account) throws IdNotFoundException {
		// TODO Auto-generated method stub
		return accountRepository.save(account);
		
	}

	@Override
	public Optional<Account> getAccountById(String accountId) {
		// TODO Auto-generated method stub
		return accountRepository.findById(accountId);
	}

	@Override
	public Iterable<Account> getAllAccounts() {
		// TODO Auto-generated method stub
		return accountRepository.findAll();
		
	}
	
	@Override
	public boolean deleteAccountById(String AccountId) throws IdNotFoundException {
		// TODO Auto-generated method stub
		if( accountRepository.existsById(AccountId)) {
			accountRepository.deleteById(AccountId);
			if(accountRepository.existsById(AccountId)) {
				return false;
			}
			return true;
			
		}
		else {
			throw new IdNotFoundException("Id not found");
		}
	}


 

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
}
