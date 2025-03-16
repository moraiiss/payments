package br.com.payments.adapters.output.mongodb.persistence.entities;

import br.com.payments.core.domain.entities.Transaction;
import br.com.payments.core.domain.entities.User;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "transactions")
public class TransactionEntity {
    @Id
    private String id = UUID.randomUUID().toString();
    private UUID transactionId;
    private User payer;
    private User payee;
    private BigDecimal amount;
    private LocalDateTime transactionDate;

    public static TransactionEntity of(Transaction transaction) {
        return new TransactionEntity(
                null,
                transaction.transactionId(),
                transaction.payer(),
                transaction.payee(),
                transaction.value(),
                transaction.transactionDate()
        );
    }
}
