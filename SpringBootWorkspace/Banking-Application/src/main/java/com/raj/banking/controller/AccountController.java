package com.raj.banking.controller;

import java.util.List; 
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.raj.banking.dto.AccountDto;
import com.raj.banking.service.AccountService;
@RestController		// It converts this class as Spring MVC Rest controller class
@RequestMapping("/api/accounts")	// Base URL for all the Rest api's
public class AccountController
{
	@Autowired
	private AccountService aServ;

	// To inject Account with Constructor
	public AccountController(AccountService aServ)
	{
		this.aServ = aServ;
	}

	// Add Account REST API
	@PostMapping		// To handle HTTP post request
	public ResponseEntity<AccountDto> addAccount(@RequestBody AccountDto accountDto)
	{
		return new ResponseEntity<>(aServ.createAccount(accountDto),HttpStatus.CREATED);
	}

	// Get Account REST API
	@GetMapping("/{id}")
	public ResponseEntity<AccountDto> getAccountById(@PathVariable Long id)
	{
		AccountDto accountDto = aServ.getAccountById(id);
		return ResponseEntity.ok(accountDto);
	}

	// Deposit REST API
	@PutMapping("/{id}/deposit")
	public ResponseEntity<AccountDto> deposit(
												@PathVariable Long id,
												@RequestBody Map<String, Double> request)
	{
		Double amount = request.get("amount");
		System.out.println("Deposited Amount : " + amount);
		AccountDto accountDto = aServ.deposit(id, amount);
		return ResponseEntity.ok(accountDto);
	}

	// Withdrawn REST API
	@PutMapping("/{id}/withdraw")
	public ResponseEntity<AccountDto> withdraw(
												@PathVariable Long id,
												@RequestBody Map<String, Double> request)
	{
		Double amount = request.get("amount");
		System.out.println("Withdrawn Amount : " + amount);
		AccountDto accountDto = aServ.withdraw(id, amount);
		return ResponseEntity.ok(accountDto);
	}

	// Get All Accounts REST API
	@GetMapping
	public ResponseEntity<List<AccountDto>> getAllAccounts()
	{
		List<AccountDto> accounts = aServ.getAllAccounts();
		return ResponseEntity.ok(accounts);
	}

	// Delete Account REST API
	@DeleteMapping("/{id}/delete")
	public ResponseEntity<String> deleteAccount(@PathVariable Long id)
	{
		aServ.deleteAccount(id);
		return ResponseEntity.ok("Account is deleted Successfully...!!!");
	}





}
