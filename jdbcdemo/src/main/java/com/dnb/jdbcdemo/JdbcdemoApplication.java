package com.dnb.jdbcdemo;


import java.time.LocalDate;

import javax.naming.InvalidNameException;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import com.dnb.jdbcdemo.dto.Account;
import com.dnb.jdbcdemo.dto.Customer;
import com.dnb.jdbcdemo.exceptions.IdNotFoundException;
import com.dnb.jdbcdemo.exceptions.InsufficientBalanceException;
import com.dnb.jdbcdemo.exceptions.InvalidContactNumberException;
import com.dnb.jdbcdemo.exceptions.InvalidDateException;
import com.dnb.jdbcdemo.service.AccountService;

@SpringBootApplication
public class JdbcdemoApplication {

	public static void main(String[] args) {

		ApplicationContext applicationContext = SpringApplication.run(JdbcdemoApplication.class, args);
		AccountService accountService = applicationContext.getBean(AccountService.class);
		Account account2 = new Account();
		account2.setAccountId("ab00967");
		try {
			account2.setAccountCreatedDate(LocalDate.now());
		} catch (InvalidDateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			account2.setAccountHolderName("zia");
		} catch (InvalidNameException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		account2.setAccountStatus(true);
		try {
			account2.setAccountType("saving");
		} catch (InvalidNameException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		account2.setAddress("Hyderabad");
		try {
			account2.setBalance(10000);
		} catch (InsufficientBalanceException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			account2.setContactNumber("1234567890");
		} catch (InvalidContactNumberException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			account2.setDob(LocalDate.of(2001, 3,4));
		} catch (InvalidDateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(account2);
		account2.setCustomer(new Customer(1,"ria","0123456789","abc","LXYPS90","987345678"));
		Account account = null ;
		
		try {
			account = accountService.createAccount(account2);
		} catch (IdNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println(account);

//		DataSource dataSource = applicationContext.getBean(DataSource.class);
//
//		System.out.println(dataSource != null);
//
//		try {
//
//			System.out.println(dataSource.getConnection());
//
//		} catch (SQLException e) {
//
//			// TODO Auto-generated catch block
//
//			e.printStackTrace();
//
//		}

	}

}