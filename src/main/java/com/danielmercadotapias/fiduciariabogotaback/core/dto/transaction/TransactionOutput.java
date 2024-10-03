package com.danielmercadotapias.fiduciariabogotaback.core.dto.transaction;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * DTO for {@link com.danielmercadotapias.fiduciariabogotaback.persistence.model.Transaction}
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public record TransactionOutput(
        Long id,
        Long bankAccountId,
        String transactionTypeType,
        BigDecimal amount,
        LocalDateTime createdOn
) implements Serializable {
}