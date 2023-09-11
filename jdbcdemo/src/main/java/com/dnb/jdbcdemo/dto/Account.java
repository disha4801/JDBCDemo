package com.dnb.jdbcdemo.dto;

import java.time.LocalDate;

import java.util.regex.Pattern;

import javax.naming.InvalidNameException;

import com.dnb.jdbcdemo.exceptions.InsufficientBalanceException;
import com.dnb.jdbcdemo.exceptions.InvalidContactNumberException;
import com.dnb.jdbcdemo.exceptions.InvalidDateException;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Getter
@EqualsAndHashCode
@NoArgsConstructor
@ToString(exclude = "customer")
public class Account {

	public Account(String accountId, String accountHolderName, String accountType, float balance, String contactNumber,
			String address, LocalDate accountCreatedDate, LocalDate dob, boolean accountStatus, Customer customer)
			throws InvalidNameException {
		super();
		this.setAccountHolderName(accountHolderName);
	}

	public void setAccountId(String accountId) {
		this.accountId = accountId;
	}

	public void setAccountHolderName(String accountHolderName) throws InvalidNameException {
		String regEx = "^[a-zA-Z]{2,}$";
		if (Pattern.compile(regEx).matcher(accountHolderName).find())
			this.accountHolderName = accountHolderName;
		else
			throw new InvalidNameException("name is not valid");

	}

	public void setAccountType(String accountType) throws InvalidNameException {
		String regEx = "^[a-zA-Z]{2,}$";
		if (Pattern.compile(regEx).matcher(accountType).find())
			this.accountType = accountType;
		else
			throw new InvalidNameException("Type is not valid");
	}

	public void setBalance(float balance) throws InsufficientBalanceException {
		String regEx = "^[-+]?[0-9]*\\.?[0-9]+([eE][-+]?[0-9]+)?$";
		if (String.valueOf(balance).matches(regEx))
			this.balance = balance;
		else
			throw new InsufficientBalanceException("Balance is not valid");

	}

	public void setContactNumber(String contactNumber) throws InvalidContactNumberException {

		String regEx = "^[0-9]{10}$";

		if (Pattern.compile(regEx).matcher(contactNumber).find())

			this.contactNumber = contactNumber;

		else

			throw new InvalidContactNumberException("Contact number is not valid");

	}

	public void setAddress(String address) {
		this.address = address;
	}

	public void setAccountCreatedDate(LocalDate accountCreatedDate) throws InvalidDateException {
		if (Pattern.compile("^\\d{4}-\\d{2}-\\d{2}$").matcher(accountCreatedDate.toString()).find())
			this.accountCreatedDate = accountCreatedDate;
		else {
			throw new InvalidDateException("Date is invalid");
		}
	}

	public void setDob(LocalDate dob) throws InvalidDateException {
		if (Pattern.compile("^\\d{4}-\\d{2}-\\d{2}").matcher(dob.toString()).find())
			this.dob = dob;
		else {
			throw new InvalidDateException("Date is invalid");
		}
	}

	public void setAccountStatus(boolean accountStatus) {
		this.accountStatus = accountStatus;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public String accountId;
	private String accountHolderName;
	private String accountType;
	private float balance;
	private String contactNumber;
	private String address;
	private LocalDate accountCreatedDate = LocalDate.now();
	private LocalDate dob;
	private boolean accountStatus;
	private Customer customer;

}
