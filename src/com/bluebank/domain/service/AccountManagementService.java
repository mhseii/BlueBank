package com.bluebank.domain.service;

import java.math.BigDecimal;
import java.util.LinkedList;

import com.bluebank.domain.model.Account;
import com.bluebank.domain.model.Transaction;

public interface AccountManagementService {
	
	Account register(Account account);
	
	String withdraw(String accountNumber, BigDecimal amount) throws Exception;
	
	String deposit(String accountNumber, BigDecimal amount) throws Exception;

	LinkedList<Transaction> displayBalance(String accountNumber) throws Exception;
	
}
