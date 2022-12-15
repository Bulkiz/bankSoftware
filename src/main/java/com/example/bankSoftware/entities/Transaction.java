package com.example.bankSoftware.entities;

import lombok.*;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "transactions", indexes = {
        @Index(name = "idx_source_account", columnList = "source_account_id")
})
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
