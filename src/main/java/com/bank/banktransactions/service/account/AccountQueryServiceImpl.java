package com.bank.banktransactions.service.account;

import com.bank.banktransactions.domain.exception.ResourceNotFoundException;
import com.bank.banktransactions.domain.model.Account;
import com.bank.banktransactions.repository.AccountRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class AccountQueryServiceImpl implements AccountQueryService{
    private final AccountRepository repository;


    @Override
    public Account getByiD(UUID id) {
        return repository.findById(id).orElseThrow(ResourceNotFoundException::new);
    }
}
