package br.com.payments.adapters.input.rest.mapper;

import br.com.payments.adapters.input.rest.dto.PaymentRequestDto;
import br.com.payments.core.domain.entities.Payment;

public class PaymentRestMapper {

    public static Payment toDomain(PaymentRequestDto paymentRequestDto) {
        return Payment.of(paymentRequestDto.value(), paymentRequestDto.payer(), paymentRequestDto.payee());
    }

}
