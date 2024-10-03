package com.danielmercadotapias.fiduciariabogotaback.AccountTest;

import com.danielmercadotapias.fiduciariabogotaback.core.dto.bank_account.BankAccountInput;
import com.danielmercadotapias.fiduciariabogotaback.core.dto.bank_account.BankAccountOutput;
import com.danielmercadotapias.fiduciariabogotaback.core.dto.transaction.TransactionInput;
import com.danielmercadotapias.fiduciariabogotaback.core.service.AccountService;
import com.danielmercadotapias.fiduciariabogotaback.persistence.model.enums.TransactionTypeEnum;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;
import java.util.Objects;

@SpringBootTest
public class AccountServiceTest {
    @Autowired
    AccountService accountService;

    @Test
    public void testCreateAccount() {
        BankAccountOutput bankAccount = accountService.createBankAccount(new BankAccountInput("Daniel Mercado Tapias"));
        assert bankAccount != null;
        assert Objects.equals(bankAccount.balance(), BigDecimal.ZERO);
        assert bankAccount.owner().equals("Daniel Mercado Tapias");
    }

    @Test
    public void testTransaction() {
        BankAccountOutput bankAccount = accountService.createBankAccount(new BankAccountInput("Daniel Mercado Tapias"));
        assert bankAccount != null;
        accountService.createTransaction(bankAccount.id(), new TransactionInput(BigDecimal.TEN), TransactionTypeEnum.DEPOSITO);
        accountService.createTransaction(bankAccount.id(), new TransactionInput(BigDecimal.TWO), TransactionTypeEnum.RETIRO);
        assert accountService.getBalance(bankAccount.id()).balance().equals(BigDecimal.valueOf(8));
    }
}
