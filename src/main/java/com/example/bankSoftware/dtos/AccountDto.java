package com.example.bankSoftware.dtos;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import java.math.BigDecimal;
import java.time.LocalDateTime;
@Getter
@Setter
@Builder
public class AccountDto {
    private Integer id;
    private String firstName;
    private String lastName;
    private String iban;
    private LocalDateTime createDate;
    private BigDecimal balance;
}
