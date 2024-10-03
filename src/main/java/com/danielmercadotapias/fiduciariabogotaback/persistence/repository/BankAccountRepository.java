package com.danielmercadotapias.fiduciariabogotaback.persistence.repository;

import com.danielmercadotapias.fiduciariabogotaback.persistence.model.BankAccount;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BankAccountRepository extends JpaRepository<BankAccount, Long> {
}