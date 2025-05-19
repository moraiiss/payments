### ms-payments-api

### Objetivo

Sendo dois tipos de usuários, os comuns e os lojistas, ambos têm carteira com dinheiro e realizam transferências entre eles.
Vamos nos atentar somente ao fluxo de transferência entre dois usuários.

### Requisitos

- Para ambos tipos de usuários, precisamos do Nome Completo, CPF, e-mail e Senha. CPF/CNPJ e e-mails devem ser únicos no sistema. Sendo assim, seu sistema deve permitir apenas um cadastro com o mesmo CPF ou endereço de e-mail.
- Usuários comuns (clientes) só podem enviar dinheiro para lojistas e entre usuários comuns.
- Lojistas só recebem transferências, não enviam dinheiro para ninguém.
- Deve validar se o usuário tem saldo antes da transferência.
- Antes de finalizar a transferência, deve-se consultar um serviço autorizador externo.
- A operação de transferência deve ser uma transação (ou seja, revertida em qualquer caso de inconsistência) e o dinheiro deve voltar para a carteira do usuário que envia.
- No recebimento de pagamento, o usuário ou lojista precisa receber notificação (envio de email, sms) enviada por um serviço de terceiro. E eventualmente este serviço pode estar indisponível/instável.

### Stack

- Java 21
- MySQL 8
- Spring Boot 3.4.2
- Maven

