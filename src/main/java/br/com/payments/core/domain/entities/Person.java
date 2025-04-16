package br.com.payments.core.domain.entities;

import br.com.payments.core.domain.vo.PersonTypeEnum;

import java.math.BigDecimal;
import java.util.UUID;

import static java.util.Objects.requireNonNull;

public record Person(Long id, UUID uuid, String name, String document,
                     PersonTypeEnum type, String email, BigDecimal balance) {

    public Person {
        requireNonNull(document, "Document is required");
        requireNonNull(email, "Email is required");
    }

    public static Person of(Long id, UUID uuid, String name, String document,
                            PersonTypeEnum type, String email, BigDecimal balance) {
        return new Person(id, uuid, name, document, type, email, balance);
    }

    public static Person of(String name, String document,
                            PersonTypeEnum type, String email) {
        return new Person(null, UUID.randomUUID(), name, document, type, email, BigDecimal.ZERO);
    }

    private boolean hasSufficientFunds(BigDecimal value) {
        return balance.compareTo(value) >= 0;
    }

    public Person credit(BigDecimal value) {
        return new Person(id, uuid, name, document, type, email, balance.add(value));
    }

    public Person debit(BigDecimal value) {
        if (!hasSufficientFunds(value)) {
            throw new IllegalArgumentException("Payer has no sufficient balance");
        }
        return new Person(id, uuid, name, document, type, email, balance.subtract(value));
    }
}
