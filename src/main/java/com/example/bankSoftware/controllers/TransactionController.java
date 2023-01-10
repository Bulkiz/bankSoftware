package com.example.bankSoftware.controllers;

import com.example.bankSoftware.dtos.ResponseDto;
import com.example.bankSoftware.dtos.TransactionDto;
import com.example.bankSoftware.dtos.TransferAmountDto;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.stream.Collectors;

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
    public List<TransactionDto> findAllTransactions() throws InterruptedException, ExecutionException {

       return threadPool.submitTask(() -> transactionService.findAll().parallelStream().
                map(transaction -> modelMapper.map(transaction, TransactionDto.class))
                .collect(Collectors.toList())).get();
    }

    @GetMapping("/{id}")
    public List<TransactionDto> findTransactionsByAccountId(@PathVariable("id") Integer id) throws InterruptedException, ExecutionException {
       return threadPool.submitTask(() -> transactionService.findById(id).parallelStream().map(transaction ->
                modelMapper.map(transaction, TransactionDto.class)).
                collect(Collectors.toList())).get();
    }
}
