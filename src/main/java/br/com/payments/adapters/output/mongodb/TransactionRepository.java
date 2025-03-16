package br.com.payments.adapters.output.mongodb;

import br.com.payments.adapters.output.mongodb.mapper.TransactionDbMapper;
import br.com.payments.adapters.output.mongodb.persistence.TransactionMongoRepository;
import br.com.payments.core.domain.entities.Transaction;
import br.com.payments.core.ports.output.TransactionRepositoryPort;
import org.springframework.stereotype.Repository;

@Repository
public class TransactionRepository implements TransactionRepositoryPort {
    private final TransactionMongoRepository transactionMongoRepository;

    public TransactionRepository(TransactionMongoRepository transactionMongoRepository) {
        this.transactionMongoRepository = transactionMongoRepository;
    }

    @Override
    public Transaction save(Transaction transaction) {
        final var savedTransactionEntity = transactionMongoRepository
                .save(TransactionDbMapper.toEntity(transaction));

        return TransactionDbMapper
                .toDomain(savedTransactionEntity);
    }
}
