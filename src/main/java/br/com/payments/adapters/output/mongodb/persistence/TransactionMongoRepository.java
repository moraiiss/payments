package br.com.payments.adapters.output.mongodb.persistence;

import br.com.payments.adapters.output.mongodb.persistence.entities.TransactionEntity;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface TransactionMongoRepository extends MongoRepository<TransactionEntity, String> {}
