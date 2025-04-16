package br.com.payments.core.domain.entities;

import java.math.BigDecimal;

public record Payment (BigDecimal value, Long payer, Long payee) {

    public Payment {

        if (value.compareTo(BigDecimal.ZERO) == 0) {
            throw new IllegalArgumentException("Payment amount cannot be zero");
        }

        if (payer.equals(payee)) {
            throw new IllegalArgumentException("Payer not should be equal payee");
        }
    }

    public static Payment of(BigDecimal value, Long payer, Long payee) {
        return new Payment(value, payer, payee);
    }
}
