package br.com.payments.adapters.input.rest.mapper;

import br.com.payments.adapters.input.rest.dto.PaymentRequestDto;
import br.com.payments.core.domain.entities.Payment;

public final class PaymentRestMapper {

    private PaymentRestMapper() {}

    public static Payment toDomain(final PaymentRequestDto paymentRequestDto) {
        return Payment.of(paymentRequestDto.value(), paymentRequestDto.payer(), paymentRequestDto.payee());
    }

}
