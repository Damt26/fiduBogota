package com.danielmercadotapias.fiduciariabogotaback.controller.rest;

import com.danielmercadotapias.fiduciariabogotaback.core.dto.bank_account.BankAccountInput;
import com.danielmercadotapias.fiduciariabogotaback.core.dto.bank_account.BankAccountOutput;
import com.danielmercadotapias.fiduciariabogotaback.core.dto.transaction.TransactionInput;
import com.danielmercadotapias.fiduciariabogotaback.core.dto.transaction.TransactionOutput;
import com.danielmercadotapias.fiduciariabogotaback.core.service.AccountService;
import com.danielmercadotapias.fiduciariabogotaback.persistence.model.enums.TransactionTypeEnum;
import jakarta.validation.Valid;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/accounts")
public class AccountCommandRestController {
    private final AccountService service;

    @Autowired
    public AccountCommandRestController(
            final AccountService service
    ) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<BankAccountOutput> newAccount(
            @Valid @RequestBody BankAccountInput accountInput
    ) {
        return new ResponseEntity<>(
                service.createBankAccount(accountInput),
                HttpStatus.CREATED);
    }

    @PostMapping("/{id}/deposit")
    public ResponseEntity<TransactionOutput> makeDeposit(
            @PathVariable Long id,
            @Valid @RequestBody TransactionInput transactionInput
    ) {
        return new ResponseEntity<>(
                service.createTransaction(
                        id,
                        transactionInput,
                        TransactionTypeEnum.DEPOSITO),
                HttpStatus.OK);    }

    @PostMapping("/{id}/withdraw")
    public ResponseEntity<TransactionOutput> makeWithdraw(
            @PathVariable Long id,
            @Valid @RequestBody TransactionInput transactionInput
    ) {
        return new ResponseEntity<>(
                service.createTransaction(
                        id,
                        transactionInput,
                        TransactionTypeEnum.RETIRO),
                HttpStatus.OK);
    }
}
