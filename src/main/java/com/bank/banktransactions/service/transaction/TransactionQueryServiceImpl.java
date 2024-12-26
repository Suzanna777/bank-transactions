package com.bank.banktransactions.service.transaction;

import com.bank.banktransactions.domain.exception.ResourceNotFoundException;
import com.bank.banktransactions.domain.model.Transaction;
import com.bank.banktransactions.repository.TransactionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class TransactionQueryServiceImpl implements TransactionQueryService{
    private final TransactionRepository repository;

    @Override
    public Transaction getByiD(UUID id) {
        return repository.findById(id).orElseThrow(ResourceNotFoundException::new);
    }
}
