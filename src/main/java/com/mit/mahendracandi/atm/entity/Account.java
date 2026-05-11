package com.mit.mahendracandi.atm.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Account {

    @Id
    @Column(unique = true, nullable = false, length = 6)
    private String accountNumber;

    @Column(nullable = false, length = 4)
    private String pin;
    
    @Column(nullable = false)
    private String name;
    
    @Column(nullable = false)
    private Long balance;
}
