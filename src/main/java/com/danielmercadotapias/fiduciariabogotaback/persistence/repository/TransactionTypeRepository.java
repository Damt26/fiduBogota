package com.danielmercadotapias.fiduciariabogotaback.persistence.repository;

import com.danielmercadotapias.fiduciariabogotaback.persistence.model.TransactionType;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TransactionTypeRepository extends JpaRepository<TransactionType, Long> {
}