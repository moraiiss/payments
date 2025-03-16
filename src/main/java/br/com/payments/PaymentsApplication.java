package br.com.payments;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class PaymentsApplication {

	public static void main(String[] args) {
//		User consumer = new User(
//				UUID.fromString("de85be94-0915-48cf-85c1-00519228e760"),
//				UserTypeEnum.CONSUMER,
//				"Comprador",
//				Document.of("123.456.789-00"),
//				Email.of("mail@consumer.com"),
//				BigDecimal.valueOf(100L)
//		);
//		System.out.println("Consumer criado " + consumer);
//
//		User seller = new User(
//				UUID.fromString("de85be94-0915-48cf-85c1-00519228e761"),
//				UserTypeEnum.SELLER,
//				"Vendedor",
//				Document.of("123.456.789-00"),
//				Email.of("mail@seller.com"),
//				BigDecimal.valueOf(100L)
//		);
//		System.out.println("Seller criado " + seller);
//
//		System.out.println("-------------------------");
//
//		System.out.println("Saldo do consumer " + consumer.balance());
//		System.out.println("Saldo do vendedor " + seller.balance());
//
//		System.out.println("-------------------------");
//
//		Transaction transaction = Transaction.of(BigDecimal.valueOf(1000L), consumer, seller);
//		System.out.println("Transação criada " + transaction);
//
//		System.out.println("Saldo do consumer " + transaction.payer().balance());
//		System.out.println("Saldo do vendedor " + transaction.payee().balance());

		SpringApplication.run(PaymentsApplication.class, args);
	}

}
