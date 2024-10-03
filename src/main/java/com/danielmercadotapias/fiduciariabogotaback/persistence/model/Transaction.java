package com.danielmercadotapias.fiduciariabogotaback.persistence.model;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Getter
@Setter
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "transaction", schema = "bank")
public class Transaction {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "bank_account_id", insertable = false, updatable = false)
    @Fetch(FetchMode.JOIN)
    private BankAccount bankAccount;

    @Column(name = "bank_account_id")
    private Long bankAccountId;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "transaction_type_id", insertable = false, updatable = false)
    @Fetch(FetchMode.JOIN)
    private TransactionType transactionType;

    @Column(name = "transaction_type_id")
    private Long transactionTypeId;

    @Column(name = "amount", nullable = false)
    private BigDecimal amount;

    @CreationTimestamp
    @Column(name = "created_on")
    private LocalDateTime createdOn;

}