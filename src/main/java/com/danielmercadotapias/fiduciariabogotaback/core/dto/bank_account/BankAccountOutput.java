package com.danielmercadotapias.fiduciariabogotaback.core.dto.bank_account;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * DTO for {@link com.danielmercadotapias.fiduciariabogotaback.persistence.model.BankAccount}
 */
public record BankAccountOutput(
        Long id,
        String owner,
        BigDecimal balance,
        LocalDateTime createdOn)
        implements Serializable {
}