package br.com.payments.core.ports.output;

import br.com.payments.core.domain.entities.Person;
import br.com.payments.core.domain.vo.PersonTypeEnum;

import java.util.List;
import java.util.Optional;

public interface PersonRepositoryPort {

    Person save(Person person);

    Optional<Person> findById(Long id);

    Optional<Person> findByEmail(String emailAddress);

    Optional<Person> findByDocument(String documentNumber);

    List<Person> findAllByType(PersonTypeEnum personTypeEnum);
}
