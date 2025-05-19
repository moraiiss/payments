package br.com.payments.adapters.output.db;

import br.com.payments.adapters.output.db.jpa.PersonJpaRepository;
import br.com.payments.adapters.output.db.jpa.entities.PersonEntity;
import br.com.payments.adapters.output.db.mapper.PersonDbMapper;
import br.com.payments.core.domain.entities.Person;
import br.com.payments.core.domain.vo.PersonTypeEnum;
import br.com.payments.core.ports.output.PersonRepositoryPort;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

import static br.com.payments.adapters.output.db.mapper.PersonDbMapper.*;

@Repository
public class PersonRepository implements PersonRepositoryPort {

    private final PersonJpaRepository personJpaRepository;

    public PersonRepository(PersonJpaRepository personJpaRepository) {
        this.personJpaRepository = personJpaRepository;
    }

    @Override
    public Person save(Person person) {
        final PersonEntity savedPerson = personJpaRepository.save(toEntity(person));

        return toDomain(savedPerson);
    }

    @Override
    public Optional<Person> findById(Long id) {
        final Optional<PersonEntity> person = personJpaRepository.findById(id);

        return person.map(PersonDbMapper::toDomain);
    }

    @Override
    public List<Person> findAllByType(PersonTypeEnum personTypeEnum) {
        final List<PersonEntity> persons = personJpaRepository.findAllByType(personTypeEnum);

        return toList(persons);
    }

    @Override
    public Optional<Person> findByEmail(String emailAddress) {
        final Optional<PersonEntity> person = personJpaRepository.findByEmail(emailAddress);

        return person.map(PersonDbMapper::toDomain);
    }

    @Override
    public Optional<Person> findByDocument(String documentNumber) {
        final Optional<PersonEntity> person = personJpaRepository.findByDocument(documentNumber);

        return person.map(PersonDbMapper::toDomain);
    }


}
