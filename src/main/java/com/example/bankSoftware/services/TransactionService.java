package com.example.bankSoftware.services;

import com.example.bankSoftware.dtos.TransactionDto;

import java.math.BigDecimal;
import java.util.List;

public interface TransactionService {
    void makeTransaction(Integer senderId, Integer receiverId, BigDecimal amount);
    List<TransactionDto> findAll();
    List<TransactionDto> findById(Integer id);
}
