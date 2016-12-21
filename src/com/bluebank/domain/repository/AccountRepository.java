package com.bluebank.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.bluebank.domain.model.Account;

@Repository
@Transactional
public interface AccountRepository extends JpaRepository<Account, Long> {
	Account findAccountByAccountNumber(String accountNumber);
}
