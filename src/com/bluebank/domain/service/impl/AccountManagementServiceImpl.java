package com.bluebank.domain.service.impl;

import java.math.BigDecimal;
import java.util.LinkedList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bluebank.domain.model.Account;
import com.bluebank.domain.model.Transaction;
import com.bluebank.domain.repository.AccountRepository;
import com.bluebank.domain.service.AccountManagementService;

@Service
public class AccountManagementServiceImpl implements AccountManagementService {

	@Autowired
	AccountRepository repo;

	@Override
	public Account register(Account account) {
		// TODO Auto-generated method stub
		return repo.save(account);
	}

	@Override
	public String withdraw(String accountNumber, BigDecimal amount) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String deposit(String accountNumber, BigDecimal amount) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public LinkedList<Transaction> displayBalance(String accountNumber) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}
	
}
