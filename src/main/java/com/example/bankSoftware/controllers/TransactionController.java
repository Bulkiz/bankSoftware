package com.example.bankSoftware.controllers;

import com.example.bankSoftware.dtos.ResponseDto;
import com.example.bankSoftware.dtos.TransactionDto;
import com.example.bankSoftware.dtos.TransferAmountDto;
import com.example.bankSoftware.entities.Transaction;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/v1/transaction")
public class TransactionController extends BaseController{

    @PostMapping
    public ResponseDto makeTransaction(@RequestBody TransferAmountDto transferAmountDto){
        transactionService.makeTransaction(transferAmountDto.getSourceAccountId(),
                transferAmountDto.getDestinationAccountId(),
                transferAmountDto.getTransferAmount());

        return ResponseDto.builder()
                .code(200)
                .message(String.format("You have successfully transferred %s!", transferAmountDto.getTransferAmount()))
                .build();

    }

    @GetMapping
    public List<Transaction> findAllTransactions(){
        return transactionService.findAll();
    }

    @GetMapping("/{id}")
    public List<Transaction> findTransactionsByAccountId(@PathVariable("id") Integer id){
        return transactionService.findById(id);
    }
}
