package com.danielmercadotapias.fiduciariabogotaback.persistence.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "transaction_type", schema = "bank")
public class TransactionType {
    @Id
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "type", length = 10)
    private String type;

}