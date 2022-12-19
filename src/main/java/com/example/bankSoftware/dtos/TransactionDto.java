package com.example.bankSoftware.dtos;

import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;


@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TransactionDto {

    private Integer id;
    private AccountDto sourceAccount;
    private AccountDto destinationAccount;
    private BigDecimal transactionAmount;
    private LocalDateTime creationDate;
}
