package com.danielmercadotapias.fiduciariabogotaback.persistence.model.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum TransactionTypeEnum {
    DEPOSITO(1L),
    RETIRO(2L);

    private final Long id;
}
