package com.raj.banking.repository;

import org.springframework.data.jpa.repository.JpaRepository; 

import com.raj.banking.entity.Account;

// By extending this AccountRepository with JpaRepository then this Repository will get
// a CRUD database methods to perform CRUD operations.
public interface AccountRepository extends JpaRepository<Account, Long> {

}
