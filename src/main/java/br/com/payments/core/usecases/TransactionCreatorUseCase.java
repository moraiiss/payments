package br.com.payments.core.usecases;

import br.com.payments.core.domain.entities.Transaction;
import br.com.payments.core.ports.input.TransactionCreatorPort;
import br.com.payments.core.ports.output.TransactionRepositoryPort;
import org.springframework.stereotype.Service;

@Service
public class TransactionCreatorUseCase implements TransactionCreatorPort {
    private final TransactionRepositoryPort transactionRepositoryPort;

    public TransactionCreatorUseCase(TransactionRepositoryPort transactionRepositoryPort) {
        this.transactionRepositoryPort = transactionRepositoryPort;
    }

    @Override
    public Transaction createTransaction(Transaction transaction) {
        return transactionRepositoryPort
                .save(transaction);
    }
}
