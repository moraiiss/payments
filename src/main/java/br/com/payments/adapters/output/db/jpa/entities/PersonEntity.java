package br.com.payments.adapters.output.db.jpa.entities;

import br.com.payments.core.domain.vo.PersonTypeEnum;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.math.BigDecimal;

@Entity(name = "persons")
public class PersonEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String uuid;

    private String name;

    private String document;

    private PersonTypeEnum type;

    private String email;

    private BigDecimal balance;

    public PersonEntity(Long id, String uuid, String name, String document, PersonTypeEnum type, String email, BigDecimal balance) {
        this.id = id;
        this.uuid = uuid;
        this.name = name;
        this.document = document;
        this.type = type;
        this.email = email;
        this.balance = balance;
    }

    public PersonEntity() { this(null, null, null, null, null, null, null); }

    public Long getId() { return id; }

    public void setId(Long id) { this.id = id; }

    public String getUuid() { return uuid; }

    public void setUuid(String uuid) { this.uuid = uuid; }

    public String getName() { return name; }

    public void setName(String name) { this.name = name; }

    public String getDocument() { return document; }

    public void setDocument(String document) { this.document = document; }

    public PersonTypeEnum getType() { return type; }

    public void setType(PersonTypeEnum type) { this.type = type; }

    public String getEmail() { return email; }

    public void setEmail(String email) { this.email = email; }

    public BigDecimal getBalance() { return balance; }

    public void setBalance(BigDecimal balance) { this.balance = balance; }
}
