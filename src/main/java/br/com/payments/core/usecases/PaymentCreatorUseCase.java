package br.com.payments.core.usecases;

import br.com.payments.core.domain.entities.Payment;
import br.com.payments.core.domain.entities.Person;
import br.com.payments.core.domain.exceptions.PersonNotFoundException;
import br.com.payments.core.domain.vo.PersonTypeEnum;
import br.com.payments.core.ports.input.PaymentCreatorPort;
import br.com.payments.core.ports.output.PersonRepositoryPort;
import org.springframework.stereotype.Service;

@Service
public class PaymentCreatorUseCase implements PaymentCreatorPort {

    private final PersonRepositoryPort personRepositoryPort;

    public PaymentCreatorUseCase(PersonRepositoryPort personRepositoryPort) {
        this.personRepositoryPort = personRepositoryPort;
    }

    @Override
    public Payment createPayment(Payment payment) {
        Person payer = personRepositoryPort
            .findById(payment.payer())
            .orElseThrow(() -> new PersonNotFoundException(payment.payer()));

        Person payee = personRepositoryPort
            .findById(payment.payee())
            .orElseThrow(() -> new PersonNotFoundException(payment.payee()));

        if (payer.type() == PersonTypeEnum.SELLER) {
            throw new IllegalArgumentException("Payer must be a consumer");
        }

        final var updatedPayer = payer.debit(payment.value());
        final var updatedPayee = payee.credit(payment.value());

        personRepositoryPort.save(updatedPayer);
        personRepositoryPort.save(updatedPayee);

        return payment;
    }
}
