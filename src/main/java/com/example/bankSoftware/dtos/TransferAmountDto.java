package com.example.bankSoftware.dtos;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
@Getter
@Setter
public class TransferAmountDto {

    private Integer sourceAccountId;
    private Integer destinationAccountId;
    private BigDecimal transferAmount;

}
