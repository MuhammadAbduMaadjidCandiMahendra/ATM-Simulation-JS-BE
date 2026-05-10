package com.mit.mahendracandi.atm.controller;

import com.mit.mahendracandi.atm.dto.AccountDetailDto;
import com.mit.mahendracandi.atm.entity.Account;
import com.mit.mahendracandi.atm.service.AccountService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/account")
@RequiredArgsConstructor
public class AccountController {

    private final AccountService accountService;

    @GetMapping(produces = "application/json")
    public ResponseEntity<AccountDetailDto> getAccount(String accountNumber) {
        final var account = accountService.findByAccountNumber(accountNumber);

        if (account.isEmpty()) {
            throw new IllegalArgumentException("Account not found");
        }

        Account acc = account.get();
        AccountDetailDto response = new AccountDetailDto(
                acc.getAccountNumber(),
                acc.getName(),
                acc.getBalance()
        );

        return ResponseEntity.ok(response);
    }
}
