package br.com.payments.adapters.input.rest.mapper;

import br.com.payments.adapters.input.rest.dto.TransactionRequestDto;
import br.com.payments.core.domain.entities.Transaction;
import br.com.payments.core.domain.entities.User;
import br.com.payments.core.domain.valueObjects.Document;
import br.com.payments.core.domain.valueObjects.Email;
import br.com.payments.core.domain.valueObjects.UserTypeEnum;

import java.math.BigDecimal;

public class TransactionRestMapper {

    public static Transaction toDomain(final TransactionRequestDto dto) {
        User consumer = new User(
                dto.payer(),
                UserTypeEnum.CONSUMER,
                "Comprador",
                Document.of("123.456.789-00"),
                Email.of("mail@consumer.com"),
                BigDecimal.valueOf(100L)
        );

        User seller = new User(
                dto.payee(),
                UserTypeEnum.SELLER,
                "Vendedor",
                Document.of("123.456.789-00"),
                Email.of("mail@seller.com"),
                BigDecimal.valueOf(100L)
        );

        return Transaction.of(dto.value(), consumer, seller);
    }

}
