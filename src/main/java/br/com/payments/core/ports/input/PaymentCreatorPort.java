package br.com.payments.core.ports.input;

import br.com.payments.core.domain.entities.Payment;

public interface PaymentCreatorPort {

    Payment createPayment(Payment payment);

}
