package com.example.bankSoftware.services;

import com.example.bankSoftware.dtos.TransactionDto;
import com.example.bankSoftware.entities.Transaction;

import java.math.BigDecimal;
import java.util.List;

public interface TransactionService {
    void makeTransaction(Integer senderId, Integer receiverId, BigDecimal amount);
    List<Transaction> findAll();
    List<Transaction> findById(Integer id);
}
