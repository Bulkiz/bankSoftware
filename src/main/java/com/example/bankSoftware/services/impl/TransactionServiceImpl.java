package com.example.bankSoftware.services.impl;

import com.example.bankSoftware.dtos.TransactionDto;
import com.example.bankSoftware.dtos.TransferAmountDto;
import com.example.bankSoftware.entities.Account;
import com.example.bankSoftware.entities.Transaction;
import com.example.bankSoftware.mappers.AccountMapper;
import com.example.bankSoftware.mappers.TransactionMapper;
import com.example.bankSoftware.repositories.AccountRepository;
import com.example.bankSoftware.repositories.TransactionRepository;
import com.example.bankSoftware.services.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

@Service
@Transactional
public class TransactionServiceImpl implements TransactionService {

    @Override
    public void makeTransaction(Integer senderId, Integer receiverId, BigDecimal amount) {


    }

    @Override
    public List<TransactionDto> findAll() {
        return transactionMapper.allToDtos(transactionRepository.findAll());
    }

    @Override
    public List<TransactionDto> findById(Integer id) {
        List<Transaction> transactions = new ArrayList<>();

            if (accountRepository.findById(id).isPresent()) {
                Account account = accountRepository.findById(id).get();
                transactionRepository.findAll().forEach(transaction -> {
                    if (transaction.getSource().getId().equals(id)) {
                        transactions.add(transaction);
                    }
                });
                return transactionMapper.allToDtos(transactions);
            } else {
                throw new NoSuchElementException();
            }

        }
    }



