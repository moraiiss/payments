package br.com.payments.adapters.input.rest;

import br.com.payments.adapters.input.rest.dto.PersonRequestDto;
import br.com.payments.adapters.input.rest.mapper.PersonRestMapper;
import br.com.payments.core.domain.entities.Person;
import br.com.payments.core.domain.vo.PersonTypeEnum;
import br.com.payments.core.ports.input.PersonCreatorPort;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/persons")
@Tag(name = "Persons", description = "Endpoints to manage persons able of making and receiving payments")
public class PersonController {

    private final PersonCreatorPort personCreatorPort;

    public PersonController(PersonCreatorPort personCreatorPort) {
        this.personCreatorPort = personCreatorPort;
    }

    @PostMapping
    ResponseEntity<Person> createPerson(@RequestBody PersonRequestDto personRequestDto) {
        final Person person = personCreatorPort
            .createPerson(PersonRestMapper.toDomain(personRequestDto));

        return ResponseEntity
            .status(HttpStatus.CREATED)
            .body(person);
    }

    @GetMapping
    ResponseEntity<List<Person>> listPersons(@RequestParam PersonTypeEnum personTypeEnum) {
        final List<Person> persons = personCreatorPort.listPersons(personTypeEnum);

        return ResponseEntity.ok(persons);
    }
}
