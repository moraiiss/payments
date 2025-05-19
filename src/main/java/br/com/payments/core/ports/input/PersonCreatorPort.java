package br.com.payments.core.ports.input;

import br.com.payments.core.domain.entities.Person;

public interface PersonCreatorPort {

    Person createPerson(Person person);

}
