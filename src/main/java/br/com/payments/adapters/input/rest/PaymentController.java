package br.com.payments.adapters.input.rest;

import br.com.payments.adapters.input.rest.dto.PaymentRequestDto;
import br.com.payments.adapters.input.rest.mapper.PaymentRestMapper;
import br.com.payments.core.domain.entities.Payment;
import br.com.payments.core.ports.input.PaymentCreatorPort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("payments")
public class PaymentController {

    private final PaymentCreatorPort paymentCreatorPort;

    public PaymentController(PaymentCreatorPort paymentCreatorPort) {
        this.paymentCreatorPort = paymentCreatorPort;
    }

    @PostMapping
    ResponseEntity<?> createPayment(@RequestBody PaymentRequestDto paymentRequestDto) {
        Payment payment = paymentCreatorPort
            .createPayment(PaymentRestMapper.toDomain(paymentRequestDto));

        return ResponseEntity.status(HttpStatus.CREATED).body(payment);
    }
}
