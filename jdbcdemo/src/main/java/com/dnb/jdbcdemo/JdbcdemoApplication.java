package com.dnb.jdbcdemo;

import java.time.LocalDate;
import java.util.Optional;
import java.util.Scanner;
import javax.naming.InvalidNameException;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import com.dnb.jdbcdemo.dto.Account;
import com.dnb.jdbcdemo.dto.Customer;
import com.dnb.jdbcdemo.exceptions.IdNotFoundException;
import com.dnb.jdbcdemo.exceptions.InsufficientBalanceException;
import com.dnb.jdbcdemo.exceptions.InvalidAddressException;
import com.dnb.jdbcdemo.exceptions.InvalidContactNumberException;
import com.dnb.jdbcdemo.exceptions.InvalidCustomerIdException;
import com.dnb.jdbcdemo.exceptions.InvalidDateException;
import com.dnb.jdbcdemo.exceptions.InvalidGovtIdException;
import com.dnb.jdbcdemo.service.AccountService;
import com.dnb.jdbcdemo.service.CustomerService;

@SpringBootApplication
public class JdbcdemoApplication {

	public static void main(String[] args) {

		ApplicationContext applicationContext = SpringApplication.run(JdbcdemoApplication.class, args);
		AccountService accountService = applicationContext.getBean(AccountService.class);
		CustomerService customerService = applicationContext.getBean(CustomerService.class);
		Account account2;
		Customer customer;

		try {
			account2 = new Account("ab0096", "Boon", "Salary", 60100, "9036422722", "Hyd", LocalDate.now(),
					LocalDate.of(2001, 10, 22), 2);

			customer = new Customer(1, "Disha", "9036422722", "Hydd", "BBBBB5111A", "778899006655");

			System.out.println(account2);
			Scanner sc = new Scanner(System.in);
			while (true) {
				System.out.println(
						"Enter your choice\n1)Create account\n2)Get accountby ID\n3)Delete account by ID\n4)Get all accounts\n5)Create Customer\n6)Exit\n");
				int str = sc.nextInt();
				switch (str) {
				case 1:
					try {
						accountService.createAccount(account2);
					} catch (IdNotFoundException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					break;
				case 2: {

					Optional<Account> acc;
					acc = accountService.getAccountById("ab00968");
					System.out.println(acc != null);
					break;
				}
				case 3: {
					try {
						accountService.deleteAccountById("aa125");
					} catch (IdNotFoundException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					break;

				}

				case 4:
					accountService.getAllAccounts().forEach((name) -> System.out.println(name));
					break;

				case 5: {

					customerService.createCustomer(customer);

					break;

				}

				case 6:

					System.exit(0);

				}

			}
		} catch (InvalidDateException | InvalidContactNumberException | InsufficientBalanceException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvalidNameException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvalidAddressException | InvalidGovtIdException | InvalidCustomerIdException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
