package br.com.payments.core.domain.entities;

import br.com.payments.core.domain.vo.PersonTypeEnum;

import java.math.BigDecimal;
import java.util.UUID;

import static java.util.Objects.requireNonNull;

public final class Person {
    private Long id;
    private UUID uuid;
    private String name;
    private String document;
    private PersonTypeEnum type;
    private String email;
    private BigDecimal balance;

    private Person(Long id, UUID uuid, String name, String document,
                   PersonTypeEnum type, String email, BigDecimal balance) {
        this.id = id;
        this.uuid = uuid;
        this.name = requireNonNull(name, "Name is required");
        this.document = requireNonNull(document, "Document is required");
        this.type = requireNonNull(type, "Type is required");
        this.email = requireNonNull(email, "Email is required");
    }

    public static Person of(Long id, UUID uuid, String name, String document,
                            PersonTypeEnum type, String email, BigDecimal balance) {
        return new Person(id, uuid, name, document, type, email, balance);
    }

    public static Person of(String name, String document,
                            PersonTypeEnum type, String email) {
        return new Person(null, UUID.randomUUID(), name, document, type, email, BigDecimal.ZERO);
    }

    public Person credit(BigDecimal value) {
        return Person.of(id, uuid, name, document, type, email, balance.add(value));
    }

    public Person debit(BigDecimal value) {
        if (!hasSufficientFunds(value)) {
            throw new IllegalArgumentException("Payer has no sufficient balance");
        }
        return Person.of(id, uuid, name, document, type, email, balance.subtract(value));
    }

    private boolean hasSufficientFunds(BigDecimal value) {
        return balance.compareTo(value) >= 0;
    }

    public Long id() {
        return id;
    }

    public UUID uuid() {
        return uuid;
    }

    public String name() {
        return name;
    }

    public String document() {
        return document;
    }

    public PersonTypeEnum type() {
        return type;
    }

    public String email() {
        return email;
    }

    public BigDecimal balance() {
        return balance;
    }
}
