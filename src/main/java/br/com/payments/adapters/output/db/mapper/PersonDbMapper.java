package br.com.payments.adapters.output.db.mapper;

import br.com.payments.adapters.output.db.jpa.entities.PersonEntity;
import br.com.payments.core.domain.entities.Person;

import java.util.List;
import java.util.UUID;

public final class PersonDbMapper {

    private PersonDbMapper() {}

    public static PersonEntity toEntity(final Person person) {
        return new PersonEntity(person.id(), person.uuid().toString(), person.name(), person.document(),
            person.type(), person.email(), person.balance());
    }

    public static Person toDomain(final PersonEntity personEntity) {
        return Person.of(personEntity.getId(), UUID.fromString(personEntity.getUuid()), personEntity.getName(),
            personEntity.getDocument(), personEntity.getType(), personEntity.getEmail(), personEntity.getBalance());
    }

    public static List<Person> toList(final List<PersonEntity> personEntities) {
        return personEntities.stream()
            .map(PersonDbMapper::toDomain)
            .toList();
    }
}
