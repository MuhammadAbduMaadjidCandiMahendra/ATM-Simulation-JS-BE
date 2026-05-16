package com.mit.mahendracandi.atm.service;

import com.mit.mahendracandi.atm.entity.Account;
import com.mit.mahendracandi.atm.entity.Deposit;
import com.mit.mahendracandi.atm.entity.Transaction;
import com.mit.mahendracandi.atm.entity.Withdraw;
import com.mit.mahendracandi.atm.repository.TransactionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class TransactionService {

    private final TransactionRepository transactionRepository;
    private final AccountService accountService;

    public Transaction withdraw(Account account, Long amount) {
        if (account.getBalance() < amount) {
            throw new IllegalArgumentException("Insufficient balance");
        }

        account.setBalance(account.getBalance() - amount);
        final var withdraw = new Withdraw(amount, account);
        return transactionRepository.save(withdraw);
    }

    @Transactional
    public Transaction withdraw(String accountNumber, Long amount) {
        final var account = accountService.findByAccountNumber(accountNumber)
                .orElseThrow(() -> new IllegalArgumentException("Account not found"));

        return withdraw(account, amount);
    }

    public Transaction deposit(Account account, Long amount) {
        if (amount <= 0) {
            throw new IllegalArgumentException("Amount must be greater than 0");
        }

        account.setBalance(account.getBalance() + amount);
        final var deposit = new Deposit(amount, account);
        return transactionRepository.save(deposit);
    }

    @Transactional
    public Transaction deposit(String accountNumber, Long amount) {
        final var account = accountService.findByAccountNumber(accountNumber)
                .orElseThrow(() -> new IllegalArgumentException("Account not found"));

        return deposit(account, amount);
    }
}
