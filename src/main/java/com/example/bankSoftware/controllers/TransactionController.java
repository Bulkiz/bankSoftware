package com.example.bankSoftware.controllers;

import com.example.bankSoftware.dtos.ResponseDto;
import com.example.bankSoftware.dtos.TransactionDto;
import com.example.bankSoftware.dtos.TransferAmountDto;
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

    }

    @GetMapping
    public List<TransactionDto> findAllTransactions(){
        return transactionService.findAll();
    }

    @GetMapping("/{id}")
    public List<TransactionDto> findTransactionsById(@PathVariable Integer id){
        return transactionService.findById(id);
    }
}
