package com.bank.service.transaction;

import com.bank.domain.exception.ResourceNotFoundException;
import com.bank.domain.model.Transaction;
import com.bank.repository.TransactionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class TransactionQueryServiceImpl implements TransactionQueryService{

    private final TransactionRepository repository;


    @Override
    public Transaction getById(final UUID id) {
        return repository.findById(id).orElseThrow(ResourceNotFoundException::new);
    }


}
