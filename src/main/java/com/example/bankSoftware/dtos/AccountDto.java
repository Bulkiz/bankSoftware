package com.example.bankSoftware.dtos;

import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AccountDto {
    private Integer id;
    private String firstName;
    private String lastName;
    private String iban;
    private LocalDateTime createDate;
    private BigDecimal balance;
}
