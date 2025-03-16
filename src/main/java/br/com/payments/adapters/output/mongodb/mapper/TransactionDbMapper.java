package br.com.payments.adapters.output.mongodb.mapper;

import br.com.payments.adapters.output.mongodb.persistence.entities.TransactionEntity;
import br.com.payments.core.domain.entities.Transaction;

public class TransactionDbMapper {

    public static TransactionEntity toEntity(final Transaction transaction) {
        return TransactionEntity.of(transaction);
    }

    public static Transaction toDomain(final TransactionEntity entity) {
        return Transaction
                .of(entity.getAmount(), entity.getPayer(), entity.getPayee());
    }
}
