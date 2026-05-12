package com.mit.mahendracandi.atm.dto;

import com.mit.mahendracandi.atm.entity.Account;

public record AccountDetailDto(String accountNumber, String name, Long balance) {
    public static AccountDetailDto from(Account account) {
        return new AccountDetailDto(account.getAccountNumber(), account.getName(), account.getBalance());
    }
}
