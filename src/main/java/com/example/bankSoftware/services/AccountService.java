package com.example.bankSoftware.services;

import com.example.bankSoftware.dtos.AccountDto;
import com.example.bankSoftware.entities.Account;
import com.example.bankSoftware.utils.PageCustom;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;

import javax.transaction.Transactional;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

public interface AccountService {

    PageCustom<AccountDto> findAllPaged(Integer id, String firstName, String lastName,
                                       String iban, LocalDateTime creationDate, BigDecimal balance, Integer page, Integer size,
                                       List<String> sortBys, List<Sort.Direction> sortDirections);

    Account createAccount(Account account);

    List<Account> findAll();

    BigDecimal getBalance(Integer id);

    Account updateAccount(Account account);

    Account findAccountById(Integer id);

}
