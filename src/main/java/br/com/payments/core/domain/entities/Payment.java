package br.com.payments.core.domain.entities;

import java.math.BigDecimal;

public final class Payment {
    private final BigDecimal value;
    private Long payer;
    private Long payee;

    private Payment (BigDecimal value, Long payer, Long payee) {

        if (value.compareTo(BigDecimal.ZERO) == 0) {
            throw new IllegalArgumentException("Payment amount cannot be zero");
        }

        if (payer.equals(payee)) {
            throw new IllegalArgumentException("Payer not should be equal payee");
        }

        this.value = value;
        this.payer = payer;
        this.payee = payee;
    }

    public static Payment of(BigDecimal value, Long payer, Long payee) {
        return new Payment(value, payer, payee);
    }

    public BigDecimal getValue() {
        return value;
    }

    public Long getPayee() {
        return payee;
    }

    public Long getPayer() {
        return payer;
    }
}
