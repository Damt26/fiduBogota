package com.danielmercadotapias.fiduciariabogotaback.controller.rest;

import com.danielmercadotapias.fiduciariabogotaback.core.dto.bank_account.BankAccountInput;
import com.danielmercadotapias.fiduciariabogotaback.core.dto.bank_account.BankAccountOutput;
import com.danielmercadotapias.fiduciariabogotaback.core.service.AccountService;
import com.danielmercadotapias.fiduciariabogotaback.persistence.model.enums.TransactionTypeEnum;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class AccountQueryRestController {
    private final AccountService service;

    @Autowired
    public AccountQueryRestController(
            final AccountService service
    ) {
        this.service = service;
    }

    @GetMapping("accounts/{id}/balance")
    public ResponseEntity<BankAccountOutput> getAccountInfo(
            @PathVariable Long id
    ) {
        return new ResponseEntity<>(
                service.getBalance(
                        id),
                HttpStatus.OK);
    }
}
