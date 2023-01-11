package com.example.bankSoftware.services;

import com.example.bankSoftware.entities.Transaction;
import java.math.BigDecimal;
import java.util.List;

public interface TransactionService {
    void makeTransaction(Integer senderId, Integer receiverId, BigDecimal amount) throws InterruptedException;
    List<Transaction> findAll() throws InterruptedException;
    List<Transaction> findById(Integer id) throws InterruptedException;
}
