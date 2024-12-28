package com.bank;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;


@SpringBootApplication
@EnableConfigurationProperties
public class BankTransactionsApplication {

    public static void main(String[] args) {
        SpringApplication.run(BankTransactionsApplication.class, args);
    }

}
