package br.com.payments.adapters.input.rest.mapper;

import br.com.payments.adapters.input.rest.dto.PersonRequestDto;
import br.com.payments.core.domain.entities.Person;

public class PersonRestMapper {
    public static Person toDomain(final PersonRequestDto personRequestDto) {
        return Person.of(personRequestDto.name(), personRequestDto.document(),
            personRequestDto.type(), personRequestDto.email());
    }
}
