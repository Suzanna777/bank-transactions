package com.bank.service.account;

import com.bank.domain.exception.ResourceNotFoundException;
import com.bank.domain.model.Account;
import com.bank.repository.AccountRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class AccountQueryServiceImpl implements AccountQueryService{

    private final AccountRepository repository;

    @Override
    public Account getByiD(final UUID id) {
        return repository.findById(id).orElseThrow(ResourceNotFoundException::new);
    }
}
