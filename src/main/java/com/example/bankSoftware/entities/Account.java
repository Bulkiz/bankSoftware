package com.example.bankSoftware.entities;

import lombok.*;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "accounts")
@NamedQuery(name = "Account.findAll", query = "select a from Account as a order by a.firstName, a.lastName")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Account extends BaseEntity{
    private String firstName;
    private String lastName;
    private String iban;
    private LocalDateTime createDate;
    private BigDecimal balance;

    public void addBalance(BigDecimal amount){
        balance = balance.add(amount);
    }
}
