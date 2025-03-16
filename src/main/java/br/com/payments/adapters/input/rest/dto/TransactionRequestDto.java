package br.com.payments.adapters.input.rest.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;
import java.util.UUID;

public record TransactionRequestDto(
        @NotEmpty @NotNull BigDecimal value,
        @NotEmpty @NotNull @Schema(example = "de85be94-0915-48cf-85c1-00519228e761") UUID payer,
        @NotEmpty @NotNull @Schema(example = "db3deefa-bdaa-4333-ae16-5cd1f5d9cf32") UUID payee
) {
}
