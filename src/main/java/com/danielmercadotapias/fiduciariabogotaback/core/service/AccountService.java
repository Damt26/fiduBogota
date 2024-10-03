package com.danielmercadotapias.fiduciariabogotaback.core.service;

import com.danielmercadotapias.fiduciariabogotaback.core.dto.bank_account.BankAccountInput;
import com.danielmercadotapias.fiduciariabogotaback.core.dto.bank_account.BankAccountOutput;
import com.danielmercadotapias.fiduciariabogotaback.core.dto.transaction.TransactionInput;
import com.danielmercadotapias.fiduciariabogotaback.core.dto.transaction.TransactionOutput;
import com.danielmercadotapias.fiduciariabogotaback.persistence.model.enums.TransactionTypeEnum;

public interface AccountService {

    BankAccountOutput createBankAccount(BankAccountInput bankAccountInput);

    TransactionOutput createTransaction(Long id,
                                        TransactionInput transactionInput,
                                        TransactionTypeEnum transactionType);

    BankAccountOutput getBalance(Long id);
}
