package br.com.payments.core.domain.entities;

import br.com.payments.core.domain.valueObjects.UserTypeEnum;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

public record Transaction(
        UUID transactionId,
        LocalDateTime transactionDate,
        BigDecimal value,
        User payer,
        User payee
) {
    public static Transaction of(BigDecimal value, User payer, User payee) {

        if (payer.type() == UserTypeEnum.SELLER) {
            throw new IllegalArgumentException("Payer must be a consumer");
        }

        if (payer.id().equals(payee.id())) {
            throw new IllegalArgumentException("Payer and payee must be different");
        }

        return new Transaction(UUID.randomUUID(), LocalDateTime.now(), value, payer.debit(value), payee.credit(value));
    }
}
