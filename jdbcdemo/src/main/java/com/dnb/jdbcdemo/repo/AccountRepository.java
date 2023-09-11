package com.dnb.jdbcdemo.repo;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.dnb.jdbcdemo.dto.Account;


@Repository
public interface AccountRepository extends CrudRepository<Account, String>{

//	public Account createAccount(Account account);
//	public Optional<Account> getAccountById(String accountId);
//	public List<Account> getAllAccounts();
}
