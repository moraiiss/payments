package br.com.payments.adapters.input.rest.dto;

import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;

public record PaymentRequestDto(
    @NotNull BigDecimal value,
    @NotNull Long payer,
    @NotNull Long payee
) {
}
