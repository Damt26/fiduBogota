package com.danielmercadotapias.fiduciariabogotaback.core.dto.transaction;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * DTO for {@link com.danielmercadotapias.fiduciariabogotaback.persistence.model.Transaction}
 */
public record TransactionInput(
        @NotNull @Positive BigDecimal amount
) implements Serializable {
}