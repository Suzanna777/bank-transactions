package com.bank;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@EnableTransactionManagement
@EntityScan(basePackages = "com.bank")
@EnableJpaRepositories(basePackages = "com.bank.*")

public class BankTransactionsApplication {

    public static void main(String[] args) {
        SpringApplication.run(BankTransactionsApplication.class, args);
    }

}
