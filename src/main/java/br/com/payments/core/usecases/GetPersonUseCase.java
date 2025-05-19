package br.com.payments.core.usecases;

import br.com.payments.adapters.output.db.PersonRepository;
import br.com.payments.core.domain.entities.Person;
import br.com.payments.core.domain.vo.PersonTypeEnum;
import br.com.payments.core.ports.input.GetPersonPort;
import br.com.payments.core.ports.output.PersonRepositoryPort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GetPersonUseCase implements GetPersonPort {

    private final PersonRepositoryPort personRepositoryPort;

    public GetPersonUseCase(final PersonRepository personRepository) {
        this.personRepositoryPort = personRepository;
    }

    @Override
    public List<Person> listPersons(final PersonTypeEnum personTypeEnum) {
        return personRepositoryPort.findAllByType(personTypeEnum);
    }
}
