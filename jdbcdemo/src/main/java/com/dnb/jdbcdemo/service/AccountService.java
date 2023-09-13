package com.dnb.jdbcdemo.service;

import java.util.Optional;

import com.dnb.jdbcdemo.dto.Account;
import com.dnb.jdbcdemo.exceptions.IdNotFoundException;

public interface AccountService {
	public Account createAccount(Account account) throws IdNotFoundException;

	public Optional<Account> getAccountById(String accountId);

	public Iterable<Account> getAllAccounts();

	boolean deleteAccountById(String AccountId) throws IdNotFoundException;

}
