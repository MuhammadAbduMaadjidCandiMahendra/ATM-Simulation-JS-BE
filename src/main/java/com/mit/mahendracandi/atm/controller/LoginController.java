package com.mit.mahendracandi.atm.controller;

import com.mit.mahendracandi.atm.dto.LoginRequest;
import com.mit.mahendracandi.atm.dto.LoginResponse;
import com.mit.mahendracandi.atm.entity.Account;
import com.mit.mahendracandi.atm.service.AccountService;
import org.springframework.http.ResponseEntity;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping
public class LoginController {
    
    private final AccountService accountService;

    public LoginController(AccountService accountService) {
        this.accountService = accountService;
    }

    @PostMapping("/login")
    public ResponseEntity<LoginResponse> login(@RequestBody LoginRequest request) {
        if (ObjectUtils.isEmpty(request.accountNumber())) {
            throw new IllegalArgumentException("Account number cannot be empty");
        }
        
        Optional<Account> account = accountService.findByAccountNumber(request.accountNumber());

        if (account.isEmpty()) {
            throw new IllegalArgumentException("Account not found");
        }

        Account acc = account.get();
        LoginResponse response = new LoginResponse(
                acc.getAccountNumber(),
                acc.getName(),
                acc.getBalance()
        );
        return ResponseEntity.ok(response);
    }
}
