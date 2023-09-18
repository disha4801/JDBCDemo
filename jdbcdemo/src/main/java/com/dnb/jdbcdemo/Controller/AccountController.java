package com.dnb.jdbcdemo.Controller;

import java.util.List;

import java.util.Optional;
import javax.security.auth.login.AccountNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.dnb.jdbcdemo.dto.Account;
import com.dnb.jdbcdemo.exceptions.IdNotFoundException;
import com.dnb.jdbcdemo.exceptions.InvalidAccountIdException;
import com.dnb.jdbcdemo.payload.request.AccountRequest;
import com.dnb.jdbcdemo.service.AccountService;
import com.dnb.jdbcdemo.utils.RequestToEntityMapper;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/account")
public class AccountController {
	
	@Autowired
	AccountService accountService;
	@Autowired
	RequestToEntityMapper mapper;
	
	
	
	@GetMapping("/allAccounts/{contactNumber}")
	public ResponseEntity<?>getAllAccountsByContactNumber(@PathVariable("contactNumber")String contactNumber) throws AccountNotFoundException{
		List<Account>list=(List<Account>) accountService.getAllAccountsByContactNumber(contactNumber);
		if(list.isEmpty()) {
			throw new AccountNotFoundException("Data not found");
		}
		else {
			return ResponseEntity.ok(list);
		}
	}
	
	//@GetMapping("/cn/{contactNumber:^[0-9]{10}$}")
//	public ResponseEntity<?>getAccountByContactNumber(@PathVariable("contactNumber")String contactNumber) throws InvalidContactNumberException{
//		Optional<Account> optional=accountService.getAccountByContactNumber(contactNumber);
//		if(optional.isPresent()) {
//			return ResponseEntity.ok(optional.get());
//		}
//		else {
//			throw new InvalidContactNumberException("Contact number is Invalid");
//		}
//	}
	
	@DeleteMapping("/{accountId}")
	public ResponseEntity<?> deleteAccountById(@PathVariable("accountId") String accountId) throws  IdNotFoundException, InvalidAccountIdException{
		if(accountService.accountExistsById(accountId)) {
			accountService.deleteAccountById(accountId);
			return (ResponseEntity<?>) ResponseEntity.noContent().build();
		}
		else {
			throw new InvalidAccountIdException("account id not valid");
		}
	}
	
	@GetMapping("/{accountId}")//it should help us get the specific 	
	public ResponseEntity<?> getAccountById(@PathVariable("accountId") String accountId) throws InvalidAccountIdException{
		Optional<Account> optional=accountService.getAccountById(accountId);
		if(optional.isPresent()) {
			return ResponseEntity.ok(optional.get());
		}
		else {
//			Map<String, String>map=new HashMap<>();
//			map.put("message", "accountId nto found");
//			map.put("HttpStatus", HttpStatus.NOT_FOUND+"");
//			ResponseEntity<?> responseEntity=new ResponseEntity(map,HttpStatus.NOT_FOUND);
//			return responseEntity;
			//return ResponseEntity.notFound().build();
			throw new InvalidAccountIdException("Account id is not valid");
		}
		
	}
	
	//insert / create acc : post : @PostMapping
	@PostMapping("/create") //comb of @RequestMapping + post method==>spring v4.3.x
	
	public ResponseEntity<?> createAccount(@Valid @RequestBody AccountRequest accountRequest) {
		
		return ResponseEntity.ok(mapper.getAccountEntityObject(accountRequest));
		
		
//		try {
//			Account account2 = null;
//			try {
//				account2 = accountService.createAccount(account);
//			} catch (InvalidNameException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			} catch (InvalidCustomerIdException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			} catch (InvalidContactNumberException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			} catch (InvalidAddressException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			} catch (InvalidGovtIdException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//			return new ResponseEntity(account2, HttpStatus.CREATED);
//		} catch (IdNotFoundException e) {
//			// TODO Auto-generated catch block
//			return ResponseEntity.badRequest().body(e.getMessage());
//		}
	}
}