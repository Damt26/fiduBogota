package com.danielmercadotapias.fiduciariabogotaback.persistence.repository;

import com.danielmercadotapias.fiduciariabogotaback.persistence.model.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TransactionRepository extends JpaRepository<Transaction, Long> {
}