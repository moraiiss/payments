package br.com.payments.core.domain.valueObjects;

import static java.util.Objects.requireNonNull;

public record Email(String address) {

    public Email {

        requireNonNull(address, "Field email is required");

        if (address.isBlank() || !address.matches("^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,6}$")) {
            throw new IllegalArgumentException("Invalid email");
        }
    }

    public static Email of(String address) {
        return new Email(address);
    }
}
