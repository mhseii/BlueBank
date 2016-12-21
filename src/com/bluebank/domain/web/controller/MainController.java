package com.bluebank.domain.web.controller;

import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.LinkedList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.bluebank.domain.model.Account;
import com.bluebank.domain.model.Customer;
import com.bluebank.domain.model.Transaction;
import com.bluebank.domain.service.AccountManagementService;
import com.bluebank.domain.service.impl.AccountManagementServiceImpl;

@Controller
public class MainController {

	protected SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	protected AccountManagementService svc = new AccountManagementServiceImpl();
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String main() throws ParseException {
		
		String accountNumber = "20161221000000001";
		boolean isActive = true;
		Calendar startDate = Calendar.getInstance();
		startDate.setTime(sdf.parse("21/12/2016"));
		Calendar endDate = Calendar.getInstance();
		endDate.setTime(sdf.parse("31/12/2100"));
		BigDecimal balance = new BigDecimal("30000.00");
		BigDecimal dailyLimit = new BigDecimal("2000.00");
		List<Transaction> transactionsList = new LinkedList<Transaction>();
		
		Customer accountHolder = new Customer();
		accountHolder.setName("Mauricio Heidi Seii");
		Calendar birthDate = Calendar.getInstance();
		birthDate.setTime(sdf.parse("24/05/1990"));
		accountHolder.setBirthDate(birthDate);
		accountHolder.setSsn("34804857826");
		
		Account entity = new Account(accountNumber, isActive, startDate, endDate, accountHolder, balance, dailyLimit, transactionsList);
		svc.register(entity);
		
		return "index";
	}
	
}
