package br.com.payments.core.usecases;

import br.com.payments.core.domain.entities.Person;
import br.com.payments.core.domain.exceptions.BusinessException;
import br.com.payments.core.ports.input.PersonCreatorPort;
import br.com.payments.core.ports.output.PersonRepositoryPort;
import org.springframework.stereotype.Service;

@Service
public class PersonCreatorUseCase implements PersonCreatorPort {

    private final PersonRepositoryPort personRepositoryPort;

    public PersonCreatorUseCase(PersonRepositoryPort personRepositoryPort) {
        this.personRepositoryPort = personRepositoryPort;
    }

    @Override
    public Person createPerson(Person person) {

        final var foundPersonByDocument = personRepositoryPort.findByDocument(person.document());
        final var foundPersonByEmail = personRepositoryPort.findByEmail(person.email());

        if (foundPersonByDocument.isPresent()) {
            throw new BusinessException("Person already registered with this document!");
        }

        if (foundPersonByEmail.isPresent()) {
            throw new BusinessException("Person already registered with this email!");
        }

        return personRepositoryPort.save(person);
    }
}
