package com.mit.mahendracandi.atm.entity;

import jakarta.persistence.Entity;
import lombok.Getter;

@Entity
@Getter
public class Deposit extends Transaction {
    public Deposit() {
        super(TransactionType.DEPOSIT);
    }

    public Deposit(Long amount, Account account) {
        super(TransactionType.DEPOSIT, account);
        this.amount = amount;
    }

    private Long amount;
}
