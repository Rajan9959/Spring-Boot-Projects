package com.raj.banking.dto;

import lombok.AllArgsConstructor; 
import lombok.Data;

@Data		// To generate constructor, setters, getters
@AllArgsConstructor
public class AccountDto
{
	private Long id;
	private String accountHolderName;
	private Double balance;
}
