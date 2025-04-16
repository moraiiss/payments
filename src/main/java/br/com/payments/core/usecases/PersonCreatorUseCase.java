package br.com.payments.core.usecases;

import br.com.payments.core.domain.entities.Person;
import br.com.payments.core.domain.vo.PersonTypeEnum;
import br.com.payments.core.ports.input.PersonCreatorPort;
import br.com.payments.core.ports.output.PersonRepositoryPort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonCreatorUseCase implements PersonCreatorPort {

    private final PersonRepositoryPort personRepositoryPort;

    public PersonCreatorUseCase(PersonRepositoryPort personRepositoryPort) {
        this.personRepositoryPort = personRepositoryPort;
    }

    @Override
    public Person createPerson(Person person) {
        return personRepositoryPort.save(person);
    }

    @Override
    public List<Person> listPersons(PersonTypeEnum personTypeEnum) {
        return personRepositoryPort.findAllByType(personTypeEnum);
    }

}
