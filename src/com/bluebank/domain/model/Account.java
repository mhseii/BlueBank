package com.bluebank.domain.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Calendar;
import java.util.LinkedList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Version;

@Entity
public class Account implements Serializable {

	private static final long serialVersionUID = -5138782382066181116L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "account_id")
	private Long id;
	@Version
	private Long version;
	private String accountNumber;
	private boolean isActive;
	@Temporal(TemporalType.DATE)
	private Calendar startDate;
	@Temporal(TemporalType.DATE)
	private Calendar endDate;
	@OneToOne
	private Customer accountHolder;
	private BigDecimal balance;
	private BigDecimal dailyLimit;
	@OneToMany
	private List<Transaction> transactionsList;

	public Account() {
	}
	
	public Account(String accountNumber, boolean isActive, Calendar startDate, Calendar endDate, Customer accountHolder,
			BigDecimal balance, BigDecimal dailyLimit, List<Transaction> transactionsList) {
		super();
		this.accountNumber = accountNumber;
		this.isActive = isActive;
		this.startDate = startDate;
		this.endDate = endDate;
		this.accountHolder = accountHolder;
		this.balance = balance;
		this.dailyLimit = dailyLimit;
		this.transactionsList = transactionsList;
	}

	public Long getId() {
		return id;
	}

	public Long getVersion() {
		return version;
	}

	public String getAccountNumber() {
		return accountNumber;
	}

	public boolean isActive() {
		return isActive;
	}

	public Calendar getStartDate() {
		return startDate;
	}

	public Calendar getEndDate() {
		return endDate;
	}

	public Customer getAccountHolder() {
		return accountHolder;
	}

	public BigDecimal getBalance() {
		return balance;
	}

	public BigDecimal getDailyLimit() {
		return dailyLimit;
	}

	public List<Transaction> getTransactionsList() {
		return transactionsList;
	}

	public void setVersion(Long version) {
		this.version = version;
	}

	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}

	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}

	public void setStartDate(Calendar startDate) {
		this.startDate = startDate;
	}

	public void setEndDate(Calendar endDate) {
		this.endDate = endDate;
	}

	public void setAccountHolder(Customer accountHolder) {
		this.accountHolder = accountHolder;
	}

	public void setBalance(BigDecimal balance) {
		this.balance = balance;
	}

	public void setDailyLimit(BigDecimal dailyLimit) {
		this.dailyLimit = dailyLimit;
	}

	public void setTransactionsList(LinkedList<Transaction> transactionsList) {
		this.transactionsList = transactionsList;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((accountHolder == null) ? 0 : accountHolder.hashCode());
		result = prime * result + ((accountNumber == null) ? 0 : accountNumber.hashCode());
		result = prime * result + ((balance == null) ? 0 : balance.hashCode());
		result = prime * result + ((dailyLimit == null) ? 0 : dailyLimit.hashCode());
		result = prime * result + ((endDate == null) ? 0 : endDate.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + (isActive ? 1231 : 1237);
		result = prime * result + ((startDate == null) ? 0 : startDate.hashCode());
		result = prime * result + ((transactionsList == null) ? 0 : transactionsList.hashCode());
		result = prime * result + ((version == null) ? 0 : version.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Account other = (Account) obj;
		if (accountHolder == null) {
			if (other.accountHolder != null)
				return false;
		} else if (!accountHolder.equals(other.accountHolder))
			return false;
		if (accountNumber == null) {
			if (other.accountNumber != null)
				return false;
		} else if (!accountNumber.equals(other.accountNumber))
			return false;
		if (balance == null) {
			if (other.balance != null)
				return false;
		} else if (!balance.equals(other.balance))
			return false;
		if (dailyLimit == null) {
			if (other.dailyLimit != null)
				return false;
		} else if (!dailyLimit.equals(other.dailyLimit))
			return false;
		if (endDate == null) {
			if (other.endDate != null)
				return false;
		} else if (!endDate.equals(other.endDate))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (isActive != other.isActive)
			return false;
		if (startDate == null) {
			if (other.startDate != null)
				return false;
		} else if (!startDate.equals(other.startDate))
			return false;
		if (transactionsList == null) {
			if (other.transactionsList != null)
				return false;
		} else if (!transactionsList.equals(other.transactionsList))
			return false;
		if (version == null) {
			if (other.version != null)
				return false;
		} else if (!version.equals(other.version))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Account [id=" + id + ", version=" + version + ", accountNumber=" + accountNumber + ", isActive="
				+ isActive + ", startDate=" + startDate + ", endDate=" + endDate + ", accountHolder=" + accountHolder
				+ ", balance=" + balance + ", dailyLimit=" + dailyLimit + ", transactionsList=" + transactionsList
				+ "]";
	}

}
