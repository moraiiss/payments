package br.com.payments.adapters.input.rest.dto;

import br.com.payments.core.domain.vo.PersonTypeEnum;

public record PersonRequestDto(
    String name,
    String document,
    PersonTypeEnum type,
    String email
) {
}
