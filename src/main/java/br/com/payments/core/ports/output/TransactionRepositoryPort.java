package br.com.payments.core.ports.output;

import br.com.payments.core.domain.entities.Transaction;

public interface TransactionRepositoryPort {
    Transaction save(Transaction transaction);
}
