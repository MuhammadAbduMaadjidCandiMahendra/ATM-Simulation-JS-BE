package com.mit.mahendracandi.atm.config;

import com.mit.mahendracandi.atm.entity.Account;
import com.mit.mahendracandi.atm.repository.AccountRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.math.BigDecimal;
import java.util.List;

@Configuration
public class DataInitializer {

    @Bean
    CommandLineRunner initDatabase(AccountRepository repository) {
        return args -> {
            if (repository.count() == 0) {
                List<Account> accounts = List.of(
                    new Account(null, "1001", "John Doe", new BigDecimal("5000.00")),
                    new Account(null, "1002", "Jane Smith", new BigDecimal("7500.50")),
                    new Account(null, "1003", "Michael Johnson", new BigDecimal("3200.75")),
                    new Account(null, "1004", "Emily Davis", new BigDecimal("12000.00")),
                    new Account(null, "1005", "David Wilson", new BigDecimal("850.25")),
                    new Account(null, "1006", "Sarah Brown", new BigDecimal("9999.99")),
                    new Account(null, "1007", "James Taylor", new BigDecimal("4500.00")),
                    new Account(null, "1008", "Lisa Anderson", new BigDecimal("6200.30")),
                    new Account(null, "1009", "Robert Martinez", new BigDecimal("15000.00")),
                    new Account(null, "1010", "Jennifer Garcia", new BigDecimal("2750.80"))
                );
                repository.saveAll(accounts);
            }
        };
    }
}
