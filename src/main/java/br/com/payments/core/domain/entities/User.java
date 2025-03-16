package br.com.payments.core.domain.entities;

import br.com.payments.core.domain.valueObjects.Document;
import br.com.payments.core.domain.valueObjects.Email;
import br.com.payments.core.domain.valueObjects.UserTypeEnum;

import java.math.BigDecimal;
import java.util.UUID;

public record User(
        UUID id,
        UserTypeEnum type,
        String name,
        Document document,
        Email email,
        BigDecimal balance
) {
    public User credit(BigDecimal value) {
        return new User(id, type, name, document, email, balance.add(value));
    }

    public User debit(BigDecimal value) {

        if (!hasSufficientFunds(value)) { throw new IllegalArgumentException("Insufficient funds"); }

        return new User(id, type, name, document, email, balance.subtract(value));
    }

    private boolean hasSufficientFunds(BigDecimal amount) {
        return balance.compareTo(amount) >= 0;
    }
}
