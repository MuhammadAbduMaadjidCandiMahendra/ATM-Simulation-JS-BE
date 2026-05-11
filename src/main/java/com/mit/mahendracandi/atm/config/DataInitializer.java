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
                    new Account("100001", "1001", "John Doe", 5000L),
                    new Account("100002", "1002", "Jane Smith", 7500L),
                    new Account("100003", "1003", "Michael Johnson", 3200L),
                    new Account("100004", "1004", "Emily Davis", 12000L),
                    new Account("100005", "1005", "David Wilson", 850L),
                    new Account("100006", "1006", "Sarah Brown", 9999L),
                    new Account("100007", "1007", "James Taylor", 4500L),
                    new Account("100008", "1008", "Lisa Anderson", 6200L),
                    new Account("100009", "1009", "Robert Martinez", 15000L),
                    new Account("100010", "1010", "Jennifer Garcia", 2750L)
                );
                repository.saveAll(accounts);
            }
        };
    }
}
