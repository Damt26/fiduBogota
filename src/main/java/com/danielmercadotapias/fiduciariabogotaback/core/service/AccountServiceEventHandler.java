package com.danielmercadotapias.fiduciariabogotaback.core.service;

import com.danielmercadotapias.fiduciariabogotaback.core.dto.bank_account.BankAccountInput;
import com.danielmercadotapias.fiduciariabogotaback.core.dto.bank_account.BankAccountOutput;
import com.danielmercadotapias.fiduciariabogotaback.core.dto.transaction.TransactionInput;
import com.danielmercadotapias.fiduciariabogotaback.core.dto.transaction.TransactionOutput;
import com.danielmercadotapias.fiduciariabogotaback.persistence.model.BankAccount;
import com.danielmercadotapias.fiduciariabogotaback.persistence.model.Transaction;
import com.danielmercadotapias.fiduciariabogotaback.persistence.model.enums.TransactionTypeEnum;
import com.danielmercadotapias.fiduciariabogotaback.persistence.service.AccountPersistenceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;

@Service
@Transactional
public class AccountServiceEventHandler implements AccountService {
    private final AccountPersistenceService persistenceService;

    @Autowired
    public AccountServiceEventHandler(
            AccountPersistenceService persistenceService
    ) {
        this.persistenceService = persistenceService;
    }

    @Override
    public BankAccountOutput createBankAccount(
            BankAccountInput bankAccountInput) {
        BankAccount bankAccount =
                persistenceService.createBankAccount(
                        BankAccount
                                .builder()
                                .owner(bankAccountInput.owner())
                                .balance(BigDecimal.ZERO)
                                .build());

        return converter(bankAccount);
    }

    @Override
    public TransactionOutput createTransaction(
            Long id,
            TransactionInput transactionInput,
            TransactionTypeEnum transactionType) {
        Transaction transaction = persistenceService.createTransaction(
                Transaction
                        .builder()
                        .bankAccountId(id)
                        .transactionTypeId(transactionType.getId())
                        .amount(transactionInput.amount())
                        .build());

        return new TransactionOutput(
                transaction.getId(),
                id,
                transactionType.name(),
                transaction.getAmount(),
                transaction.getCreatedOn()
        );
    }

    @Override
    public BankAccountOutput getBalance(Long id) {
        BankAccount bankAccount = persistenceService.getBalance(id);
        return converter(bankAccount);
    }

    private BankAccountOutput converter(
            BankAccount bankAccount
    ) {
        return new BankAccountOutput(
                bankAccount.getId(),
                bankAccount.getOwner(),
                bankAccount.getBalance(),
                bankAccount.getCreatedOn());
    }
}
