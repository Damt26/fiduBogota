package com.danielmercadotapias.fiduciariabogotaback.core.dto.bank_account;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.io.Serializable;

/**
 * DTO for {@link com.danielmercadotapias.fiduciariabogotaback.persistence.model.BankAccount}
 */
public record BankAccountInput(
        @NotNull @Size(min = 1, max = 100) @NotEmpty String owner
) implements Serializable {
}