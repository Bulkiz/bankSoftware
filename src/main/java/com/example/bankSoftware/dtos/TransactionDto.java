package com.example.bankSoftware.dtos;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDateTime;


@Getter
@Setter
@Builder
public class TransactionDto {

    private Integer id;
    private AccountDto sourceDto;
    private AccountDto receiverDto;
    private BigDecimal amount;
    private LocalDateTime date;
}
