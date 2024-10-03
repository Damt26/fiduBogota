package com.danielmercadotapias.fiduciariabogotaback.persistence.service;

import com.danielmercadotapias.fiduciariabogotaback.persistence.model.BankAccount;
import com.danielmercadotapias.fiduciariabogotaback.persistence.model.Transaction;

public interface AccountPersistenceService {
    BankAccount createBankAccount(BankAccount bankAccount);
    Transaction createTransaction(Transaction transaction);
    BankAccount getBalance(Long id);
}
