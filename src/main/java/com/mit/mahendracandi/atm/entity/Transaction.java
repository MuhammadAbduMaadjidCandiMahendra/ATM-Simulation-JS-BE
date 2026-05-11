package com.mit.mahendracandi.atm.entity;

import jakarta.persistence.*;
import lombok.Getter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@EntityListeners(AuditingEntityListener.class)
@Getter
@Inheritance(strategy = InheritanceType.JOINED)
public class Transaction {
    public Transaction() {}

    public Transaction(TransactionType transactionType) {
        this.type = transactionType;
    }

    public Transaction(TransactionType transactionType, Account account) {
        this.type = transactionType;
        this.account = account;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Enumerated(EnumType.STRING)
    private TransactionType type;

    @ManyToOne(fetch = FetchType.LAZY)
    private Account account;

    @CreatedDate
    private LocalDateTime createdDate;
}
