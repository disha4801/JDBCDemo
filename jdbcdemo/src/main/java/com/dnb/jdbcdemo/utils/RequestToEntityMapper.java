package com.dnb.jdbcdemo.utils;

import org.springframework.stereotype.Component;
import com.dnb.jdbcdemo.dto.Account;
import com.dnb.jdbcdemo.payload.request.AccountRequest;

@Component
public class RequestToEntityMapper {

	public Account getAccountEntityObject(AccountRequest accountRequest) {

		Account account = new Account();
		account.setAccountHolderName(accountRequest.getAccountHolderName());
		account.setAccountType(accountRequest.getAccountType());
		account.setBalance(accountRequest.getBalance());
		account.setContactNumber(accountRequest.getContactNumber());
		account.setAddress(accountRequest.getAddress());
		account.setDob(accountRequest.getDob());
		account.setCustomerId(accountRequest.getCustomerId());
		return account;

	}
}
