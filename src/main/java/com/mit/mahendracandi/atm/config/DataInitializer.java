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
                    new Account(null, "100001", "John Doe", 5000L),
                    new Account(null, "100002", "Jane Smith", 7500L),
                    new Account(null, "100003", "Michael Johnson", 3200L),
                    new Account(null, "100004", "Emily Davis", 12000L),
                    new Account(null, "100005", "David Wilson", 850L),
                    new Account(null, "100006", "Sarah Brown", 9999L),
                    new Account(null, "100007", "James Taylor", 4500L),
                    new Account(null, "100008", "Lisa Anderson", 6200L),
                    new Account(null, "100009", "Robert Martinez", 15000L),
                    new Account(null, "100010", "Jennifer Garcia", 2750L)
                );
                repository.saveAll(accounts);
            }
        };
    }
}
