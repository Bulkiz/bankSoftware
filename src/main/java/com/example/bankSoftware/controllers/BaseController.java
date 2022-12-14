package com.example.bankSoftware.controllers;

import com.example.bankSoftware.Config;
import com.example.bankSoftware.services.AccountService;
import com.example.bankSoftware.services.TransactionService;
import com.fasterxml.jackson.databind.ObjectMapper;
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

    @Autowired protected AccountService accountService;

    @ExceptionHandler(NoSuchElementException.class)
    @ResponseStatus(value = HttpStatus.NOT_FOUND)
    public String handle(){
        return "There is no such element in our data :(";
    }

    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public String handleServerError(){
        return "There is a problem with the server!";
    }


}
