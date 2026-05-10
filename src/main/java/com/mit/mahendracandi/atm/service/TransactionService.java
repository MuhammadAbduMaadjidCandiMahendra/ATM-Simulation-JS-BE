package com.mit.mahendracandi.atm.service;

import com.mit.mahendracandi.atm.entity.Account;
import com.mit.mahendracandi.atm.entity.Transaction;
import com.mit.mahendracandi.atm.entity.Withdraw;
import com.mit.mahendracandi.atm.repository.TransactionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

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

    public Transaction withdraw(String accountNumber, Long amount) {
        final var account = accountService.findByAccountNumber(accountNumber)
                .orElseThrow(() -> new IllegalArgumentException("Account not found"));

        return withdraw(account, amount);
    }
}
