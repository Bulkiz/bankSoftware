package com.example.bankSoftware.controllers;

import com.example.bankSoftware.dtos.AccountDto;
import com.example.bankSoftware.entities.Account;
import com.example.bankSoftware.utils.PageCustom;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;
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
    @GetMapping("/{id}/balace")
    public BigDecimal getBalance(@PathVariable Integer id) {
        return accountService.getBalance(id);
    }

    @GetMapping("/{id}")
    public AccountDto findAccount(@PathVariable Integer id){
        return modelMapper.map(accountService.findAccountById(id), AccountDto.class);
    }

    @GetMapping("/page")
    public ResponseEntity<PageCustom<AccountDto>> findAllPagedAccounts(
            @RequestParam(required = false) Integer id,
            @RequestParam(required = false) String firstName,
            @RequestParam(required = false) String lastName,
            @RequestParam(required = false) String iban,
            @RequestParam(required = false) LocalDateTime creationDate,
            @RequestParam(required = false) BigDecimal balance,
            @RequestParam(required = true) Integer page,
            @RequestParam(required = true) Integer size,
            @RequestParam(defaultValue = "id") List<String> sortBy,
            @RequestParam(defaultValue = "ASC") List<Sort.Direction> sortDirection
    ) {
        PageCustom<AccountDto> contractorPage = accountService.findAllPaged(id, firstName, lastName, iban,
                creationDate, balance, page, size, sortBy, sortDirection);

        return ResponseEntity.ok(contractorPage);
    }

}
