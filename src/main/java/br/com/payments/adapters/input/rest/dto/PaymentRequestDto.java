package br.com.payments.adapters.input.rest.dto;

import java.math.BigDecimal;

public record PaymentRequestDto(
    BigDecimal value,
    Long payer,
    Long payee
) {
}
