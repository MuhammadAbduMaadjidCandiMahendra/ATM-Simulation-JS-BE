package com.mit.mahendracandi.atm.controller;

import com.mit.mahendracandi.atm.dto.AccountDetailDto;
import com.mit.mahendracandi.atm.dto.WithdrawRequest;
import com.mit.mahendracandi.atm.service.TransactionService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/transaction")
@RequiredArgsConstructor
public class TransactionController {

    private final TransactionService transactionService;

    @PostMapping(path = "/withdraw", produces = "application/json")
    public ResponseEntity<AccountDetailDto> withdraw(@RequestBody WithdrawRequest request) {
        final var withdraw = transactionService.withdraw(request.accountNumber(), request.amount());
        return ResponseEntity.ok(AccountDetailDto.from(withdraw.getAccount()));
    }
}
