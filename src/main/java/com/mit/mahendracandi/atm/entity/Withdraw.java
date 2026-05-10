package com.mit.mahendracandi.atm.entity;

import jakarta.persistence.Entity;
import lombok.*;

@Entity
@Getter
public class Withdraw extends Transaction {
    public Withdraw() {
        super(TransactionType.WITHDRAW);
    }

    public Withdraw(Long amount, Account account) {
        super(TransactionType.WITHDRAW, amount, account);
    }
}
