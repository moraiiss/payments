package br.com.payments.adapters.input.rest;

import br.com.payments.adapters.input.rest.dto.PersonRequestDto;
import br.com.payments.core.domain.entities.Person;
import br.com.payments.core.domain.vo.PersonTypeEnum;
import br.com.payments.core.ports.input.GetPersonPort;
import br.com.payments.core.ports.input.PersonCreatorPort;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static br.com.payments.adapters.input.rest.mapper.PersonRestMapper.toDomain;

@RestController
@RequestMapping("/persons")
@Tag(name = "Persons", description = "Endpoints to manage persons able of making and receiving payments")
public class PersonController {

    private final PersonCreatorPort personCreatorPort;

    private final GetPersonPort getPersonPort;

    public PersonController(final PersonCreatorPort personCreatorPort, final GetPersonPort getPersonPort) {
        this.personCreatorPort = personCreatorPort;
        this.getPersonPort = getPersonPort;
    }

    @PostMapping(
        produces = MediaType.APPLICATION_JSON_VALUE,
        consumes = MediaType.APPLICATION_JSON_VALUE
    )
    @Operation(
        method = "createPerson",
        summary = "Create a person for applicable transaction",
        description = "Return a person created with ID for use in new transaction"
    )
    ResponseEntity<Person> createPerson(@RequestBody PersonRequestDto personRequestDto) {
        final Person person = personCreatorPort
            .createPerson(toDomain(personRequestDto));

        return ResponseEntity
            .status(HttpStatus.CREATED)
            .body(person);
    }

    @GetMapping(
        produces = MediaType.APPLICATION_JSON_VALUE
    )
    @Operation(
        method = "listPersons",
        summary = "List all persons created",
        description = "Return a lista of the persons"
    )
    ResponseEntity<List<Person>> listPersons(@RequestParam PersonTypeEnum personTypeEnum) {
        final List<Person> persons = getPersonPort.listPersons(personTypeEnum);

        return ResponseEntity.ok(persons);
    }
}
