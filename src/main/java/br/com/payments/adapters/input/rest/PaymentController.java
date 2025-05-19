package br.com.payments.adapters.input.rest;

import br.com.payments.adapters.input.rest.dto.PaymentRequestDto;
import br.com.payments.adapters.input.rest.mapper.PaymentRestMapper;
import br.com.payments.core.domain.entities.Payment;
import br.com.payments.core.ports.input.PaymentCreatorPort;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static br.com.payments.adapters.input.rest.mapper.PaymentRestMapper.*;

@RestController
@RequestMapping("payments")
public class PaymentController {

    private final PaymentCreatorPort paymentCreatorPort;

    public PaymentController(PaymentCreatorPort paymentCreatorPort) {
        this.paymentCreatorPort = paymentCreatorPort;
    }

    @PostMapping(
        produces = MediaType.APPLICATION_JSON_VALUE
    )
    @Operation(
        method = "createPayment",
        summary = "Create a new payment",
        description = "Return a realized payment with payer and payee"
    )
    ResponseEntity<Payment> createPayment(@RequestBody PaymentRequestDto paymentRequestDto) {
        Payment payment = paymentCreatorPort
            .createPayment(toDomain(paymentRequestDto));

        return ResponseEntity.status(HttpStatus.CREATED).body(payment);
    }
}
