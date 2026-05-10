package com.mit.mahendracandi.atm.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.mit.mahendracandi.atm.entity.Transaction;
import com.mit.mahendracandi.atm.entity.TransactionType;
import com.mit.mahendracandi.atm.entity.Withdraw;

import java.time.LocalDateTime;
import java.util.UUID;

// todo add account information
public record WithdrawResponse(
        UUID id,
        TransactionType type,
        long amount,
        String accountNumber,
        @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
        LocalDateTime createdDate
) {
    public static WithdrawResponse from(Transaction transaction) {
        final var withdraw = (Withdraw) transaction;
        return new WithdrawResponse(
                withdraw.getId(),
                withdraw.getType(),
                withdraw.getAmount(),
                withdraw.getAccount().getAccountNumber(),
                withdraw.getCreatedDate()
        );
    }
}
