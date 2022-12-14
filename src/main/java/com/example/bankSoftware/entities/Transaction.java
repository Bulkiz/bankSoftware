package com.example.bankSoftware.entities;

import lombok.*;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Date;

@Entity
@Table(name = "transactions")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Transaction extends BaseEntity{

    @ManyToOne
    private Account sourceAccount;
    @ManyToOne
    private Account destinationAccount;
    private BigDecimal transactionAmount;
    private LocalDateTime creationDate;
}
