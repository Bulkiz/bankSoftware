package com.example.bankSoftware.controllers;

import com.example.bankSoftware.dtos.AccountDto;
import com.example.bankSoftware.entities.Account;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/v1/account")
public class AccountController extends BaseController {

    @PostMapping
    public ResponseEntity<AccountDto> createAccount(@RequestBody AccountDto accountDto) {
        return new ResponseEntity<>(modelMapper.map
                (accountService.createAccount(modelMapper.map(accountDto, Account.class)),
                        AccountDto.class),
                HttpStatus.CREATED);
    }
    @PutMapping
    public ResponseEntity<AccountDto> updateAccount(@RequestBody AccountDto accountDto) {
        return new ResponseEntity<>(modelMapper.map
                (accountService.updateAccount(modelMapper.map(accountDto, Account.class)),
                        AccountDto.class),
                HttpStatus.CREATED);
    }

    @GetMapping
    public List<AccountDto> findAllAccounts() {
        return accountService.findAll().parallelStream().
                map(account -> modelMapper.map(account, AccountDto.class))
                .collect(Collectors.toList());
    }
    @GetMapping("/{id}")
    public BigDecimal getBalance(@PathVariable Integer id) {
        return accountService.getBalance(id);
    }

}
