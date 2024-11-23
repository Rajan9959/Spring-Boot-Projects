package com.raj.banking.service;

import java.util.List; 
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.raj.banking.dto.AccountDto;
import com.raj.banking.entity.Account;
import com.raj.banking.mapper.AccountMapper;
import com.raj.banking.repository.AccountRepository;

@Service		// To automatically create Spring Bean for this class
public class AccountServiceImpl implements AccountService
{
	@Autowired
	private AccountRepository aRepo;

	public AccountServiceImpl(AccountRepository aRepo)
	{
		this.aRepo = aRepo;
	}

	@Override
	public AccountDto createAccount(AccountDto accountDto)
	{
		// To convert AccountDto into Account
		Account account = AccountMapper.mapToAccount(accountDto);
		// To save the Account Details
		Account savedAccount = aRepo.save(account);
		// To convert savedAccount into AccountDto
		return AccountMapper.mapToAccountDto(savedAccount);
	}

	@Override
	public AccountDto getAccountById(Long id)
	{

		Account account = aRepo.
							findById(id).
							orElseThrow(() -> new RuntimeException("Account does not Exists..!!!"));

		return AccountMapper.mapToAccountDto(account);
	}

	@Override
	public AccountDto deposit(Long id, double amount)
	{
		// To check given Id account is present or Not
		Account account = aRepo.
				findById(id).
				orElseThrow(() -> new RuntimeException("Account does not Exists..!!!"));
		// To update the Total Balance
		double total = account.getBalance() + amount;
		account.setBalance(total);
		Account savedAccount = aRepo.save(account);
		return AccountMapper.mapToAccountDto(savedAccount);
	}

	@Override
	public AccountDto withdraw(Long id, double amount)
	{
		Account account = aRepo.findById(id).orElseThrow(
													() -> new RuntimeException("Account does Not Exist...!!!"));
		if(account.getBalance() < amount)
		{
			throw new RuntimeException("Insufficient Amount");
		}

		double total = account.getBalance() - amount;
		account.setBalance(total);
		Account savedAccount = aRepo.save(account);

		return AccountMapper.mapToAccountDto(savedAccount);
	}

	@Override
	public List<AccountDto> getAllAccounts()
	{
		List<Account> accounts = aRepo.findAll();
		return accounts.stream().map((account) -> AccountMapper.mapToAccountDto(account)).collect(Collectors.toList());
	}

	@Override
	public void deleteAccount(Long id)
	{
		Account account = aRepo.findById(id).orElseThrow(
				() -> new RuntimeException("Account does Not Exist...!!!"));

		aRepo.deleteById(id);

	}





















}
