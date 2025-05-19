package br.com.payments.core.ports.input;

import br.com.payments.core.domain.entities.Person;
import br.com.payments.core.domain.vo.PersonTypeEnum;

import java.util.List;

public interface GetPersonPort {

    List<Person> listPersons(PersonTypeEnum personTypeEnum);

}
