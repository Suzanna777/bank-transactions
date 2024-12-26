package com.bank.banktransactions.service.client;

import com.bank.banktransactions.domain.exception.ResourceNotFoundException;
import com.bank.banktransactions.domain.model.Client;
import com.bank.banktransactions.repository.ClientRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class ClientQueryServiceImpl implements ClientQueryService{
    private final ClientRepository repository;

    @Override
    public Client getByiD(UUID id) {
        return repository.findById(id).orElseThrow(ResourceNotFoundException::new);
    }
}
