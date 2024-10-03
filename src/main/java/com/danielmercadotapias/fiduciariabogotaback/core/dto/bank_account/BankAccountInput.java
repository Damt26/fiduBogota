package com.danielmercadotapias.fiduciariabogotaback.core.dto.bank_account;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.io.Serializable;

/**
 * DTO for {@link com.danielmercadotapias.fiduciariabogotaback.persistence.model.BankAccount}
 */
public record BankAccountInput(
        @NotNull(message = "No puede ser nulo")
        @Size(min = 1, max = 100, message = "Debe estar entre 1 y 100")
        @NotEmpty(message = "No puede ser vacio")
        String owner
) implements Serializable {
}