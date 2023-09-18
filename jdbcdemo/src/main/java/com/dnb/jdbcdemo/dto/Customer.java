package com.dnb.jdbcdemo.dto;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;
import javax.naming.InvalidNameException;
import com.dnb.jdbcdemo.exceptions.InvalidAddressException;
import com.dnb.jdbcdemo.exceptions.InvalidContactNumberException;
import com.dnb.jdbcdemo.exceptions.InvalidCustomerIdException;
import com.dnb.jdbcdemo.exceptions.InvalidGovtIdException;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.NotBlank;
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
public class Customer {
//
//	public Customer(int customerId, String customerName, String customerContactNumber, String customerAddress,
//			String customerPAN, String customerUUID) throws InvalidNameException, InvalidContactNumberException, InvalidAddressException, InvalidGovtIdException, InvalidCustomerIdException {
//		super();
//		this.setCustomerId(customerId);
//		this.setCustomerName(customerName);
//		this.setCustomerContactNumber(customerContactNumber);
//		this.setCustomerAddress(customerAddress);
//		this.setCustomerPAN(customerPAN);
//		this.setCustomerUUID(customerUUID);
//	}
//
// 
//
	@Id
	@NotBlank(message = "account id should not be blank")
	private int customerId;
	private String customerName;
	private String customerContactNumber;
	private String customerAddress;
	private String customerPAN;
	private String customerUUID;
	@OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL, mappedBy = "customer")
	private List<Account> accountList = new ArrayList<>();
}

// 
//
//	public void setCustomerId(int customerId) throws InvalidCustomerIdException {
//		String regex = "^-?\\d+$";
//
// 
//
//		if (Pattern.compile(regex).matcher(Integer.toString(customerId)).find())
//
// 
//
//			this.customerId = customerId;
//
// 
//
//		else
//
// 
//
//			throw new InvalidCustomerIdException("Given ID is not valid");
//	}
//
// 
//
//	public void setCustomerName(String customerName) throws InvalidNameException {
//		String regex = "^[a-zA-Z]{2,}$";
//
// 
//
//		if (Pattern.compile(regex).matcher(customerName).find())
//			this.customerName = customerName;
//		else
//			throw new InvalidNameException("Name is not valid");
//	}
//
// 
//
//	public void setCustomerContactNumber(String customerContactNumber) throws InvalidContactNumberException {
//		String regex = "^[1-9][0-9]{0,9}$";
//		//Maximum length should be 10 and contain only numbers and should not start with 0
//		if (Pattern.compile(regex).matcher(customerContactNumber).find())
//			this.customerContactNumber = customerContactNumber;
//		else
//			throw new InvalidContactNumberException("Invalid Contact number");
//	}
//
// 
//
//	public void setCustomerAddress(String customerAddress) throws InvalidAddressException {
//		String regex = "[A-Za-z]";
//		// alpha numeric address restricting spl charcters
//		if (Pattern.compile(regex).matcher(customerAddress).find())
//			this.customerAddress = customerAddress;
//		else
//			throw new InvalidAddressException("Address is invalis shouldnt contain spl characters");
//	}
//
// 
//
//	public void setCustomerPAN(String customerPAN) throws InvalidGovtIdException {
//		String regex="^[A-Z]{5}[0-9]{4}[A-Z]{1}$";
//		if (Pattern.compile(regex).matcher(customerPAN).find())
//			this.customerPAN = customerPAN;
//		else
//			throw new InvalidGovtIdException("Invalid PAN Card");
//	}
//
// 
//
//	public void setCustomerUUID(String customerUUID) throws InvalidGovtIdException {
//		String regex="^[0-9]{12}$";
//		if (Pattern.compile(regex).matcher(customerUUID).find())
//			this.customerUUID = customerUUID;
//		else
//			throw new InvalidGovtIdException("Invalid Aadhaar Card");
//	}
//
// 
//
//}
