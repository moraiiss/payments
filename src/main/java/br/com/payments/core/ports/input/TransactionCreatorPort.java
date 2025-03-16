package br.com.payments.core.ports.input;

import br.com.payments.core.domain.entities.Transaction;

public interface TransactionCreatorPort {
    Transaction createTransaction(Transaction transaction);
}
