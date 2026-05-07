package com.mit.mahendracandi.atm.dto;

import java.math.BigDecimal;

public record LoginResponse(String accountNumber, String name, BigDecimal balance) {
}
