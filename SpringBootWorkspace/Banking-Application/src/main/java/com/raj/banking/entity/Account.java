package com.raj.banking.entity;

import jakarta.persistence.Column; 
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter					  // To generate getters
@Setter					  // To generate setters
@ToString				  // Generates an implementation for the toString method inherited by all objects
@EqualsAndHashCode		  // Generates an implementation for the equals and hashCode method inherited by all objects
@NoArgsConstructor		  // To generate No-arg Constructor
@AllArgsConstructor		  // To generate an All-arg Constructor
@Table(name = "accounts") // To configure the Table details
@Entity 				  // To make this class as a JPA Entity
public class Account
{
	@Id		// To make this field as a primary key in our Database
	@GeneratedValue(strategy = GenerationType.IDENTITY)	// To increment the primary key automatically
	private Long id;

	@Column(name = "account_holder_name")	// To configure the column name to the field
	private String accountHolderName;
	private Double balance;
}
