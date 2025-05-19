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
            .findById(payment.getPayer())
            .orElseThrow(() -> new PersonNotFoundException(payment.getPayer()));

        Person payee = personRepositoryPort
            .findById(payment.getPayee())
            .orElseThrow(() -> new PersonNotFoundException(payment.getPayee()));

        if (payer.type() == PersonTypeEnum.SELLER) {
            throw new IllegalArgumentException("Payer must be a consumer");
        }

        final var updatedPayer = payer.debit(payment.getValue());
        final var updatedPayee = payee.credit(payment.getValue());

        personRepositoryPort.save(updatedPayer);
        personRepositoryPort.save(updatedPayee);

        return payment;
    }
}
