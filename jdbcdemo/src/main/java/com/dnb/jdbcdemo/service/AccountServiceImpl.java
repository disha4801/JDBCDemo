package com.dnb.jdbcdemo.service;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.dnb.jdbcdemo.dto.Account;
import com.dnb.jdbcdemo.dto.Customer;
import com.dnb.jdbcdemo.exceptions.IdNotFoundException;
import com.dnb.jdbcdemo.repo.AccountRepository;
import com.dnb.jdbcdemo.repo.CustomerRepository;

 

@Service("accountServiceImpl")
public class AccountServiceImpl implements AccountService {

 

	//private static AccountService accountService = null;

	@Autowired
	AccountRepository accountRepository;
	@Autowired
	private CustomerRepository customerRepository;


	@Override
	public Account createAccount(Account account) throws IdNotFoundException{
		//AccountRepository accountRepository = AccountRepositoryImpl.getInstance();
		Optional<Customer>optional=customerRepository.getCustomerById(account.getCustomer().getCustomerId());
		if(optional.isPresent())
			return accountRepository.createAccount(account);
		else
		{
			throw new IdNotFoundException("customerId not found");
		}
	}

 

	@Override
	public Optional<Account> getAccountById(String accountId) {
		//AccountRepository accountRepository = AccountRepositoryImpl.getInstance();
		return accountRepository.getAccountById(accountId);
	}

 

	@Override
	public List<Account> getAllAccounts() {
		// TODO Auto-generated method stub
		//AccountRepository accountRepository=AccountRepositoryImpl.getInstance();
		return accountRepository.getAllAccounts();
	}
}
