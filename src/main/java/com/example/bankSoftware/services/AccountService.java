package com.example.bankSoftware.services;

import com.example.bankSoftware.dtos.AccountDto;
import com.example.bankSoftware.entities.Account;
import org.springframework.http.ResponseEntity;

import java.math.BigDecimal;
import java.util.List;

public interface AccountService {

    Account createAccount(Account account);

    List<Account> findAll();

    BigDecimal getBalance(Integer id);
}
