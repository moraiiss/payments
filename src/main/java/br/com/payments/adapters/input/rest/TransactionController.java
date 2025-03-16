package br.com.payments.adapters.input.rest;

import br.com.payments.adapters.input.rest.dto.TransactionRequestDto;
import br.com.payments.adapters.input.rest.mapper.TransactionRestMapper;
import br.com.payments.core.ports.input.TransactionCreatorPort;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Tag(name = "Transactions", description = "Endpoints for manager transactions")
@Validated
public class TransactionController {
    private final TransactionCreatorPort transactionCreatorPort;

    public TransactionController(TransactionCreatorPort transactionCreatorPort) {
        this.transactionCreatorPort = transactionCreatorPort;
    }

    @PostMapping("/transactions")
    public ResponseEntity<?> createTransaction(
            @RequestBody @Valid final TransactionRequestDto transactionRequestDto
    ) {

        final var transaction = transactionCreatorPort
                .createTransaction(TransactionRestMapper.toDomain(transactionRequestDto));

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(transaction);
    }
}
