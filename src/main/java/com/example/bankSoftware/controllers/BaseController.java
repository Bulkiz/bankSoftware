package com.example.bankSoftware.controllers;

import com.example.bankSoftware.customThreadPool.ThreadPool;
import com.example.bankSoftware.dtos.ResponseDto;
import com.example.bankSoftware.services.AccountService;
import com.example.bankSoftware.services.TransactionService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.NoSuchElementException;

@Component
public class BaseController {
    @Autowired protected ModelMapper modelMapper;
    @Autowired protected TransactionService transactionService;
    @Autowired protected ThreadPool threadPool;
    @Autowired protected AccountService accountService;
    @ExceptionHandler(NoSuchElementException.class)
    @ResponseStatus(value = HttpStatus.NOT_FOUND)
    public ResponseDto handle(){
        return ResponseDto.builder()
                .code(404)
                .message("There's no such element in our data")
                .build();
    }

//    @ExceptionHandler(Exception.class)
//    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
//    public ResponseDto handleServerError(){
//        return ResponseDto.builder()
//                .code(500)
//                .message("There's a problem with our server")
//                .build();
//    }


}
