package com.danielmercadotapias.fiduciariabogotaback.persistence.service;

import com.danielmercadotapias.fiduciariabogotaback.persistence.model.BankAccount;
import com.danielmercadotapias.fiduciariabogotaback.persistence.model.Transaction;
import com.danielmercadotapias.fiduciariabogotaback.persistence.model.enums.TransactionTypeEnum;
import com.danielmercadotapias.fiduciariabogotaback.persistence.repository.BankAccountRepository;
import com.danielmercadotapias.fiduciariabogotaback.persistence.repository.TransactionRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
@Transactional
public class AccountPersistenceEventHandler implements AccountPersistenceService {
    private final BankAccountRepository bankAccountRepository;
    private final TransactionRepository transactionRepository;

    @Autowired
    public AccountPersistenceEventHandler(
            final BankAccountRepository bankAccountRepository,
            final TransactionRepository transactionRepository
    ) {
        this.bankAccountRepository = bankAccountRepository;
        this.transactionRepository = transactionRepository;
    }

    @Override
    public BankAccount createBankAccount(BankAccount bankAccount) {
        return bankAccountRepository.save(bankAccount);
    }

    @Override
    public Transaction createTransaction(Transaction transaction) {
        BankAccount bankAccount =
                bankAccountRepository.findById(transaction.getBankAccountId())
                        .orElseThrow(() -> new EntityNotFoundException("Bank account not found"));
        if (transaction.getTransactionTypeId().equals(TransactionTypeEnum.RETIRO.getId())) {
            if (bankAccount.getBalance().compareTo(transaction.getAmount()) > 0) {
                bankAccount.setBalance(bankAccount.getBalance().subtract(transaction.getAmount()));
            }else{
                throw new IllegalArgumentException("Transaction amount exceeds balance");
            }
        } else {
            bankAccount.setBalance(bankAccount.getBalance().add(transaction.getAmount()));
        }
        return transactionRepository.save(transaction);
    }

    @Override
    public BankAccount getBalance(Long id) {
        return bankAccountRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Bank account not found"));
    }
}
