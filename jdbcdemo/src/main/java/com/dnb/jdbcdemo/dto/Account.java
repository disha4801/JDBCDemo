package com.dnb.jdbcdemo.dto;

import java.time.LocalDate;
import java.util.regex.Pattern;
import javax.naming.InvalidNameException;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;
import org.hibernate.validator.constraints.Length;
import com.dnb.jdbcdemo.utils.CustomAccountIdGenerator;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Transient;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@Getter
@EqualsAndHashCode
@NoArgsConstructor
@ToString
@Entity

public class Account {
//	public Account(String accountId, String accountHolderName, String accountType, float balance, String contactNumber,
//			String address, LocalDate accountCreatedDate, LocalDate dob,  int customerId)
//			throws InvalidNameException, InvalidDateException, InvalidContactNumberException, InsufficientBalanceException {
//		super();
//		this.setAccountId(accountId);
//		this.setAccountHolderName(accountHolderName);
//		this.setAccountHolderName(accountHolderName);
//		this.setAccountType(accountType);
//		this.setBalance(balance);
//		this.setContactNumber(contactNumber);
//		this.setAddress(address);
//		this.setAccountCreatedDate(accountCreatedDate);
//		this.setDob(dob);
//		this.setCustomer(customerId);
//	}

//	public void setAccountId(String accountId) {
//		this.accountId = accountId;
//	}
//
//	public void setAccountHolderName(String accountHolderName) throws InvalidNameException {
//		String regEx = "^[a-zA-Z]{2,}$";
//		if (Pattern.compile(regEx).matcher(accountHolderName).find())
//			this.accountHolderName = accountHolderName;
//		else
//			throw new InvalidNameException("name is not valid");
//
//	}
//
//	public void setAccountType(String accountType) throws InvalidNameException {
//		String regEx = "^[a-zA-Z]{2,}$";
//		if (Pattern.compile(regEx).matcher(accountType).find())
//			this.accountType = accountType;
//		else
//			throw new InvalidNameException("Type is not valid");
//	}
//
//	public void setBalance(float balance) throws InsufficientBalanceException {
//		String regEx = "^[-+]?[0-9]*\\.?[0-9]+([eE][-+]?[0-9]+)?$";
//		if (String.valueOf(balance).matches(regEx))
//			this.balance = balance;
//		else
//			throw new InsufficientBalanceException("Balance is not valid");
//
//	}
//
//	public void setContactNumber(String contactNumber) throws InvalidContactNumberException {
//
//		String regEx = "^[0-9]{10}$";
//
//		if (Pattern.compile(regEx).matcher(contactNumber).find())
//
//			this.contactNumber = contactNumber;
//
//		else
//
//			throw new InvalidContactNumberException("Contact number is not valid");
//
//	}
//
//	public void setAddress(String address) {
//		this.address = address;
//	}
//
//	public void setAccountCreatedDate(LocalDate accountCreatedDate) throws InvalidDateException {
//		if (Pattern.compile("^\\d{4}-\\d{2}-\\d{2}$").matcher(accountCreatedDate.toString()).find())
//			this.accountCreatedDate = accountCreatedDate;
//		else {
//			throw new InvalidDateException("Date is invalid");
//		}
//	}
//
//	public void setDob(LocalDate dob) throws InvalidDateException {
//		if (Pattern.compile("^\\d{4}-\\d{2}-\\d{2}").matcher(dob.toString()).find())
//			this.dob = dob;
//		else {
//			throw new InvalidDateException("Date is invalid");
//		}
//	}
//
//	public void setAccountStatus(boolean accountStatus) {
//		this.accountStatus = accountStatus;
//	}
//
//	public void setCustomer(int customerId) {
//		this.customerId = customerId;
//	}

	@Id
	// @GeneratedValue(strategy = GenerationType.UUID)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "account_seq")
	@GenericGenerator(name = "account_seq", strategy = "com.dnb.jdbcdemo.utils.DatePrefixedSequenceIdGenerator", parameters = {
//			 @Parameter(name=CustomAccountIdGenerator.INCREMENT_PARAM,value ="50")})
//			 @Parameter(name =CustomAccountIdGenerator.VALUE_PREFIX_PARAMETER,value="A_"),
			@Parameter(name = CustomAccountIdGenerator.NUMBER_FORMAT_PARAMETER, value = "_%05d") })
  
	@NotBlank(message = "account id should not be blank")
	public String accountId;
	@Column(nullable = false)
	@NotBlank(message = "account id should not be blank")
	private String accountHolderName;
	private String accountType;
	@Min(value = 0, message = "value should not be negative")
	private float balance;
	@Length(min = 10, max = 10)
	@NotBlank
	@jakarta.validation.constraints.Pattern(regexp = "^[0-9]{10}$")
	private String contactNumber;
	private String address;
	private LocalDate accountCreatedDate = LocalDate.now();
	@NotNull(message = "Date should be added")
	@NotBlank(message ="Date should not be blank")
	@jakarta.validation.constraints.Pattern(regexp = "^(\\d{4})-(\\d{2})-(\\d{2})$")
	private LocalDate dob;
	@Transient
	private boolean accountStatus;
	@ManyToOne(cascade=CascadeType.ALL,fetch=FetchType.EAGER)
	@JoinColumn(name="customer_id",referencedColumnName = "customerId")
	private Customer customer;
	

}
