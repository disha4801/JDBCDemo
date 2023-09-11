package com.dnb.jdbcdemo.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Customer {
	
	public int customerId;
	public String customerName;
	private String customerContactNumber;
	public String customerAddress;
	public String customerPAN;
	public String customerUUID;

}
