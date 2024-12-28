package com.bank.service.client;

import com.bank.domain.exception.ResourceNotFoundException;
import com.bank.domain.model.Client;
import com.bank.repository.ClientRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class ClientQueryServiceImpl implements ClientQueryService{

    private final ClientRepository repository;

    @Override
    public Client getByiD(final UUID id) {
        return repository.findById(id).orElseThrow(ResourceNotFoundException::new);
    }

    @Override
    public Client getByUsername(final String username) {
        return repository.findByUsername(username)
                .orElseThrow(ResourceNotFoundException::new);
    }

    @Override
    public boolean existsByUsername(final String username) {
        return repository.existsByUsername(username);
    }

    @Override
    public Client getByAccount(final UUID accountId) {
        return repository.findByAccountId(accountId)
                .orElseThrow(ResourceNotFoundException::new);
    }
}
