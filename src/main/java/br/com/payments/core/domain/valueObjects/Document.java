package br.com.payments.core.domain.valueObjects;

import static java.util.Objects.requireNonNull;

public record Document(String number) {

    public Document {

        requireNonNull(number, "Field document is required");

        if (number.isBlank() || !number.matches("\\d{3}\\.\\d{3}\\.\\d{3}-\\d{2}")) {
            throw new IllegalArgumentException("Invalid document");
        }
    }

    public static Document of(String number) {
        return new Document(number);
    }
}
