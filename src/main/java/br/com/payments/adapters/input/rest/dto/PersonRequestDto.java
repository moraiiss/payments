package br.com.payments.adapters.input.rest.dto;

import br.com.payments.core.domain.vo.PersonTypeEnum;
import jakarta.validation.constraints.NotNull;

public record PersonRequestDto(
    @NotNull String name,
    @NotNull String document,
    @NotNull PersonTypeEnum type,
    @NotNull String email
) {
}
